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

public class DriveToTarget extends Command {
	private int pipeline;
	private int camMode;

	public DriveToTarget(int pipeline, int camMode) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
		requires(Robot.vision);
		// requires(Robot.arm);

		this.pipeline = pipeline;
		this.camMode = camMode;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.vision.setPipeline(pipeline);
		Robot.vision.setCamMode(camMode);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double c = Robot.vision.getX() < 0 ? -0.35 : 0.35;
		Robot.drivetrain.arcadeDrive(Robot.vision.getDistance() * -0.0035 - 0.35, (Robot.vision.getX() * 0.023) + c);
//		Robot.vision.getDistance() * -0.0035 - 0.35
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		// return Robot.vision.getDistance() < 35;
		
		boolean stopped = this.timeSinceInitialized() > 1.5 && SmartDashboard.getBoolean("Collision Detected", false);
		
//		if (stopped) {
//			Robot.vision.setLED();
//		}
		
		 return stopped;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drivetrain.stop();
		Robot.vision.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.drivetrain.stop();
		Robot.vision.stop();
	}
}