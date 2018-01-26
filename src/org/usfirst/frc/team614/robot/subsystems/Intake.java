package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
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

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		intakeLeft.set(0);
		intakeRight.set(0);
	}
	
	public void set(double speed)
	{
		intakeLeft.set(speed);
		intakeRight.set(-speed);
	}
}
