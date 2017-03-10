package org.usfirst.frc.team3539.robot.autongroups;

import org.usfirst.frc.team3539.robot.autoncommands.AutoWait;
import org.usfirst.frc.team3539.robot.autoncommands.AutonDrive;
import org.usfirst.frc.team3539.robot.autoncommands.AutonGearClose;
import org.usfirst.frc.team3539.robot.autoncommands.AutonGearOpen;
import org.usfirst.frc.team3539.robot.autoncommands.AutonHoodClose;
import org.usfirst.frc.team3539.robot.autoncommands.AutonHoodOpen;
import org.usfirst.frc.team3539.robot.autoncommands.AutonTurn;
import org.usfirst.frc.team3539.robot.utilities.BulldogLogger;
import org.usfirst.frc.team3539.robot.utilities.BulldogSleeper;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearRightGroup extends CommandGroup
{

	public GearRightGroup()
	{
		addSequential(new AutonDrive(70, .7));

		addSequential(new AutonTurn(60, .6));

		addSequential(new AutonDrive(30, .4));
		
		addSequential(new AutonGearOpen());
		addSequential(new AutonHoodOpen());

		addSequential(new AutoWait(2));

		addSequential(new AutonDrive(-20, .6));

		addSequential(new AutonGearClose());
		addSequential(new AutonHoodClose());
	}
}
