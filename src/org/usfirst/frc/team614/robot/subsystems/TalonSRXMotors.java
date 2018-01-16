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
	public TalonSRX talonMaster = new TalonSRX(RobotMap.talonMaster);
	public TalonSRX talonSlave = new TalonSRX(RobotMap.talonSlave);

	public void initDefaultCommand() {
        talonMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		talonMaster.setSensorPhase(true);

		talonMaster.configNominalOutputForward(0, 10);
		talonMaster.configNominalOutputReverse(0, 10);
		talonMaster.configPeakOutputForward(1, 10);
		talonMaster.configPeakOutputReverse(-1, 10);

//		talonMaster.reverseSensor(false);
//		talonMaster.reverseOutput(true);
//
//		talonMaster.setProfile(1);
		
		talonMaster.config_kP(0, RobotMap.talonP, 10);
		talonMaster.config_kI(0, RobotMap.talonI, 10);
		talonMaster.config_kD(0, RobotMap.talonD, 10);
		talonMaster.config_kF(0, RobotMap.talonF, 10);

		talonMaster.set(ControlMode.Velocity, 0);

//		talonMaster.enable();

        talonSlave.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
        
        talonSlave.configNominalOutputForward(0, 10);
        talonSlave.configNominalOutputReverse(0, 10);
        talonSlave.configPeakOutputForward(1, 10);
        talonSlave.configPeakOutputReverse(-1, 10);
        
//		talonSlave.setVoltageRampRate(36.0);
//		talonSlave.setStatusFrameRateMs(StatusFrameRate.Feedback, 10);
//		talonSlave.clearStickyFaults();
//
//		talonSlave.setProfile(1);

		talonSlave.config_kP(0, RobotMap.talonP, 10);
		talonSlave.config_kI(0, RobotMap.talonI, 10);
		talonSlave.config_kD(0, RobotMap.talonD, 10);
		talonSlave.config_kF(0, RobotMap.talonF, 10);

//		talonSlave.set(0.0);
//
//		talonSlave.enable();
//
//		talonSlave.changeControlMode(TalonSRX.TalonControlMode.Follower);
//		talonSlave.set(talonMaster.getDeviceID());
//		talonSlave.reverseOutput(true);
	}

	public void reset() {
		
	}
	
//	public double getDistance() {
//		return talonMaster.getDistance();
//	}

	public double getSpeed() {
		return talonMaster.getSelectedSensorVelocity(0);
	}

	public double getError() {
		return talonMaster.getSelectedSensorVelocity(0) - talonMaster.getClosedLoopTarget(0);
	}

	public double getSetpoint() {
		return talonMaster.getClosedLoopTarget(0);
	}

	public void set(double speed) {
		talonMaster.set(ControlMode.Velocity, speed);
		talonSlave.set(ControlMode.Follower, speed);
	}

	public void stop() {
		talonMaster.neutralOutput();
	}
}
