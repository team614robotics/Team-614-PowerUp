package org.usfirst.frc.team614.robot.commands.shooter;

import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TogglePiston extends Command {

	public TogglePiston() {
		requires(Robot.intakePneumatics);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if (Robot.intakePneumatics.getState().equals(RobotMap.PistonIn)) {
			Robot.intakePneumatics.setState(RobotMap.PistonOut);
		} else {
			Robot.intakePneumatics.setState(RobotMap.PistonIn);
		}

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
