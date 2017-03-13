package org.usfirst.frc.team3539.robot.autoncommands;

import org.usfirst.frc.team3539.robot.Robot;
import org.usfirst.frc.team3539.robot.RobotMap;
import org.usfirst.frc.team3539.robot.utilities.BulldogPIDOutput;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class AutonDriveWithVision extends PIDCommand
{
	private double myTicks;
		private BulldogPIDOutput pidOutput = new BulldogPIDOutput();
		private PIDController anglePID;
	  
		//private final PIDOutput angle_output = useAnglePIDOutput;
	  /**
	   * A source which calls {@link PIDCommand#returnPIDInput()}.
	   */
	  private final PIDSource angle_output_source = new PIDSource() {
	    public void setPIDSourceType(PIDSourceType pidSource) {
	    }
	
	    public PIDSourceType getPIDSourceType() {
	      return PIDSourceType.kDisplacement;
	    }
	
	    public double pidGet() {
	      return returnAnglePIDInput();
	    }
	  };

	public AutonDriveWithVision(double inches)
	{
		super("test", RobotMap.drivePea, RobotMap.driveEye, RobotMap.driveDee);
		Robot.driveTrain.zeroEncoders();
		myTicks = Robot.driveTrain.inchToEnc(inches);
		requires(Robot.driveTrain);
		
		this.getPIDController().setOutputRange(-.7, .7);
		setSetpoint(myTicks);
	}
	public double returnAnglePIDInput()
	{
		return Robot.raspberry.getAngle();
	}

	protected void initialize()
	{
		Robot.raspberry.UpdateCamera(0);
		anglePID = new PIDController(RobotMap.turnPea, RobotMap.turnEye, RobotMap.turnDee, angle_output_source, pidOutput);
		anglePID.setSetpoint(0);
		pidOutput.Reset();
		
		this.getPIDController().setPID(RobotMap.drivePea, RobotMap.driveEye, RobotMap.driveDee);
		Robot.driveTrain.zeroEncoders();
		this.setSetpoint(myTicks);
		this.getPIDController().setAbsoluteTolerance(2000);
		
		anglePID.enable();
	}

	protected void execute()
	{
		
	}

	protected boolean isFinished()
	{
		if(anglePID.onTarget() || Robot.raspberry.getDistance() < 1)
		{
			anglePID.disable();
			pidOutput.Reset();
		}
		return this.getPIDController().onTarget();
	}

	protected void end()
	{
		Robot.driveTrain.zeroEncoders();
		Robot.driveTrain.stopTrain();
		anglePID.disable();
		pidOutput.Reset();
	}

	protected void interrupted()
	{
		System.out.println("AutonDrive interrupted");
		end();
	}

	@Override
	protected double returnPIDInput()
	{
		return Robot.driveTrain.getBalancedEncoderPosition();
	}

	@Override
	protected void usePIDOutput(double output)
	{
		Robot.driveTrain.driveArcade(output, pidOutput.Get());
	}
}