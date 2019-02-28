package org.usfirst.frc.team614.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// SHOOTER
	
	public static final int shooterLeft = 2;
	public static final int shooterRight = 3;
	
	public static final int acceleratorLeft = 6; // green
	public static final int acceleratorRight = 7;
	
	// TALONSRXMOTORS CONSTANTS
	public static final double shooterLeftP = 0.15;
	public static final double shooterLeftI = 0.001;
	public static final double shooterLeftD = 0.0035;
	public static final double shooterLeftF = 0.10;
	
	public static final double shooterRightP = 0.16;
	public static final double shooterRightI = 0.001;
	public static final double shooterRightD = 0.0005;
	public static final double shooterRightF = 0.154;
	
	public static final double switchP = 0.0;
	public static final double switchI = 0.0;
	public static final double switchD = 0.0;
	public static final double switchF = 0.0;
	
	public static final int kTimeoutMs = 10;
	
	// PWM
	
	public static final int winch = 8;
	public static final int servo = 9;
	
	public static final int intakeLeft = 4; // grey
	public static final int intakeRight = 5;
	
	public static final int leftMotorA = 0; // blue
	public static final int leftMotorB = 1; //1 
	public static final int rightMotorA = 2; // red
	public static final int rightMotorB = 3; //3
	
	// ENCODERS
	
	public static final int leftMotorEncoderA = 0;
	public static final int leftMotorEncoderB = 1;
	
	// DRIVETRAIN CONSTANTS
	
	public static final double DRIVETRAIN_WHEEL_DIAMETER = 6; // 6
	public static final double DRIVETRAIN_ENCODER_PULSES_PER_REV = 245; // 358
	public static final double DRIVETRAIN_DISTANCE_PER_PULSE = (RobotMap.DRIVETRAIN_WHEEL_DIAMETER * Math.PI) / RobotMap.DRIVETRAIN_ENCODER_PULSES_PER_REV;
	
	public static final double kCollisionThreshold_DeltaG = 0.6f;
	
	public static final double drivetrainRotationP = 0.1;
	public static final double drivetrainRotationI = 0;
	public static final double drivetrainRotationD = 0.12;
	public static final double drivetrainRotationF = 0;
	
	public static final double drivetrainDistanceP = 0.1;
	public static final double drivetrainDistanceI = 0;
	public static final double drivetrainDistanceD = 0.0;
	public static final double drivetrainDistanceF = 0;
	
	public static final double talonRotationP = 2;
	public static final double talonRotationI = 0;
	public static final double talonRotationD = 4;
	public static final double talonRotationF = 0;

	// DIO
	
	//PCM
	
	public static final int compressor = 0;
	
	public static final int intakeSolenoidA = 4;
	public static final int intakeSolenoidB = 5;
	
	public static final int loaderSolenoidA = 1;
	public static final int loaderSolenoidB = 2;
	
	public static final DoubleSolenoid.Value PistonOut = DoubleSolenoid.Value.kForward;
	public static final DoubleSolenoid.Value PistonIn = DoubleSolenoid.Value.kReverse;
	
	// CAM
	
	public static final int IMG_HEIGHT = 320;
	public static final int IMG_WIDTH = 240;
	public static final int IMG_FPS = 15;
	public static final int IMG_BRIGHTNESS = 0;
	public static boolean cameraSwitchPressedLastTime = false;
	public static boolean rearCam = true;
}
