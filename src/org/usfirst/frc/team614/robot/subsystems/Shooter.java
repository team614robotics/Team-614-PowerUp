package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends Subsystem {
	public TalonSRX shooterLeft = new TalonSRX(RobotMap.shooterLeft);
	public TalonSRX shooterRight = new TalonSRX(RobotMap.shooterRight);

	public VictorSP acceleratorLeft = new VictorSP(RobotMap.acceleratorLeft);
	public VictorSP acceleratorRight = new VictorSP(RobotMap.acceleratorRight);

	public void initDefaultCommand() {
		shooterRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, RobotMap.kTimeoutMs);
		shooterRight.setSensorPhase(true);

		shooterRight.configNominalOutputForward(0, RobotMap.kTimeoutMs);
		shooterRight.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
		shooterRight.configPeakOutputForward(1, RobotMap.kTimeoutMs);
		shooterRight.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);

		shooterRight.config_kP(0, 0, RobotMap.kTimeoutMs);
		shooterRight.config_kI(0, 0, RobotMap.kTimeoutMs);
		shooterRight.config_kD(0, 0, RobotMap.kTimeoutMs);
		shooterRight.config_kF(0, 0, RobotMap.kTimeoutMs);
		shooterRight.config_kP(1, RobotMap.talonRotationP, RobotMap.kTimeoutMs);
		shooterRight.config_kI(1, RobotMap.talonRotationI, RobotMap.kTimeoutMs);
		shooterRight.config_kD(1, RobotMap.talonRotationD, RobotMap.kTimeoutMs);
		shooterRight.config_kF(1, RobotMap.talonRotationF, RobotMap.kTimeoutMs);

		shooterRight.set(ControlMode.Velocity, 0);

		shooterLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, RobotMap.kTimeoutMs);
		shooterLeft.setSensorPhase(true);

		shooterLeft.configNominalOutputForward(0, RobotMap.kTimeoutMs);
		shooterLeft.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
		shooterLeft.configPeakOutputForward(1, RobotMap.kTimeoutMs);
		shooterLeft.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);

		shooterLeft.config_kP(0, 0, RobotMap.kTimeoutMs);
		shooterLeft.config_kI(0, 0, RobotMap.kTimeoutMs);
		shooterLeft.config_kD(0, 0, RobotMap.kTimeoutMs);
		shooterLeft.config_kF(0, 0, RobotMap.kTimeoutMs);
		shooterLeft.config_kP(1, RobotMap.talonRotationP, RobotMap.kTimeoutMs);
		shooterLeft.config_kI(1, RobotMap.talonRotationI, RobotMap.kTimeoutMs);
		shooterLeft.config_kD(1, RobotMap.talonRotationD, RobotMap.kTimeoutMs);
		shooterLeft.config_kF(1, RobotMap.talonRotationF, RobotMap.kTimeoutMs);

		shooterLeft.set(ControlMode.Velocity, 0);
		shooterLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, RobotMap.kTimeoutMs);
		shooterLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, RobotMap.kTimeoutMs);
	}

	public void reset() {

	}

	public double getSpeed() {
		return shooterLeft.getSelectedSensorVelocity(0);
	}

	public double getErrorLeft() {
		return shooterLeft.getSelectedSensorVelocity(0) - shooterLeft.getClosedLoopTarget(0);
	}

	public double getErrorRight() {
		return shooterRight.getSelectedSensorVelocity(0) - shooterRight.getClosedLoopTarget(0);
	}

	public double getSetpoint() {
		return shooterLeft.getClosedLoopTarget(0);
	}

	public void setShooter(double speed, boolean scale) {

		SmartDashboard.putNumber("Error Left", getErrorLeft());
		SmartDashboard.putNumber("Error Right", getErrorRight());
		
		if (scale) {
			shooterRight.config_kP(0, RobotMap.shooterRightP, RobotMap.kTimeoutMs);
			shooterRight.config_kI(0, RobotMap.shooterRightI, RobotMap.kTimeoutMs);
			shooterRight.config_kD(0, RobotMap.shooterRightD, RobotMap.kTimeoutMs);
			shooterRight.config_kF(0, RobotMap.shooterRightF, RobotMap.kTimeoutMs);

			shooterLeft.config_kP(0, RobotMap.shooterLeftP, RobotMap.kTimeoutMs);
			shooterLeft.config_kI(0, RobotMap.shooterLeftI, RobotMap.kTimeoutMs);
			shooterLeft.config_kD(0, RobotMap.shooterLeftD, RobotMap.kTimeoutMs);
			shooterLeft.config_kF(0, RobotMap.shooterLeftF, RobotMap.kTimeoutMs);
			
			shooterRight.set(ControlMode.Velocity, speed);
			shooterLeft.set(ControlMode.Velocity, -speed);
		} else {
//			shooterRight.config_kP(0, RobotMap.switchP, RobotMap.kTimeoutMs);
//			shooterRight.config_kI(0, RobotMap.switchI, RobotMap.kTimeoutMs);
//			shooterRight.config_kD(0, RobotMap.switchD, RobotMap.kTimeoutMs);
//			shooterRight.config_kF(0, RobotMap.switchF, RobotMap.kTimeoutMs);
//			
//			shooterLeft.config_kP(0, RobotMap.switchP, RobotMap.kTimeoutMs);
//			shooterLeft.config_kI(0, RobotMap.switchI, RobotMap.kTimeoutMs);
//			shooterLeft.config_kD(0, RobotMap.switchD, RobotMap.kTimeoutMs);
//			shooterLeft.config_kF(0, RobotMap.switchF, RobotMap.kTimeoutMs);
			
			shooterRight.config_kP(0, SmartDashboard.getNumber("Switch P", 0.0), RobotMap.kTimeoutMs);
			shooterRight.config_kI(0, SmartDashboard.getNumber("Switch I", 0.0), RobotMap.kTimeoutMs);
			shooterRight.config_kD(0, SmartDashboard.getNumber("Switch D", 0.0), RobotMap.kTimeoutMs);
			shooterRight.config_kF(0, SmartDashboard.getNumber("Switch F", 0.0), RobotMap.kTimeoutMs);
			
			shooterLeft.config_kP(0, SmartDashboard.getNumber("Switch P", 0.0), RobotMap.kTimeoutMs);
			shooterLeft.config_kI(0, SmartDashboard.getNumber("Switch I", 0.0), RobotMap.kTimeoutMs);
			shooterLeft.config_kD(0, SmartDashboard.getNumber("Switch D", 0.0), RobotMap.kTimeoutMs);
			shooterLeft.config_kF(0, SmartDashboard.getNumber("Switch F", 0.0), RobotMap.kTimeoutMs);
			
			SmartDashboard.putNumber("Error Left", this.getErrorLeft());
			SmartDashboard.putNumber("Error Left", this.getErrorLeft());
			
			shooterRight.set(ControlMode.Velocity, speed);
			shooterLeft.set(ControlMode.Velocity, -speed);
		}
	}

	public void setAccelerator(double speed) {
		acceleratorLeft.set(speed);
		acceleratorRight.set(speed);
	}

	public void stop() {
		shooterLeft.neutralOutput();
		shooterRight.neutralOutput();
		acceleratorLeft.set(0);
		acceleratorRight.set(0);
	} 
	
	public void setMotionMagic(double distance) {
		shooterLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, RobotMap.kTimeoutMs);
		shooterLeft.configMotionCruiseVelocity(1600, RobotMap.kTimeoutMs);
		shooterLeft.configMotionAcceleration(1300, RobotMap.kTimeoutMs);
		shooterLeft.set(ControlMode.MotionMagic, distance);
		shooterRight.follow(shooterLeft);
	}
}
