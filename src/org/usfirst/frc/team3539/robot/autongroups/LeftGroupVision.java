package org.usfirst.frc.team3539.robot.autongroups;

import org.usfirst.frc.team3539.robot.Robot;
import org.usfirst.frc.team3539.robot.RobotMap;
import org.usfirst.frc.team3539.robot.autoncommands.AutoWait;
import org.usfirst.frc.team3539.robot.autoncommands.AutonDrive;
import org.usfirst.frc.team3539.robot.autoncommands.AutonGearClose;
import org.usfirst.frc.team3539.robot.autoncommands.AutonGearOpen;
import org.usfirst.frc.team3539.robot.autoncommands.AutonTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftGroupVision extends CommandGroup
{
	public LeftGroupVision()
	{
		addSequential(new AutonDrive(107));

		addSequential(new AutonTurn(-60));

		addSequential(new AutonTurn(Robot.raspberry.getTurnAngle(), 2));
		
		addSequential(new AutonDrive(30));

		addSequential(new AutoWait(1));

		addSequential(new AutonGearOpen());

		addSequential(new AutoWait(1));

		addSequential(new AutonDrive(-30));

		addSequential(new AutonGearClose());
	}
}
