package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	public TalonSRX shooter1 = new TalonSRX(RobotMap.shooter2);
	public TalonSRX shooter2 = new TalonSRX(RobotMap.shooter1);
	
	public VictorSP accelerator1 = new VictorSP(RobotMap.accelerator1);
	public VictorSP accelerator2 = new VictorSP(RobotMap.accelerator1);

	public void initDefaultCommand() {
        shooter1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, RobotMap.kTimeoutMs);
		shooter1.setSensorPhase(true);

		shooter1.configNominalOutputForward(0, RobotMap.kTimeoutMs);
		shooter1.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
		shooter1.configPeakOutputForward(1, RobotMap.kTimeoutMs);
		shooter1.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);
		
		shooter1.config_kP(0, RobotMap.talonP, RobotMap.kTimeoutMs);
		shooter1.config_kI(0, RobotMap.talonI, RobotMap.kTimeoutMs);
		shooter1.config_kD(0, RobotMap.talonD, RobotMap.kTimeoutMs);
		shooter1.config_kF(0, RobotMap.talonF, RobotMap.kTimeoutMs);

		shooter1.set(ControlMode.Velocity, 0);
		
		shooter2.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, RobotMap.kTimeoutMs);
		shooter2.setSensorPhase(true);

		shooter2.configNominalOutputForward(0, RobotMap.kTimeoutMs);
		shooter2.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
		shooter2.configPeakOutputForward(1, RobotMap.kTimeoutMs);
		shooter2.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);
		
		shooter2.config_kP(0, RobotMap.talonP, RobotMap.kTimeoutMs);
		shooter2.config_kI(0, RobotMap.talonI, RobotMap.kTimeoutMs);
		shooter2.config_kD(0, RobotMap.talonD, RobotMap.kTimeoutMs);
		shooter2.config_kF(0, RobotMap.talonF, RobotMap.kTimeoutMs);

		shooter2.set(ControlMode.Velocity, 0);
	}

	public void reset() {
		
	}

	public double getSpeed() {
		return shooter1.getSelectedSensorVelocity(0);
	}

	public double getError() {
		return shooter1.getSelectedSensorVelocity(0) - shooter1.getClosedLoopTarget(0);
	}

	public double getSetpoint() {
		return shooter1.getClosedLoopTarget(0);
	}

	public void set(double speed) {
		shooter1.set(ControlMode.Velocity, speed);
		shooter2.set(ControlMode.Velocity, speed);
	}

	public void stop() {
		shooter1.neutralOutput();
		shooter2.neutralOutput();
	}
}
