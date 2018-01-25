package org.usfirst.frc.team614.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.team708.robot.util.Gamepad;
import org.usfirst.frc.team614.robot.commands.CompressorControl;
import org.usfirst.frc.team614.robot.commands.SpinFlyWheel;
import org.usfirst.frc.team614.robot.commands.TogglePiston;
import org.usfirst.frc.team614.robot.commands.autonomous.DeliverFromLeft;
import org.usfirst.frc.team614.robot.commands.autonomous.DrivePastBaseline;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveStraight;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveStraightAtSmartDashboardSpeed;

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
	
	public static final Button togglePiston = new JoystickButton(driverGamepad, Gamepad.button_Y);
	
	public OI() {
		spinFlyWheel.whenPressed(new DrivePastBaseline());
		compressorControl.whenPressed(new CompressorControl());
		togglePiston.whenPressed(new TogglePiston());
		
		
	}
}
