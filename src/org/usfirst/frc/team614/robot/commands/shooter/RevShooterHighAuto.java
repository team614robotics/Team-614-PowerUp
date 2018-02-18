package org.usfirst.frc.team614.robot.commands.shooter;

import org.usfirst.frc.team614.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RevShooterHighAuto extends Command {
	public RevShooterHighAuto() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.shooter);
		requires(Robot.intake);
		setTimeout(2.5);
	}

	protected void initialize() {
		Robot.shooter.setShooter(0);
		Robot.shooter.setAccelerator(0);
		Robot.intake.set(0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.shooter.setShooter(SmartDashboard.getNumber("Shooter High Setpoint", 0));
		if (timeSinceInitialized() > 1.7) {
			Robot.shooter.setAccelerator(SmartDashboard.getNumber("Accelerator High Speed", 0));
			Robot.intake.set(SmartDashboard.getNumber("Intake Speed", 0));
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.shooter.stop();
		Robot.intake.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.shooter.stop();
		Robot.intake.set(0);
	}
}
