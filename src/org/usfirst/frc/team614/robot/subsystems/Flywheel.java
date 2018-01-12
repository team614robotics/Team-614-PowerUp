package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Flywheel extends Subsystem {
		
	public VictorSP victorLeft = new VictorSP(RobotMap.flywheelVictorLeft);
	public VictorSP victorRight = new VictorSP(RobotMap.flywheelVictorRight);
	
    public void initDefaultCommand() {
        victorLeft.set(0);
        victorRight.set(0);
    }
}

