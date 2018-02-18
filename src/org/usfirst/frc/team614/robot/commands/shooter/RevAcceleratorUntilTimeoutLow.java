package org.usfirst.frc.team614.robot.commands.shooter;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RevAcceleratorUntilTimeoutLow extends Command {

	public RevAcceleratorUntilTimeoutLow() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.shooter);
		setTimeout(2.3);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.shooter.setAccelerator(0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (this.timeSinceInitialized() > 1.7) {    		
    	    Robot.shooter.setAccelerator(SmartDashboard.getNumber("Low Accelerator Speed", 0));
    	}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.shooter.setAccelerator(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.shooter.setAccelerator(0);
	}
}