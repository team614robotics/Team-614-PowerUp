package org.usfirst.frc.team614.robot.commands.drivetrain;

import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */

// Makes it so signal light blinks when it is connected, use this command as
// reference when making the
// autonomous commands.

public class CollisionDetected extends Command {

	public CollisionDetected() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrainCompanion);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if ((Math.abs(Robot.drivetrainCompanion.currentJerkX) > RobotMap.kCollisionThreshold_DeltaG)
				|| (Math.abs(Robot.drivetrainCompanion.currentJerkY) > RobotMap.kCollisionThreshold_DeltaG)) {
			setTimeout(1);
			SmartDashboard.putBoolean("Accelerometer", true);
		} else {
			SmartDashboard.putBoolean("Accelerometer", false);
			setTimeout(0);
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drivetrainCompanion.runCollisionDetection();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {

		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
