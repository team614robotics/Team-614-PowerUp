package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public VictorSP winch = new VictorSP(RobotMap.winch);
	public Servo servo = new Servo(RobotMap.servo);
	
	public double servoStart = 0.4;

	public Climber() {
	}

	public void initDefaultCommand() {
		winch.set(0);
		servo.set(servoStart);
	}

	public void setWinch(double speed) {
		winch.set(speed);
	}
	
	public void setServo(double value) {
		servo.set(value);
	}
}
