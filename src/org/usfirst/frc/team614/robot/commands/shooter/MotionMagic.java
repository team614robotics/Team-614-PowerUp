package org.usfirst.frc.team614.robot.commands.shooter;

import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.subsystems.Shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MotionMagic extends Command {

	public MotionMagic() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.shooter);
	}

	protected void initialize() {
//		Robot.shooter.setShooter(0, true);
		Robot.shooter.setAccelerator(0);
		Robot.shooter.shooterLeft.setSelectedSensorPosition(0, 0, 10);
		Robot.shooter.setShooter(0, true);
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.shooter.shooterLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, RobotMap.kTimeoutMs);
		Robot.shooter.shooterLeft.configMotionAcceleration(75, 0);
		Robot.shooter.shooterLeft.configMotionCruiseVelocity(75, 0);
		Robot.shooter.shooterLeft.set(ControlMode.MotionMagic, -12000);
		SmartDashboard.putNumber("Encoder Ticks", Robot.shooter.shooterLeft.getSelectedSensorPosition(0));
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.shooter.shooterLeft.getSelectedSensorPosition(0) > 12000;
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
