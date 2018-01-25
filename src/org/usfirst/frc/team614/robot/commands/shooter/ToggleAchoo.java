package org.usfirst.frc.team614.robot.commands.shooter;

import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleAchoo extends Command {

    public ToggleAchoo() {
        requires(Robot.achoo);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (Robot.achoo.getState().equals(RobotMap.achooPistonIn)) {
			Robot.achoo.setState(RobotMap.achooPistonOut);
		} else {
			Robot.achoo.setState(RobotMap.achooPistonIn);
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
