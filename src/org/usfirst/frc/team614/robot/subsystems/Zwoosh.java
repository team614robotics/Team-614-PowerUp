package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Zwoosh extends Subsystem {

	public TalonSRX talonSRXZwooshLeft = new TalonSRX(RobotMap.zwooshLeft);
	public TalonSRX talonSRXZwooshRight = new TalonSRX(RobotMap.zwooshRight);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	talonSRXZwooshLeft.set(ControlMode.Velocity, 0);
		talonSRXZwooshRight.set(ControlMode.Velocity, 0);
    }
}

