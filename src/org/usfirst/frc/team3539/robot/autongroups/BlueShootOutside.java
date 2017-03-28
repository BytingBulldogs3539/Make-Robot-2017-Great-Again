package org.usfirst.frc.team3539.robot.autongroups;

import org.usfirst.frc.team3539.robot.RobotMap;
import org.usfirst.frc.team3539.robot.autoncommands.AutoWait;
import org.usfirst.frc.team3539.robot.autoncommands.AutonTurn;
import org.usfirst.frc.team3539.robot.autoncommands.SetShootCamera;
import org.usfirst.frc.team3539.robot.commands.JoeyShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BlueShootOutside extends CommandGroup
{

	public BlueShootOutside()
	{
		addSequential(new GearLeftGroup());

		addSequential(new SetShootCamera());

		addSequential(new AutonTurn(RobotMap.outsideShootTurn, 4));

		addSequential(new AutoWait(RobotMap.visionWait));

		addSequential(new AutonTurn(0, 1));

		addSequential(new JoeyShoot(7));
	}
}
