package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class VerticalShooter extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public VictorSP victorLeft = new VictorSP(RobotMap.verticalShooterLeft);
	public VictorSP victorRight = new VictorSP(RobotMap.verticalShooterRight);

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		
		victorLeft.set(0);
		victorRight.set(0);
	}
}
