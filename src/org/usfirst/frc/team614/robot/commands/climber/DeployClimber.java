package org.usfirst.frc.team614.robot.commands.climber;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DeployClimber extends Command {

    public DeployClimber() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.climber);
    	setTimeout(10);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.climber.setServo(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.climber.setServo(Robot.climber.servoStart);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.climber.setServo(Robot.climber.servoStart);
    }
}
