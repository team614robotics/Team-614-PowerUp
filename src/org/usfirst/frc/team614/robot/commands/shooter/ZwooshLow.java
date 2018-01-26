package org.usfirst.frc.team614.robot.commands.shooter;

import org.usfirst.frc.team614.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ZwooshLow extends Command {

    public ZwooshLow() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.zwoosh);
    	setTimeout(SmartDashboard.getNumber("Zwoosh Low Timeout", 0));
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.zwoosh.talonSRXZwooshLeft.set(ControlMode.Velocity, 0);
    	Robot.zwoosh.talonSRXZwooshRight.set(ControlMode.Velocity, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.zwoosh.talonSRXZwooshLeft.set(ControlMode.Velocity,SmartDashboard.getNumber("Low Zwoosh Left Motor Speed", 0));
    	Robot.zwoosh.talonSRXZwooshRight.set(ControlMode.Velocity,SmartDashboard.getNumber("Low Zwoosh Right Motor Speed", 0));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.zwoosh.talonSRXZwooshLeft.set(ControlMode.Velocity,0);
    	Robot.zwoosh.talonSRXZwooshLeft.set(ControlMode.Velocity,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.zwoosh.talonSRXZwooshLeft.set(ControlMode.Velocity,0);
    	Robot.zwoosh.talonSRXZwooshLeft.set(ControlMode.Velocity,0);
    }
}
