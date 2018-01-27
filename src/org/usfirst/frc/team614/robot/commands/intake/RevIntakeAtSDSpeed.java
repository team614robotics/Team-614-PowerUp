
package org.usfirst.frc.team614.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team614.robot.Robot;

/**
 *
 */
public class SpinFlyWheel extends Command {
	public SpinFlyWheel() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.intake);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.intakeMotors.intakeMotorLeft.set(0);
		Robot.intakeMotors.intakeMotorRight.set(0);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.intakeMotors.IntakeMotorLeft.set(SmartDashboard.getNumber("Intake Motor Left Speed", 0.0));
		Robot.intakeMotors.intakeMotorRight.set(-SmartDashboard.getNumber("Intake Motor Right Speed", 0.0));
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.intakeMotors.intakeMotorLeft.set(0);
		Robot.intakeMotors.intakeMotorRight.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.intakeMotors.intakeMotorLeft.set(0);
		Robot.intakeMotors.intakeMotorRight.set(0);
	}
}
