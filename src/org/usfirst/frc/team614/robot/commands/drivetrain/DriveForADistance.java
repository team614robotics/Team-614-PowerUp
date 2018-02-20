
package org.usfirst.frc.team614.robot.commands.drivetrain;


import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Makes the drivetrain drive straight for a distance in inches
 */
public class DriveForADistance extends Command
{
	private double distance, speed;

	public DriveForADistance(double distance, double speed)
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drivetrain);
		this.distance = distance;
		this.speed = speed;
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		Robot.drivetrain.leftEncoder.reset();
		Robot.drivetrain.setUsingTurnPID(true);
        Robot.drivetrain.getTurnController().setSetpoint(Robot.navX.getYaw());
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		SmartDashboard.putNumber("PID Rotate Rate", Robot.drivetrain.getPIDRotateRate());
		Robot.drivetrain.arcadeDrive(speed, 0.5 * Robot.drivetrain.getPIDRotateRate());
	}
	
	protected boolean isFinished()
	{
		return Robot.drivetrain.leftEncoder.getDistance() > distance * 1.18;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		Robot.drivetrain.setUsingTurnPID(false);
		Robot.drivetrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		Robot.drivetrain.setUsingTurnPID(false);
		Robot.drivetrain.stop();
	}
}
