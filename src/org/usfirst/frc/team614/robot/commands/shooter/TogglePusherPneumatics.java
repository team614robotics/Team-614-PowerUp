package org.usfirst.frc.team614.robot.commands.shooter;

import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TogglePusherPneumatics extends Command {

    public TogglePusherPneumatics() {
        requires(Robot.pusherPneumatics);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (Robot.pusherPneumatics.getState().equals(RobotMap.pusherPneumaticsPistonIn)) {
			Robot.pusherPneumatics.setState(RobotMap.pusherPneumaticsPistonOut);
		} else {
			Robot.pusherPneumatics.setState(RobotMap.pusherPneumaticsPistonIn);
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
