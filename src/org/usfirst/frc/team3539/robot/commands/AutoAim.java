package org.usfirst.frc.team3539.robot.commands;

import org.usfirst.frc.team3539.robot.Raspberry;
import org.usfirst.frc.team3539.robot.Robot;
import org.usfirst.frc.team3539.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class AutoAim extends PIDCommand
{
	public AutoAim()
	{
		super("AutoAim", RobotMap.turnPea, RobotMap.turnEye, RobotMap.turnDee);
		requires(Robot.driveTrain);
	}

	protected void initialize()
	{
		this.getPIDController().setPID(RobotMap.turnPea, RobotMap.turnEye, RobotMap.turnDee);

		this.setSetpoint(0);
		
		this.getPIDController().setOutputRange(-.75, .75);
		this.getPIDController().setAbsoluteTolerance(5);
	}

	protected void execute()
	{
	}

	protected boolean isFinished()
	{
		return false;
		//return this.getPIDController().onTarget();
	}

	protected void end()
	{

		Robot.driveTrain.stopTrain();
	}

	protected void interrupted()
	{
		end();
	}

	@Override
	protected double returnPIDInput()
	{
		double read = Robot.raspberry.Read();
		return read;
	}

	@Override
	protected void usePIDOutput(double output)
	{
		Robot.driveTrain.turnLinear(-output);
	}
}
