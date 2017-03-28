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
public class RedShootInside extends CommandGroup
{

	public RedShootInside()
	{
		addSequential(new GearLeftGroup());

		addSequential(new SetShootCamera());

		addSequential(new AutoWait(RobotMap.visionWait));

		addSequential(new AutonTurn(0, 1));
		
		addSequential(new AutoWait(.5));
		
		addSequential(new JoeyShoot(7));
	}
}
