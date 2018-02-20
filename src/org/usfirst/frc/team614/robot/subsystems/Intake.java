package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.commands.intake.ToggleIntakeLight;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public VictorSP intakeLeft = new VictorSP(RobotMap.intakeLeft);
	public VictorSP intakeRight = new VictorSP(RobotMap.intakeRight);
	public DigitalInput intakeLimitSwitchA;
	public DigitalInput intakeLimitSwitchB;
	public DigitalInput intakeLimitSwitchC;
	
	public Intake() {
		intakeLimitSwitchA = new DigitalInput(RobotMap.ringLightSwitchA);
		intakeLimitSwitchB = new DigitalInput(RobotMap.ringLightSwitchB);
		intakeLimitSwitchC = new DigitalInput(RobotMap.ringLightSwitchC);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new ToggleIntakeLight());
		intakeLeft.set(0);
		intakeRight.set(0);
	}
	
	public void set(double speed)
	{
		intakeLeft.set(speed);
		intakeRight.set(-speed);
	}
	
	public boolean testForCube() {
		if(!Robot.intake.intakeLimitSwitchC.get() && !Robot.intake.intakeLimitSwitchB.get() && !Robot.intake.intakeLimitSwitchA.get()) {
			return true;
		}
		else
			return false;
	}
}
