package org.usfirst.frc.team614.robot.commands.drivetrain;

import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveUntilCollisionDetected extends Command {
	double speed;

	public DriveUntilCollisionDetected(double speed) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
		this.speed = speed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.drivetrain.setUsingTurnPID(true);

		Robot.drivetrain.getTurnController().setSetpoint(Robot.navX.getYaw());
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drivetrain.arcadeDrive(speed, 0);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if ((Math.abs(Robot.drivetrainCompanion.currentJerkX) > RobotMap.kCollisionThreshold_DeltaG)
				|| (Math.abs(Robot.drivetrainCompanion.currentJerkY) > RobotMap.kCollisionThreshold_DeltaG)) {
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drivetrain.setUsingTurnPID(false);
		Robot.drivetrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.drivetrain.setUsingTurnPID(false);
		Robot.drivetrain.stop();
	}
}
