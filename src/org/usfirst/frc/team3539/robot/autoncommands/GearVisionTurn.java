package org.usfirst.frc.team3539.robot.autoncommands;
import org.usfirst.frc.team3539.robot.Robot;
import org.usfirst.frc.team3539.robot.RobotMap;
import org.usfirst.frc.team3539.robot.utilities.DpadButton;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class GearVisionTurn extends PIDCommand
{
        private double newAngle;

        public GearVisionTurn(double angle)
        {
            super("test", RobotMap.turnPea, RobotMap.turnEye, RobotMap.turnDee);
            newAngle = angle;
            requires(Robot.driveTrain);
            System.out.println("CON");
        }

        protected void initialize()
        {
            this.getPIDController().setPID(RobotMap.turnPea, RobotMap.turnEye, RobotMap.turnDee);

            Robot.driveTrain.gyroReset();
            Robot.driveTrain.zeroEncoders();
            Robot.raspberry.UpdateCamera(0);
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            this.setSetpoint(0);
            // HACK
            this.setSetpoint(Robot.raspberry.getAngle());


            this.getPIDController().setOutputRange(-.6, .6); // original -.5. .5
            this.getPIDController().setAbsoluteTolerance(.2);
        }

        protected void execute()
        {
        }

        protected boolean isFinished()
        {
            
            return true;
        }

        protected void end()
        {
            Robot.driveTrain.stopTrain();
            Robot.raspberry.UpdateCamera(0);
        }

        protected void interrupted()
        {
            end();
        }

        @Override
        protected double returnPIDInput()
        {
            return Robot.driveTrain.getGyroAngle();
        }

        @Override
        protected void usePIDOutput(double output)
        {
            Robot.driveTrain.turnLinear(output);
        }
    }
