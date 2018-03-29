package org.usfirst.frc.team614.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team614.robot.commands.autonomous.CenterLeftSwitch;
import org.usfirst.frc.team614.robot.commands.autonomous.CenterRightSwitch;
import org.usfirst.frc.team614.robot.commands.autonomous.DrivePastBaseline;
import org.usfirst.frc.team614.robot.commands.autonomous.LeftScale;
import org.usfirst.frc.team614.robot.commands.autonomous.LeftScaleSwitch;
import org.usfirst.frc.team614.robot.commands.autonomous.LeftSwitch;
import org.usfirst.frc.team614.robot.commands.autonomous.RightScale;
import org.usfirst.frc.team614.robot.commands.autonomous.RightScaleSwitch;
import org.usfirst.frc.team614.robot.commands.autonomous.RightSwitch;
import org.usfirst.frc.team614.robot.subsystems.Drivetrain;
import org.usfirst.frc.team614.robot.subsystems.DrivetrainCompanion;
import org.usfirst.frc.team614.robot.subsystems.Pneumatics;
import org.usfirst.frc.team614.robot.subsystems.Shooter;
import org.usfirst.frc.team614.robot.subsystems.Intake;
import org.usfirst.frc.team614.robot.subsystems.Climber;

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
	public static Climber climber;

	public static PowerDistributionPanel pdp;
	public static OI oi;

	public static CameraServer serverOne;
	public static UsbCamera camera;
	Command autonomousCommand;
	SendableChooser<String> chooser = new SendableChooser<>();

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
<<<<<<< HEAD

		// CameraServer.getInstance().startAutomaticCapture();
		cameraInit();
=======
		
		CameraServer.getInstance().startAutomaticCapture();
>>>>>>> parent of 28a9cd3... Pre-Climber

		drivetrain = new Drivetrain();
		drivetrainCompanion = new DrivetrainCompanion();
		shooter = new Shooter();
		intake = new Intake();
		pneumatics = new Pneumatics();
		climber = new Climber();

		pdp = new PowerDistributionPanel();
		oi = new OI();

		chooser.addObject("Drive Past Baseline", "DrivePastBaseline");
		chooser.addObject("Center Switch Auto", "CenterSwitchAuto");
		chooser.addObject("Left Switch Auto", "LeftSwitchAuto");
		chooser.addObject("Right Switch Auto", "RightSwitchAuto");
		chooser.addObject("Left Scale Auto", "LeftScaleAuto");
		chooser.addObject("Right Scale Auto", "RightScaleAuto");

		SmartDashboard.putData("Autonomous", chooser);

		SmartDashboard.putNumber("Drivetrain Left Encoder Distance", 0);
		SmartDashboard.putNumber("Drivetrain Left Encoder Rate", 0);
		SmartDashboard.putNumber("Drivetrain Left Encoder Get", 0);

		SmartDashboard.putNumber("Shooter Scale High Setpoint", 13500);
<<<<<<< HEAD
		SmartDashboard.putNumber("Shooter Scale Low Setpoint", 12500);
		SmartDashboard.putNumber("Shooter Switch High Setpoint", 0.25);
		SmartDashboard.putNumber("Shooter Switch Low Setpoint", 0.17);

		SmartDashboard.putNumber("Intake Speed", 0.7);
		SmartDashboard.putNumber("Climber Speed", 0.5);
		SmartDashboard.putNumber("Accelerator High Speed", 0.7);
		SmartDashboard.putNumber("Accelerator Low Speed", 0.5);

=======
		SmartDashboard.putNumber("Shooter Scale Low Setpoint", 12000);
		SmartDashboard.putNumber("Shooter Switch High Setpoint", 6000);
		SmartDashboard.putNumber("Shooter Switch Low Setpoint", 3000);
		
		SmartDashboard.putNumber("Intake Speed", 0.5);
		SmartDashboard.putNumber("Accelerator High Speed", 0.5);
		SmartDashboard.putNumber("Accelerator Low Speed", 0.3);
		
		cameraInit();
>>>>>>> parent of 28a9cd3... Pre-Climber
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

<<<<<<< HEAD
		for (int i = 0; i < 1000; ++i) {
=======
		while (gameData.length() != 3) {
>>>>>>> parent of 28a9cd3... Pre-Climber
			try {
				Thread.sleep(5);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

			gameData = DriverStation.getInstance().getGameSpecificMessage();
<<<<<<< HEAD

			if (gameData.length() == 3) {
				break;
			}
=======
>>>>>>> parent of 28a9cd3... Pre-Climber
		}

		SmartDashboard.putBoolean("L1", gameData.charAt(0) == 'L');
		SmartDashboard.putBoolean("L2", gameData.charAt(1) == 'L');
		SmartDashboard.putBoolean("L3", gameData.charAt(2) == 'L');
		SmartDashboard.putBoolean("R1", gameData.charAt(0) == 'R');
		SmartDashboard.putBoolean("R2", gameData.charAt(1) == 'R');
		SmartDashboard.putBoolean("R3", gameData.charAt(2) == 'R');

		String chooserCommand = chooser.getSelected();

		if (chooserCommand == null) {
			autonomousCommand = null;
		} else if (chooserCommand.equals("LeftScaleAuto")) {
			if (gameData.charAt(1) == 'L' && gameData.charAt(0) == 'L') {
				autonomousCommand = new LeftScaleSwitch();
			} else if (gameData.charAt(1) == 'L') {
				autonomousCommand = new LeftScale();
			} else if (gameData.charAt(0) == 'L') {
				autonomousCommand = new LeftSwitch();
			} else {
				autonomousCommand = new DrivePastBaseline();
			}
		} else if (chooserCommand.equals("RightScaleAuto")) {
			if (gameData.charAt(1) == 'R' && gameData.charAt(0) == 'R') {
				autonomousCommand = new RightScaleSwitch();
			} else if (gameData.charAt(1) == 'R') {
				autonomousCommand = new RightScale();
			} else if (gameData.charAt(0) == 'R') {
				autonomousCommand = new RightSwitch();
			} else {
				autonomousCommand = new DrivePastBaseline();
			}
		} else if (chooserCommand.equals("LeftSwitchAuto")) {
			if (gameData.charAt(0) == 'L') {
				autonomousCommand = new LeftSwitch();
			} else if (gameData.charAt(1) == 'L') {
				autonomousCommand = new LeftScale();
			} else {
				autonomousCommand = new DrivePastBaseline();
			}
		} else if (chooserCommand.equals("RightSwitchAuto")) {
			if (gameData.charAt(0) == 'R') {
				autonomousCommand = new RightSwitch();
			} else if (gameData.charAt(1) == 'R') {
				autonomousCommand = new RightScale();
			} else {
				autonomousCommand = new DrivePastBaseline();
			}
		} else if (chooserCommand.equals("CenterSwitchAuto")) {
			if (gameData.charAt(0) == 'L') {
				autonomousCommand = new CenterLeftSwitch();
			} else if (gameData.charAt(0) == 'R') {
				autonomousCommand = new CenterRightSwitch();
			} else {
				autonomousCommand = new DrivePastBaseline();
			}
		} else {
			autonomousCommand = new DrivePastBaseline();
		}

		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
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

	public void cameraInit() {
		serverOne = CameraServer.getInstance();
		// serverOne.startAutomaticCapture();
		// serverOne.startAutomaticCapture(0)

		camera = serverOne.startAutomaticCapture(0);

<<<<<<< HEAD
		camera.setBrightness(0);
		camera.setFPS(15);
		camera.setResolution(RobotMap.IMG_HEIGHT, RobotMap.IMG_WIDTH);
=======
        camera.setExposureManual(50);
        camera.setFPS(15);
        camera.setResolution(RobotMap.IMG_HEIGHT, RobotMap.IMG_WIDTH);       
>>>>>>> parent of 28a9cd3... Pre-Climber
	}
}
