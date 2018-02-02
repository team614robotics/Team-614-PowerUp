package org.usfirst.frc.team614.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team614.robot.commands.autonomous.DoNothing;
import org.usfirst.frc.team614.robot.subsystems.Drivetrain;
import org.usfirst.frc.team614.robot.subsystems.DrivetrainCompanion;
import org.usfirst.frc.team614.robot.subsystems.Pneumatics;
import org.usfirst.frc.team614.robot.subsystems.Shooter;
import org.usfirst.frc.team614.robot.subsystems.Intake;

import com.kauailabs.navx.frc.AHRS;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static AHRS navX;

	public static Shooter shooter;
	public static Drivetrain drivetrain;
	public static DrivetrainCompanion drivetrainCompanion;
	public static Intake intake;
	public static Pneumatics pneumatics;
	

	public static PowerDistributionPanel pdp;
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		try {
			navX = new AHRS(SPI.Port.kMXP, (byte) 200);
		} catch (RuntimeException ex) {
			DriverStation.reportError(
					"Error instantiating navX MXP:  " + ex.getMessage(), true);
		}

		drivetrain = new Drivetrain();
		drivetrainCompanion = new DrivetrainCompanion();
		shooter = new Shooter();
		intake = new Intake();
		pneumatics = new Pneumatics();

		pdp = new PowerDistributionPanel();
		oi = new OI();
		chooser.addDefault("Default Auto", new DoNothing());

		SmartDashboard.putData("Autonomous", chooser);
		
		SmartDashboard.putNumber("Drivetrain Left Encoder Distance", 0);
		SmartDashboard.putNumber("Drivetrain Right Encoder Distance", 0);

		SmartDashboard.putNumber("Shooter Low RPM", 0);
		SmartDashboard.putNumber("Shooter High RPM", 0);
		SmartDashboard.putNumber("Shooter RPM", 0);
		SmartDashboard.putNumber("Intake Speed", 0);
		SmartDashboard.putNumber("High Accelerator Speed", 0);
		SmartDashboard.putNumber("Low Accelerator Speed", 0);
		SmartDashboard.putNumber("High Accelerator Intialize Time", 0);
		SmartDashboard.putNumber("Low Accelerator Intialize Time", 0);

		SmartDashboard.putNumber("Shooter High Timeout", 0);
		SmartDashboard.putNumber("Shooter Low Timeout", 0);
		SmartDashboard.putNumber("Shooter Switch Timeout", 0);
		
		// Use Values for Testing
		SmartDashboard.putNumber("P", 0.26);
		SmartDashboard.putNumber("I", 0.0001);
		SmartDashboard.putNumber("D", 0.4);
		SmartDashboard.putNumber("F", 0.404);

		SmartDashboard.putBoolean("Go For Scale", false);

		SmartDashboard.putBoolean("L1", false);
		SmartDashboard.putBoolean("L2", false);
		SmartDashboard.putBoolean("L3", false);
		SmartDashboard.putBoolean("R1", false);
		SmartDashboard.putBoolean("R1", false);
		SmartDashboard.putBoolean("R1", false);

		SmartDashboard.putNumber("Drivetrain Target Speed", 0);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		// resets NavX and disables the PID controller.
		Robot.navX.reset();
		drivetrain.reset();

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		// resets NavX and disables the PID controller.
		Robot.navX.reset();
		drivetrain.reset();

		String gameData = DriverStation.getInstance().getGameSpecificMessage();

		SmartDashboard.putBoolean("L1", gameData.charAt(0) == 'L');
		SmartDashboard.putBoolean("L2", gameData.charAt(1) == 'L');
		SmartDashboard.putBoolean("L3", gameData.charAt(2) == 'L');
		SmartDashboard.putBoolean("R1", gameData.charAt(0) == 'R');
		SmartDashboard.putBoolean("R2", gameData.charAt(1) == 'R');
		SmartDashboard.putBoolean("R3", gameData.charAt(2) == 'R');

		autonomousCommand = chooser.getSelected();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new SpinFlyWheel(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		
		Robot.navX.reset();
		drivetrain.reset();
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();

	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		SmartDashboard.putNumber("Drivetrain Left Encoder Distance",
				drivetrain.leftEncoder.getDistance());
		SmartDashboard.putNumber("Drivetrain Right Encoder Distance",
				drivetrain.rightEncoder.getDistance());
		SmartDashboard.putNumber("Shooter Speed",
				shooter.getSpeed());
		SmartDashboard.putNumber("Shooter Error",
				shooter.getError());
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
