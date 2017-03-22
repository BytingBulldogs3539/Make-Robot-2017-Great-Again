package org.usfirst.frc.team3539.robot.calibration;

import org.usfirst.frc.team3539.robot.Robot;
import org.usfirst.frc.team3539.robot.autoncommands.AutoWait;
import org.usfirst.frc.team3539.robot.autoncommands.AutonDrive;
import org.usfirst.frc.team3539.robot.autoncommands.AutonDriveOld;
import org.usfirst.frc.team3539.robot.autoncommands.AutonTurn;
import org.usfirst.frc.team3539.robot.commands.JoeyShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveCalibrate extends CommandGroup
{

	public DriveCalibrate()
	{
		addSequential(new AutonDrive(90));
		addSequential(new AutoWait(2));
		
		addSequential(new AutonDrive(-90));
		addSequential(new AutoWait(2));
//		
//		addSequential(new AutonDrive(25));
//		addSequential(new AutoWait(2));
//		
//		addSequential(new AutonDrive(-25));
	}
}
