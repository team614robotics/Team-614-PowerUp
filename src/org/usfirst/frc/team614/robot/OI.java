package org.usfirst.frc.team614.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.team708.robot.util.Gamepad;
import org.usfirst.frc.team614.robot.commands.intake.RevIntake;
import org.usfirst.frc.team614.robot.commands.intake.RevOutake;
import org.usfirst.frc.team614.robot.commands.intake.ToggleIntakePiston;
import org.usfirst.frc.team614.robot.commands.intake.ToggleLoaderPiston;
import org.usfirst.frc.team614.robot.commands.shooter.DeliverScale;
import org.usfirst.frc.team614.robot.commands.shooter.DeliverSwitch;
import org.usfirst.frc.team614.robot.commands.shooter.RevAcceleratorLow;
import org.usfirst.frc.team614.robot.commands.shooter.RevShooter;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// // joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a\[] button, it's trivial to bind it to a button in one of
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

	private static final Button revIntake = new JoystickButton(operatorGamepad, Gamepad.button_A);
	private static final Button revOutake = new JoystickButton(operatorGamepad, Gamepad.button_B);
	
	private static final Button toggleIntakePiston = new JoystickButton(operatorGamepad, Gamepad.button_X);
	private static final Button toggleLoaderPiston = new JoystickButton(operatorGamepad, Gamepad.button_Y);
	
	private static final Button deliverScale = new JoystickButton(operatorGamepad, Gamepad.button_L_Shoulder);
	private static final Button deliverSwitch = new JoystickButton(operatorGamepad, Gamepad.button_R_Shoulder);

	public OI() {
		revIntake.whileHeld(new RevIntake());
		revOutake.whileHeld(new RevOutake());
		
		toggleIntakePiston.whenPressed(new ToggleIntakePiston());
		toggleLoaderPiston.whenPressed(new ToggleLoaderPiston());
		
		deliverScale.whileHeld(new DeliverScale());
		deliverSwitch.whileHeld(new DeliverSwitch());
	}
}
