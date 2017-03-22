package org.usfirst.frc.team3539.robot.autongroups;

import org.usfirst.frc.team3539.robot.Robot;
import org.usfirst.frc.team3539.robot.autoncommands.AutoWait;
import org.usfirst.frc.team3539.robot.autoncommands.AutonDrive;
import org.usfirst.frc.team3539.robot.autoncommands.AutonGearClose;
import org.usfirst.frc.team3539.robot.autoncommands.AutonGearOpen;
import org.usfirst.frc.team3539.robot.autoncommands.AutonTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class VisionGearMiddle extends CommandGroup
{
	public VisionGearMiddle()
	{
		addSequential(new AutonDrive(40, 2));

		addSequential(new AutoWait(1));
		
		addSequential(new AutonTurn(Robot.raspberry.getAngle(), 1));
		
		addSequential(new AutoWait(1));
		
		addSequential(new AutonDrive(48, 3));
		
		addSequential(new AutoWait(1));

		addSequential(new AutonGearOpen());

		addSequential(new AutoWait(1));

		addSequential(new AutonDrive(-20, 3));

		addSequential(new AutonGearClose());
	}
}
