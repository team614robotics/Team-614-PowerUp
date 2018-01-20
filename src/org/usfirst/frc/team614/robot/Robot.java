
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

import org.usfirst.frc.team614.robot.commands.SpinFlyWheel;
import org.usfirst.frc.team614.robot.subsystems.Clamp;
import org.usfirst.frc.team614.robot.subsystems.Drivetrain;
import org.usfirst.frc.team614.robot.subsystems.DrivetrainCompanion;
import org.usfirst.frc.team614.robot.subsystems.FlyWheel;
import org.usfirst.frc.team614.robot.subsystems.TalonSRXMotors;
import org.usfirst.frc.team614.robot.subsystems.VerticalShooter;

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
	
	public static TalonSRXMotors talonsrxmotors;
	public static FlyWheel flyWheel;
	public static Drivetrain drivetrain;
	public static DrivetrainCompanion drivetrainCompanion;
	public static VerticalShooter verticalShooter = new VerticalShooter();
	public static Clamp clamp = new Clamp();
	
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
            navX = new AHRS(SPI.Port.kMXP,(byte)200);
        } catch (RuntimeException ex ) {
            DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
        }
		
		flyWheel = new FlyWheel();
		drivetrain = new Drivetrain();
		drivetrainCompanion = new DrivetrainCompanion();
		//verticalShooter = new VerticalShooter();
		//clamp = new Clamp();

    	pdp = new PowerDistributionPanel();
		oi = new OI();
		chooser.addDefault("Default Auto", new SpinFlyWheel());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Autonomous", chooser);

        SmartDashboard.putNumber("Left Fly Wheel Speed", 0);
        SmartDashboard.putNumber("Right Fly Wheel Speed", 0);
        SmartDashboard.putNumber("Vertical Shooter Speed", 0);
        
        SmartDashboard.putBoolean("L1", false);
        SmartDashboard.putBoolean("L2", false);
        SmartDashboard.putBoolean("L3", false);
        SmartDashboard.putBoolean("R1", false);
        SmartDashboard.putBoolean("R1", false);
        SmartDashboard.putBoolean("R1", false);
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
<<<<<<< HEAD
=======

>>>>>>> origin/master
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
		if (autonomousCommand != null) autonomousCommand.start();
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
		// this line or comment it out.
		if (autonomousCommand != null) autonomousCommand.cancel();
		
    	Robot.navX.reset();
    	drivetrain.reset();
    	
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
