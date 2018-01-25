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
    	setTimeout(SmartDashboard.getNumber("ZwooshLow TimeOut", 0));
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.zwoosh.zwooshMotorA.set(ControlMode.Velocity, 0);
    	Robot.zwoosh.zwooshMotorB.set(ControlMode.Velocity, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.zwoosh.zwooshMotorA.set(ControlMode.Velocity,SmartDashboard.getNumber("ZwooshLow MotorA Speed", 0));
    	Robot.zwoosh.zwooshMotorB.set(ControlMode.Velocity,SmartDashboard.getNumber("ZwooshLow MotorB Speed", 0));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.zwoosh.zwooshMotorA.set(ControlMode.Velocity,0);
    	Robot.zwoosh.zwooshMotorB.set(ControlMode.Velocity,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.zwoosh.zwooshMotorA.set(ControlMode.Velocity,0);
    	Robot.zwoosh.zwooshMotorB.set(ControlMode.Velocity,0);
    }
}
