package org.usfirst.frc.team3539.robot;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap//test
{
	//CONTROLLER PORT
	public static final int controllerOnePort = 0;
	public static final int controllerTwoPort = 1;

	//CONTROLLER AXIS
	public static final int X_AxisL = 0;
	public static final int Y_AxisL = 1;

	public static final int X_AxisR = 4;
	public static final int Y_AxisR = 5;

	public static final int T_Axis = 3; //Trigger Axis
	public static final int RIGHT_TRIGGER = 3;
	public static final int LEFT_TRIGGER = 2;

	public static final double Tdepression = .5; //How far the trigger must be pressed

	//BUTTON
	public static final int buttona = 1;
	public static final int buttonb = 2;
	public static final int buttonx = 3;
	public static final int buttony = 4;

	//BUMPER
	public static final int bumperl = 5;
	public static final int bumperr = 6;

	//SENSOR

	//DRIVE
	public static final int lfMotorTalon = 6;
	public static final int lbMotorTalon = 7;
	public static final int rfMotorTalon = 4;
	public static final int rbMotorTalon = 3;
	public static final int driveSolOn = 0; // solens are pcm numbers
	public static final int driveSolOff = 1; //ORIGINAL= 1, 0

	//PID
	public static double drivePea = .0003;
	public static double driveEye = .000001;
	public static double driveDee = .0001;
	public static double driveEff = 0;
	public static int driveEyeZone = 0;
	public static double driveLoopRamp = 0;
	public static int driveProfile = 0;
	public static int driveLoopError = 0;

	public static double shootPea = 0;
	public static double shootEye = 0;
	public static double shootDee = 0;
	public static double shootEff = 0;

	//AIR
	public static final int compressor = 10;

	//AGITATOR
	public static final int agitatorTalon = 8;
	public static double agitatorSpeed = -.6;
	public static double unjamAgitatorSpeed = .6;

	//INTAKE
	public static final int intakeMotorTalon = 5;
	public static double climbSpeed = 1;
	public static double intakeSpeed = 1;
	public static double unjamIntakeSpeed = -1;

	//LOCK (in intake)
	public static final int lockSolOn = 6;
	public static final int lockSolOff = 7; // ORIGINAL= 6,7

	//SHOOTER
	public static final int shooterTwoMotorTalon = 1;
	public static final int shooterOneMotorTalon = 2;
	public static double shootSpeed = .7;
	public static final double shooterSpeedModifier = 1.0;
	public static final int shooterServoTalon = 9;
	public static double shooterRpm = 0;
	public static double selectSpeed= 0;

	//GEAR
	public static final int hoodSolOn = 2;
	public static final int hoodSolOff = 3; // ORIGINAL= 2, 3
	public static final int gearSolOn = 4;
	public static final int gearSolOff = 5; // ORIGINAL= 4, 5

	//PCM
	public static final int pcm = 10;

	//TEST
	
	
	//LIGHT
	public static int ballCount = 0;
	
	public static DigitalInput light = new DigitalInput(1);//finnaly incorrect number 
	public static DigitalInput lightt = new DigitalInput(0);//finnaly



	
	
	//LightWhite = new DigitalInput(5);
}