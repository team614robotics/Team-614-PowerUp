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

import org.usfirst.frc.team614.robot.commands.autonomous.DeliverFromCenter;
import org.usfirst.frc.team614.robot.commands.autonomous.DeliverFromLeft;
import org.usfirst.frc.team614.robot.commands.autonomous.DeliverFromLeftScale;
import org.usfirst.frc.team614.robot.commands.autonomous.DeliverFromRight;
import org.usfirst.frc.team614.robot.commands.autonomous.DeliverFromRightScale;
import org.usfirst.frc.team614.robot.commands.autonomous.DoNothing;
import org.usfirst.frc.team614.robot.commands.autonomous.DrivePastBaseline;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveForADistance;
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
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		try {
			navX = new AHRS(SPI.Port.kMXP, (byte) 200);
		} catch (RuntimeException ex) {
			DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
		}

		drivetrain = new Drivetrain();
		drivetrainCompanion = new DrivetrainCompanion();
		shooter = new Shooter();
		intake = new Intake();
		pneumatics = new Pneumatics();

		pdp = new PowerDistributionPanel();
		oi = new OI();

		chooser.addObject("Drive Past Baseline", new DrivePastBaseline());
		chooser.addObject("Deliver From Center", new DeliverFromCenter());
		chooser.addObject("Deliver From Left", new DeliverFromLeft());
		chooser.addObject("Deliver From Right", new DeliverFromRight());
		chooser.addObject("Deliver From Left Scale", new DeliverFromLeftScale());
		chooser.addObject("Deliver From Right Scale", new DeliverFromRightScale());
//		chooser.addObject("D Nothing", new DoNothing());

		SmartDashboard.putData("Autonomous", chooser);

		SmartDashboard.putNumber("Drivetrain Left Encoder Distance", 0);
		SmartDashboard.putNumber("Drivetrain Left Encoder Rate", 0);
		SmartDashboard.putNumber("Drivetrain Left Encoder Get", 0);

		SmartDashboard.putNumber("Shooter High Setpoint", 15000);
		SmartDashboard.putNumber("Shooter Low Setpoint", 3000);
		SmartDashboard.putNumber("Intake Speed", 0.5);
		SmartDashboard.putNumber("Accelerator High Speed", 0.5);
		SmartDashboard.putNumber("Accelerator Low Speed", 0.3);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
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
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		// resets NavX and disables the PID controller.
		Robot.navX.reset();
		drivetrain.reset();

		String gameData = DriverStation.getInstance().getGameSpecificMessage();

		while (gameData.length() != 3) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

			gameData = DriverStation.getInstance().getGameSpecificMessage();
		}

		RobotMap.left1 = gameData.charAt(0) == 'L';
		RobotMap.left2 = gameData.charAt(1) == 'L';
		RobotMap.left3 = gameData.charAt(2) == 'L';
		
		SmartDashboard.putBoolean("L1", gameData.charAt(0) == 'L');
		SmartDashboard.putBoolean("L2", gameData.charAt(1) == 'L');
		SmartDashboard.putBoolean("L3", gameData.charAt(2) == 'L');
		SmartDashboard.putBoolean("R1", gameData.charAt(0) == 'R');
		SmartDashboard.putBoolean("R2", gameData.charAt(1) == 'R');
		SmartDashboard.putBoolean("R3", gameData.charAt(2) == 'R');

		autonomousCommand = chooser.getSelected();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		 * switch(autoSelected) { case "My Auto": autonomousCommand = new
		 * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
		 * SpinFlyWheel(); break; }
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
		SmartDashboard.putNumber("Drivetrain Left Encoder Distance", drivetrain.leftEncoder.getDistance());
		SmartDashboard.putNumber("Drivetrain Left Encoder Rate", drivetrain.leftEncoder.getRate());
		SmartDashboard.putNumber("Drivetrain Left Encoder Get", drivetrain.leftEncoder.get());
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
		SmartDashboard.putNumber("Drivetrain Left Encoder Distance", drivetrain.leftEncoder.getDistance());
		SmartDashboard.putNumber("Drivetrain Left Encoder Rate", drivetrain.leftEncoder.getRate());
		SmartDashboard.putNumber("Drivetrain Left Encoder Get", drivetrain.leftEncoder.get());
		SmartDashboard.putNumber("navX Yaw", Robot.navX.getYaw());
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
