package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.commands.drivetrain.TankDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Drivetrain extends Subsystem implements PIDOutput {

	private PIDController turnController;
	public RobotDrive drivetrain;
	public Encoder leftEncoder;

	private double PIDrotateToAngleRate;
	private boolean usingTurnPID;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public VictorSP leftMotorA = new VictorSP(RobotMap.leftMotorA);
	public VictorSP leftMotorB = new VictorSP(RobotMap.leftMotorB);
	public VictorSP rightMotorA = new VictorSP(RobotMap.rightMotorA);
	public VictorSP rightMotorB = new VictorSP(RobotMap.rightMotorB);

	static final double turnTolerance = 0.1f;

	public Drivetrain() {
		usingTurnPID = false;
		drivetrain = new RobotDrive(leftMotorA, leftMotorB, rightMotorA, rightMotorB);
		leftEncoder = new Encoder(RobotMap.leftMotorEncoderA, RobotMap.leftMotorEncoderB, false,
				Encoder.EncodingType.k4X);

		leftEncoder.setDistancePerPulse(RobotMap.DRIVETRAIN_DISTANCE_PER_PULSE);

		turnController = new PIDController(RobotMap.drivetrainRotationP, RobotMap.drivetrainRotationI,
				RobotMap.drivetrainRotationD, RobotMap.drivetrainRotationF, Robot.navX, this);

		turnController.setInputRange(-180.0f, 180.0f);
		turnController.setOutputRange(-1.0, 1.0);
		turnController.setAbsoluteTolerance(turnTolerance);
		turnController.setContinuous(true);

		LiveWindow.addActuator("DriveSystem", "RotateController", turnController);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new TankDrive());
	}

	public void arcadeDrive(double moveValue, double rotateValue) {
		// TODO Auto-generated method stub
		drivetrain.arcadeDrive(moveValue, -rotateValue);
	}

	public void stop() {
		drivetrain.arcadeDrive(0, 0);
	}

	public void setDistancePerPulse(double dpp) {
		leftEncoder.setDistancePerPulse(dpp);
	}

	public void reset() {
		leftEncoder.reset();
	}

	public void setUsingTurnPID(boolean set) {
		usingTurnPID = true;
		if (set == true) {
			turnController.enable();
		} else {
			turnController.disable();
		}
	}

	public void setUsingDistancePID(boolean set) {
		Robot.drivetrainCompanion.setUsingDistancePID(set);
	}

	public boolean getUsingTurnPID() {
		return usingTurnPID;
	}

	public boolean getUsingDistancePID() {
		return Robot.drivetrainCompanion.getUsingDistancePID();
	}

	public double getPIDRotateRate() {
		return PIDrotateToAngleRate;
	}

	public double getPIDSpeed() {
		return Robot.drivetrainCompanion.getPIDSpeed();
	}

	public PIDController getTurnController() {
		return turnController;
	}

	public PIDController getDistanceController() {
		return Robot.drivetrainCompanion.getDistanceController();
	}

	public void pidWrite(double output) {
		if (usingTurnPID)
			PIDrotateToAngleRate = output;
	}
}
