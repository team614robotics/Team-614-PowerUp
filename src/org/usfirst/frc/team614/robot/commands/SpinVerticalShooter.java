package org.usfirst.frc.team614.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team614.robot.Robot;

/**
 *
 */
public class SpinVerticalShooter extends Command {
	public SpinVerticalShooter() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.verticalShooter);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.flyWheel.victorLeft.set(0);  //sets initial value to 0
		Robot.flyWheel.victorRight.set(0);  //sets initial value to 0
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.flyWheel.victorLeft.set(SmartDashboard.getNumber("Vertical Shooter Speed", 0.0));  //sets value to number in the smart dashboard
		Robot.flyWheel.victorLeft.set(-SmartDashboard.getNumber("Vertical Shooter Speed", 0.0));  //sets value to number in the smart dashboard
	}

	// Make this return false when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns false
	@Override
	protected void end() {
		Robot.flyWheel.victorLeft.set(0);  //sets value to 0 when finished
		Robot.flyWheel.victorRight.set(0);  //sets value to 0 when finished
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.flyWheel.victorLeft.set(0);  //sets value to 0 if interrupted
		Robot.flyWheel.victorRight.set(0);  //sets value to 0 interrupted
	}
}
