package org.usfirst.frc.team614.robot.commands.intake;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleIntakeLight extends Command {

    public ToggleIntakeLight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if(!Robot.intake.intakeLimitSwitch.get()){
    		setTimeout(2147483647);
    		if(!isTimedOut()){   		
    		if(!Robot.intake.intakeLimitSwitch.get() && timeSinceInitialized() < .5 ) {
        		Robot.pneumatics.intakeRingLight.set(true);
        	}
        	else if(!Robot.intake.intakeLimitSwitch.get() && timeSinceInitialized() > .5 && timeSinceInitialized() < 1 ) {
        		Robot.pneumatics.intakeRingLight.set(false);
        	}
        	else if(!Robot.intake.intakeLimitSwitch.get() && timeSinceInitialized() > 1 && timeSinceInitialized() < 1.5 ) {
        		Robot.pneumatics.intakeRingLight.set(true);
        	}
        	else if(!Robot.intake.intakeLimitSwitch.get() && timeSinceInitialized() > 1.5 && timeSinceInitialized() < 2 ) {
        		Robot.pneumatics.intakeRingLight.set(false);
        	}
        	else if(!Robot.intake.intakeLimitSwitch.get() && timeSinceInitialized() > 2 && timeSinceInitialized() < 2.5 ) {
        		Robot.pneumatics.intakeRingLight.set(true);
        	}
        	else if(!Robot.intake.intakeLimitSwitch.get() && timeSinceInitialized() > 2.5 && timeSinceInitialized() < 3 ) {
        		Robot.pneumatics.intakeRingLight.set(false);
        	}
        	else if(!Robot.intake.intakeLimitSwitch.get() && timeSinceInitialized() > 3 ) {
        		Robot.pneumatics.intakeRingLight.set(false);        		
        	}
    	   else{
    	        Robot.pneumatics.intakeRingLight.set(false);
    	    }
    		}
    	  
    	}
    	else
    	{
        	Robot.pneumatics.intakeRingLight.set(false);
        	setTimeout(0);
        }
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
