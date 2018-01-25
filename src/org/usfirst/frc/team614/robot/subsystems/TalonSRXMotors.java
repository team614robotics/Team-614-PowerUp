package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TalonSRXMotors extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public TalonSRX talon1 = new TalonSRX(RobotMap.talon1);
	public TalonSRX talon2 = new TalonSRX(RobotMap.talon2);

	public void initDefaultCommand() {
        talon1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, RobotMap.kTimeoutMs);
		talon1.setSensorPhase(true);

		talon1.configNominalOutputForward(0, RobotMap.kTimeoutMs);
		talon1.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
		talon1.configPeakOutputForward(1, RobotMap.kTimeoutMs);
		talon1.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);
		
		talon1.config_kP(0, RobotMap.talonP, RobotMap.kTimeoutMs);
		talon1.config_kI(0, RobotMap.talonI, RobotMap.kTimeoutMs);
		talon1.config_kD(0, RobotMap.talonD, RobotMap.kTimeoutMs);
		talon1.config_kF(0, RobotMap.talonF, RobotMap.kTimeoutMs);

		talon1.set(ControlMode.Velocity, 0);
		
		talon2.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, RobotMap.kTimeoutMs);
		talon2.setSensorPhase(true);

		talon2.configNominalOutputForward(0, RobotMap.kTimeoutMs);
		talon2.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
		talon2.configPeakOutputForward(1, RobotMap.kTimeoutMs);
		talon2.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);
		
		talon2.config_kP(0, RobotMap.talonP, RobotMap.kTimeoutMs);
		talon2.config_kI(0, RobotMap.talonI, RobotMap.kTimeoutMs);
		talon2.config_kD(0, RobotMap.talonD, RobotMap.kTimeoutMs);
		talon2.config_kF(0, RobotMap.talonF, RobotMap.kTimeoutMs);

		talon2.set(ControlMode.Velocity, 0);
	}

	public void reset() {
		
	}
	
//	public double getDistance() {
//		return talon1.getDistance();
//	}

	public double getSpeed() {
		return talon1.getSelectedSensorVelocity(0);
	}

	public double getError() {
		return talon1.getSelectedSensorVelocity(0) - talon1.getClosedLoopTarget(0);
	}

	public double getSetpoint() {
		return talon1.getClosedLoopTarget(0);
	}

	public void set(double speed) {
		talon1.set(ControlMode.Velocity, speed);
		talon2.set(ControlMode.Velocity, speed);
	}

	public void stop() {
		talon1.neutralOutput();
	}
}
