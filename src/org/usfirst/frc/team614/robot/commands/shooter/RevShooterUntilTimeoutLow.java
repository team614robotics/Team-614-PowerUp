package org.usfirst.frc.team614.robot.commands.shooter;

import org.usfirst.frc.team614.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RevShooterUntilTimeoutLow extends Command {

	public RevShooterUntilTimeoutLow() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.shooter);
		setTimeout(2.3);
	}

	protected void initialize() {
		Robot.shooter.setShooter(0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.shooter.setShooter(SmartDashboard.getNumber("Shooter DeliverSwitch RPM", 0));
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.shooter.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.shooter.stop();
	}
}
