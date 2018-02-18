package org.usfirst.frc.team614.robot.commands.drivetrain;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// 	NAVX DEGREE ORIENTATION:
// 			 0
// 	    -45 \|/ +45
// 	  -90  --X--  +90
//	   -135 /|\ +135
//		  +/-180

public class RotateToAngle extends Command {
	private double angle = 0;
	private boolean useAbsoluteAngle = false;

	public RotateToAngle(double angle, boolean useAbsoluteAngle) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
		this.angle = angle;
		this.useAbsoluteAngle = useAbsoluteAngle;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.drivetrain.setUsingTurnPID(true);

		if (useAbsoluteAngle) {
			Robot.drivetrain.getTurnController().setSetpoint(angle % 360);
		} else {
			Robot.drivetrain.getTurnController().setSetpoint((Robot.navX.getYaw() + angle));
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drivetrain.arcadeDrive(0.0, .7 * Robot.drivetrain.getPIDRotateRate());
	}

	protected boolean isFinished() {
		if (this.timeSinceInitialized() > 1 && Robot.drivetrain.leftEncoder.getRate() < 10.0
				&& Robot.drivetrain.leftEncoder.getRate() > -10.0) {
			return true;
		}

		return false;
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
