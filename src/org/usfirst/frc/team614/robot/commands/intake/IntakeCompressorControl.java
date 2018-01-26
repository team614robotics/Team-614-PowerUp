package org.usfirst.frc.team614.robot.commands.intake;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeCompressorControl extends Command {

	public IntakeCompressorControl() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.intake);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.intake.compressor.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.intake.compressor.enabled()) {
			if (DriverStation.getInstance().getBatteryVoltage() < 9.5) {
				Robot.intake.compressor.stop();
			}
		} else {
			if (DriverStation.getInstance().getBatteryVoltage() > 10.5) {
				Robot.intake.compressor.start();
			}
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.intake.compressor.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.intake.compressor.stop();
	}
}