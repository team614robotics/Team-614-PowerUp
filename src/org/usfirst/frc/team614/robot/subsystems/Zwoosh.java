package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Zwoosh extends Subsystem {
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	public TalonSRX zwooshMotorA = new TalonSRX(RobotMap.zwooshMotorA);
	public TalonSRX zwooshMotorB = new TalonSRX(RobotMap.zwooshMotorB);

	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	zwooshMotorA.set(ControlMode.Velocity,0);
		zwooshMotorB.set(ControlMode.Velocity, 0);
    	
    
    }


	public void reset() {
		// TODO Auto-generated method stub
		
	}
}

