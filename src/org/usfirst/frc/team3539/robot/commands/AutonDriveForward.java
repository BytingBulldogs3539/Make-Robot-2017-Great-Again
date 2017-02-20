package org.usfirst.frc.team3539.robot.commands;

import org.usfirst.frc.team3539.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonDriveForward extends Command
{
	private int myTicks;
	
	public AutonDriveForward(int ticks)
	{
		requires(Robot.driveTrain);
		myTicks = ticks;
	}

	protected void initialize()
	{
		Robot.driveTrain.talonControlPosition();
		Robot.driveTrain.enableControl();
		Robot.driveTrain.driveXTicks(myTicks);
	}

	protected void execute()
	{
	}

	protected boolean isFinished()
	{
		return false;
	}

	protected void end()
	{
		System.out.println("end");
		Robot.driveTrain.talonControlVBus();
	}

	protected void interrupted()
	{
		end();
	}
}