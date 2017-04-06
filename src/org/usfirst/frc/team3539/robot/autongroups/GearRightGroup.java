package org.usfirst.frc.team3539.robot.autongroups;

import org.usfirst.frc.team3539.robot.Robot;
import org.usfirst.frc.team3539.robot.RobotMap;
import org.usfirst.frc.team3539.robot.autoncommands.AutoWait;
import org.usfirst.frc.team3539.robot.autoncommands.AutonDrive;
import org.usfirst.frc.team3539.robot.autoncommands.AutonGearClose;
import org.usfirst.frc.team3539.robot.autoncommands.AutonGearOpen;
import org.usfirst.frc.team3539.robot.autoncommands.AutonTurn;
import org.usfirst.frc.team3539.robot.autoncommands.HoodReset;
import org.usfirst.frc.team3539.robot.autoncommands.SetShootCamera;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearRightGroup extends CommandGroup
{
	public GearRightGroup()
	{	
		Robot.raspberry.setCamera(RobotMap.gearCamera);
		
		addParallel(new HoodReset(3));
		
		addSequential(new AutonDrive(RobotMap.whiteLineDistance, 3));

		addSequential(new AutonTurn(RobotMap.sidePegTurn));

		addSequential(new AutonDrive(RobotMap.sidePegDistance, true));

		//addSequential(new AutoWait(1));

		addSequential(new AutonGearOpen());

		//addSequential(new AutoWait(1));
		
		addSequential(new SetShootCamera());

		addSequential(new AutonDrive(-10));

		addSequential(new AutonGearClose());
	}
}
