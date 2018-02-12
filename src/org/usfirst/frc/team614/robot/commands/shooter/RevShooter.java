package org.usfirst.frc.team614.robot.commands.shooter;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RevShooter extends Command {
	Timer timer = new Timer();

	public RevShooter() {
		timer = new Timer();
		timer.start();
	}

	protected void initialize() {
		timer.reset();
		Robot.shooter.setShooter(0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.shooter.setShooter(SmartDashboard.getNumber("Shooter RPM", 0));
		SmartDashboard.putNumber("Shooter Timer", timer.get());
		SmartDashboard.putNumber("Shooter Error Left", Robot.shooter.getErrorLeft());
		SmartDashboard.putNumber("Shooter Error Right", Robot.shooter.getErrorRight());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return timer.get() > 2;
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
