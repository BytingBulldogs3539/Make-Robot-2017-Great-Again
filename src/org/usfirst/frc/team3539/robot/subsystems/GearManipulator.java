package org.usfirst.frc.team3539.robot.subsystems;

import org.usfirst.frc.team3539.robot.Robot;
import org.usfirst.frc.team3539.robot.RobotMap;
import org.usfirst.frc.team3539.robot.utilities.BulldogSystem;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GearManipulator extends BulldogSystem
{
	@SuppressWarnings("unused")
	private CANTalon hoodCan;
	@SuppressWarnings("unused")
	private CANTalon gearCan;

	private DoubleSolenoid hood;
	private DoubleSolenoid gear;

	private boolean hoodStatus;
	private boolean gearStatus;
	DigitalInput Button;
	
	public GearManipulator()
	{
		super("GearManipulator");
		hoodStatus = true;
		gearStatus = false;

		hoodCan = new CANTalon(RobotMap.pcm);
		hood = new DoubleSolenoid(RobotMap.pcm, RobotMap.hoodSolOn, RobotMap.hoodSolOff);
		hood.set(DoubleSolenoid.Value.kForward);

		gearCan = new CANTalon(RobotMap.pcm);
		gear = new DoubleSolenoid(RobotMap.pcm, RobotMap.gearSolOn, RobotMap.gearSolOff);
		
		this.hoodClose();
		this.holderClose();
		
		Button = new DigitalInput(RobotMap.Button);
	}

	public void hoodOpen()
	{
		hood.set(DoubleSolenoid.Value.kForward);
	}

	public void hoodClose()
	{
		hood.set(DoubleSolenoid.Value.kReverse);
	}

	public void flipHood()
	{
		hoodStatus = !hoodStatus;

		if(hoodStatus == true)
		{
			hood.set(DoubleSolenoid.Value.kForward);
		}
		if(hoodStatus == false)
		{
			hood.set(DoubleSolenoid.Value.kReverse);
		}
	}

	public void GearHolders()
	{
		gearStatus = !gearStatus;

		if(gearStatus == true)
		{
			gear.set(DoubleSolenoid.Value.kForward);
		}
		if(gearStatus == false)
		{
			gear.set(DoubleSolenoid.Value.kReverse);
		}
	}

	public void holderOpen()
	{
		gear.set(DoubleSolenoid.Value.kForward);
	}

	public void holderClose()
	{
		gear.set(DoubleSolenoid.Value.kReverse);
	}

	public void initDefaultCommand()
	{
	}

	@Override
	public void Update()
	{
		if(hoodStatus == true)
		{
			SmartDashboard.putString("Hood Status", "Closed");
		}
		else
		{
			SmartDashboard.putString("Hood Status", "Opened");
		}

		if(gearStatus == true)
		{
			SmartDashboard.putString("Gear Holder Status", "Opened");
		}
		else
		{
			SmartDashboard.putString("Gear Holder Status", "Closed");
		}
		
		
		
	}
	public void rumble()
	{
	
		Robot.oi.controller1.setRumble(RumbleType.kLeftRumble, 1);
		Robot.oi.controller1.setRumble(RumbleType.kRightRumble, 1);
		Robot.oi.controller2.setRumble(RumbleType.kLeftRumble, 1);
		Robot.oi.controller2.setRumble(RumbleType.kRightRumble, 1);

	}
	public boolean GetButton()
	{
		
		return Button.get();
	}

	@Override
	public void SmartInit()
	{
		SmartDashboard.putString("Hood Status", "--");
		SmartDashboard.putString("Gear Holder Status", "--");
	}
}