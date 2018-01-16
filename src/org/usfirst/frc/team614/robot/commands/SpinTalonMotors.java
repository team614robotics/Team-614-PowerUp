package org.usfirst.frc.team614.robot.commands;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SpinTalonMotors extends Command {

	protected void initialize() {
		Robot.talonsrxmotors.set(0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.talonsrxmotors.set(SmartDashboard.getNumber(
				"Shooter CAN Talon Setpoint", 0));

		if (this.timeSinceInitialized() > 1.0) {
			Robot.talonsrxmotors.set(SmartDashboard.getNumber(
					"Shooter Feeder Speed", 0.0));
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.talonsrxmotors.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.talonsrxmotors.stop();
	}
}
