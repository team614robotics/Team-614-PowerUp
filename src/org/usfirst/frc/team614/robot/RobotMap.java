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
	
	// SHOOTER
	
	public static final int shooterLeft = 2;
	public static final int shooterRight = 3;
	
	public static final int acceleratorLeft = 6; // yellow
	public static final int acceleratorRight = 7;
	
	// TALONSRXMOTORS CONSTANTS
	public static final double shooterLeftP = 0.26;
	public static final double shooterLeftI = 0.0006;
	public static final double shooterLeftD = 0.001;
	public static final double shooterLeftF = 0.154;
	
	public static final double shooterRightP = 0.16;
	public static final double shooterRightI = 0.001;
	public static final double shooterRightD = 0.001;
	public static final double shooterRightF = 0.154;
	
	public static final double talonP = 0.10;
	public static final double talonI = 0.0005;
	public static final double talonD = 0.0;
	public static final double talonF = 0.0404;
	
	public static final int kTimeoutMs = 10;
	
	// PWM
	
	public static final int intakeLeft = 4; // white
	public static final int intakeRight = 5;
	
	public static final int leftMotorA = 0; // blue
	public static final int leftMotorB = 1;
	public static final int rightMotorA = 2; // pink
	public static final int rightMotorB = 3;
	
	// ENCODERS
	
	public static final int leftMotorEncoderA = 2;
	public static final int leftMotorEncoderB = 3;
	public static final int rightMotorEncoderA = 0;
	public static final int rightMotorEncoderB = 1;
	
	// DRIVETRAIN CONSTANTS
	
	public static final double DRIVETRAIN_WHEEL_DIAMETER = 6;
	public static final double DRIVETRAIN_ENCODER_PULSES_PER_REV = 350.0;
	public static final double DRIVETRAIN_DISTANCE_PER_PULSE = (RobotMap.DRIVETRAIN_WHEEL_DIAMETER * Math.PI) / RobotMap.DRIVETRAIN_ENCODER_PULSES_PER_REV;
	public static final double kCollisionThreshold_DeltaG = 0.6f;
	public static final double drivetrainRotationP = 0.1;
	public static final double drivetrainRotationI = 0;
	public static final double drivetrainRotationD = 0.12;
	public static final double drivetrainRotationF = 0;
	public static final double drivetrainDistanceP = 0.05;
	public static final double drivetrainDistanceI = 0;
	public static final double drivetrainDistanceD = 0.0;
	public static final double drivetrainDistanceF = 0;

	// DIO
	
	public static final int ringLightSwitchA = 7;
	public static final int ringLightSwitchB = 8;
	public static final int ringLightSwitchC = 9;
	
	//PCM
	
	public static final int compressor = 0;
	
	public static final int intakeSolenoidA = 4;
	public static final int intakeSolenoidB = 5;
	public static final int loaderSolenoidA = 1;
	public static final int loaderSolenoidB = 2;
	public static final int ringLightSolenoid = 0;
	
	public static final DoubleSolenoid.Value pistonOut = DoubleSolenoid.Value.kForward;
	public static final DoubleSolenoid.Value pistonIn = DoubleSolenoid.Value.kReverse;
	public static final DoubleSolenoid.Value PistonOut = DoubleSolenoid.Value.kForward;
	public static final DoubleSolenoid.Value PistonIn = DoubleSolenoid.Value.kReverse;	
}
