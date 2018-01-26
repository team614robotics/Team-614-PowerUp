package org.usfirst.frc.team614.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

import org.team708.robot.util.Gamepad;
import org.usfirst.frc.team614.robot.commands.SpinFlyWheel;
import org.usfirst.frc.team614.robot.commands.autonomous.DeliverFromLeft;
import org.usfirst.frc.team614.robot.commands.autonomous.DrivePastBaseline;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveStraight;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveStraightAtSmartDashboardSpeed;
import org.usfirst.frc.team614.robot.commands.shooter.ZwooshHigh;
import org.usfirst.frc.team614.robot.subsystems.Zwoosh;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new SpinFlyWheel());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new SpinFlyWheel());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new SpinFlyWheel());
	
	public static final Gamepad driverGamepad = new Gamepad(0);
	public static final Gamepad operatorGamepad = new Gamepad(1);
	
	private static final Button spinFlyWheel = new JoystickButton(driverGamepad, Gamepad.button_X);
	private static final Button spinVerticalShooter = new JoystickButton(driverGamepad, Gamepad.button_B);
	private static final Button compressorControl = new JoystickButton(driverGamepad, Gamepad.button_A);
<<<<<<< HEAD
	public static final Button togglePiston = new JoystickButton(driverGamepad, Gamepad.button_Y);
	
	
	private static final Button revIntakeAtSDSpeed = new JoystickButton(operatorGamepad, Gamepad.button_R_Shoulder);
	private static final Button toggleIntakePneumatics = new JoystickButton(operatorGamepad, Gamepad.button_Y);
	//Maybe we will mesh these together in a command group but not now
=======
	private static final Button togglePusherPneumatics = new JoystickButton(driverGamepad, Gamepad.button_Y);
	private static final Button shootAtSmartDashboardSpeed = new JoystickButton(driverGamepad, Gamepad.button_R_Shoulder);
>>>>>>> parent of 23ccb17... added accelerators
	
	
	public OI() {
		spinFlyWheel.whenPressed(new DrivePastBaseline());
<<<<<<< HEAD
=======
		togglePusherPneumatics.whenPressed(new TogglePusherPneumatics());
		shootAtSmartDashboardSpeed.whileHeld(new ShootAtSmartDashboardSpeed());
		
		
>>>>>>> parent of 23ccb17... added accelerators

		
		
		
		
	}
}
