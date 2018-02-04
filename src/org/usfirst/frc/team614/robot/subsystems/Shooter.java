package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
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
		
		shooterRight.config_kP(0, RobotMap.talonP, RobotMap.kTimeoutMs);
		shooterRight.config_kI(0, RobotMap.talonI, RobotMap.kTimeoutMs);
		shooterRight.config_kD(0, RobotMap.talonD, RobotMap.kTimeoutMs);
		shooterRight.config_kF(0, RobotMap.talonF, RobotMap.kTimeoutMs);
		
		shooterRight.set(ControlMode.Velocity, 0);
		
		
		
		  shooterLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, RobotMap.kTimeoutMs);
			shooterLeft.setSensorPhase(true);

			shooterLeft.configNominalOutputForward(0, RobotMap.kTimeoutMs);
			shooterLeft.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
			shooterLeft.configPeakOutputForward(1, RobotMap.kTimeoutMs);
			shooterLeft.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);
			
			shooterLeft.config_kP(0, RobotMap.talonP, RobotMap.kTimeoutMs);
			shooterLeft.config_kI(0, RobotMap.talonI, RobotMap.kTimeoutMs);
			shooterLeft.config_kD(0, RobotMap.talonD, RobotMap.kTimeoutMs);
			shooterLeft.config_kF(0, RobotMap.talonF, RobotMap.kTimeoutMs);
			

			shooterLeft.set(ControlMode.Follower, 0);
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

	public void setShooter(double speed) {
		shooterRight.config_kP(0, SmartDashboard.getNumber("P", 0), RobotMap.kTimeoutMs);
		shooterRight.config_kI(0, SmartDashboard.getNumber("I", 0), RobotMap.kTimeoutMs);
		shooterRight.config_kD(0, SmartDashboard.getNumber("D", 0), RobotMap.kTimeoutMs);
		shooterRight.config_kF(0, SmartDashboard.getNumber("F", 0), RobotMap.kTimeoutMs);
		
		shooterRight.set(ControlMode.Velocity, speed);

		shooterLeft.config_kP(0, SmartDashboard.getNumber("P", 0), RobotMap.kTimeoutMs);
		shooterLeft.config_kI(0, SmartDashboard.getNumber("I", 0), RobotMap.kTimeoutMs);
		shooterLeft.config_kD(0, SmartDashboard.getNumber("D", 0), RobotMap.kTimeoutMs);
		shooterLeft.config_kF(0, SmartDashboard.getNumber("F", 0), RobotMap.kTimeoutMs);

		shooterLeft.set(ControlMode.Follower, RobotMap.shooterRight);
	}

	public void stop() {
		shooterLeft.neutralOutput();
		shooterRight.neutralOutput();
	}
	
	public void setAccelerator(double speed) {
		acceleratorLeft.set(speed);
		acceleratorRight.set(-speed);
	}
}
