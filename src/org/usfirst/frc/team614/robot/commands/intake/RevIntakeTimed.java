package org.usfirst.frc.team614.robot.commands.intake;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RevIntakeTimed extends Command {

    public RevIntakeTimed() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);

    }

	protected void initialize() {
		Robot.intake.set(0);
		setTimeout(2);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.intake.set(SmartDashboard.getNumber("Intake Speed", 0));
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.intake.set(0);;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.intake.set(0);
	}
}