package org.usfirst.frc.team614.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	// CANBUS
	
	public static final int talon1 = 0;
	public static final int talon2 = 1;
	
	// TALONSRXMOTORS CONSTANTS
	
	public static final double talonP = 0.10;
	public static final double talonI = 0.0005;
	public static final double talonD = 0.0;
	public static final double talonF = 0.0404;
	
	public static final int kTimeoutMs = 10;
	
	// PWM
	
	public static final int flyWheelLeft = 4;
	public static final int flyWheelRight = 5;
	
	public static final int verticalShooterLeft = 6;
	public static final int verticalShooterRight = 7;
	
	public static final int leftMotorA = 0;
	public static final int rightMotorA = 1;
	
	// Encoders
	
	public static final int leftMotorEncoderA = 0;
	public static final int leftMotorEncoderB = 1;
	public static final int rightMotorEncoderA = 2;
	public static final int rightMotorEncoderB = 3;
	
	// Encoder Constants
	
	public static final double DRIVETRAIN_WHEEL_DIAMETER = 4;
	public static final double DRIVETRAIN_ENCODER_PULSES_PER_REV = 250.0;
	public static final double DRIVETRAIN_DISTANCE_PER_PULSE = (RobotMap.DRIVETRAIN_WHEEL_DIAMETER * Math.PI) / RobotMap.DRIVETRAIN_ENCODER_PULSES_PER_REV;
	
	//DIO
	public static final int testSolenoidA = 0;
	public static final int testSolenoidB = 1;
	public static final DoubleSolenoid.Value pistonOut = DoubleSolenoid.Value.kForward;
	public static final DoubleSolenoid.Value pistonIn = DoubleSolenoid.Value.kReverse;
	
	public static final double drivetrainRotationP = 0.1;
	public static final double drivetrainRotationI = 0;
	public static final double drivetrainRotationD = 0.12;
	public static final double drivetrainRotationF = 0;
	public static final double drivetrainDistanceP = 0.05;
	public static final double drivetrainDistanceI = 0;
	public static final double drivetrainDistanceD = 0.0;
	public static final double drivetrainDistanceF = 0;
}
