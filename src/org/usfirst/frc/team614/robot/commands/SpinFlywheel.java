package org.usfirst.frc.team614.robot.commands;

import org.team708.robot.util.Gamepad;
import org.usfirst.frc.team614.robot.OI;
import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SpinFlywheel extends Command {

    public SpinFlywheel() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.flywheel);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.flywheel.victorLeft.set(0.0);
    	Robot.flywheel.victorRight.set(0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.flywheel.victorLeft.set(SmartDashboard.getNumber("Flywheel Left Motor Speed", 0.0));
    	Robot.flywheel.victorLeft.set(OI.driverGamepad.getAxis(Gamepad.leftStick_Y));
    	Robot.flywheel.victorRight.set(OI.driverGamepad.getAxis(Gamepad.leftStick_Y));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.flywheel.victorLeft.set(0);
    	Robot.flywheel.victorRight.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.flywheel.victorLeft.set(0.0);
    	Robot.flywheel.victorRight.set(0.0);
    }
}
