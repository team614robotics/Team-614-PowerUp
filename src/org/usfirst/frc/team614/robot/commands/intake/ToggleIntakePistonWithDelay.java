package org.usfirst.frc.team614.robot.commands.intake;

import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ToggleIntakePistonWithDelay extends Command {

	public ToggleIntakePistonWithDelay() {
		requires(Robot.intake);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return this.timeSinceInitialized() > SmartDashboard.getNumber("Intake Piston Delay", 0);
	}

	// Called once after isFinished returns true
	protected void end() {
		if (timeSinceInitialized() > SmartDashboard.getNumber("Intake Piston Delay", 0.0)) {
			if (Robot.pneumatics.getIntakeState().equals(RobotMap.pistonIn)) {
				Robot.pneumatics.setIntakeState(RobotMap.pistonOut);
			} else {
				Robot.pneumatics.setIntakeState(RobotMap.pistonIn);
			}
		}
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
