package org.usfirst.frc.team614.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.team708.robot.util.Gamepad;
import org.usfirst.frc.team614.robot.commands.autonomous.DeliverFromLeft;
import org.usfirst.frc.team614.robot.commands.autonomous.DeliverFromRight;
import org.usfirst.frc.team614.robot.commands.autonomous.DrivePastBaseline;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveUntilCollisionDetected;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;
import org.usfirst.frc.team614.robot.commands.intake.RevIntake;
import org.usfirst.frc.team614.robot.commands.intake.RevOutake;
import org.usfirst.frc.team614.robot.commands.intake.ToggleIntakePiston;
import org.usfirst.frc.team614.robot.commands.intake.ToggleLoaderPiston;
import org.usfirst.frc.team614.robot.commands.shooter.RevShooter;
import org.usfirst.frc.team614.robot.commands.shooter.RevShooterHigh;
import org.usfirst.frc.team614.robot.commands.shooter.RevShooterHighAuto;
import org.usfirst.frc.team614.robot.commands.shooter.RevShooterLow;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static final Gamepad driverGamepad = new Gamepad(0);
	public static final Gamepad operatorGamepad = new Gamepad(1);

	private static final Button revIntake = new JoystickButton(operatorGamepad, Gamepad.button_A);
	private static final Button revOutake = new JoystickButton(operatorGamepad, Gamepad.button_B);

	private static final Button toggleIntakePiston = new JoystickButton(operatorGamepad, Gamepad.button_X);
	private static final Button toggleLoaderPiston = new JoystickButton(operatorGamepad, Gamepad.button_Y);

	private static final Button deliverScale = new JoystickButton(operatorGamepad, Gamepad.button_L_Shoulder);
	private static final Button deliverSwitch = new JoystickButton(operatorGamepad, Gamepad.button_R_Shoulder);

	// private static final Button auto1 = new JoystickButton(driverGamepad,
	// Gamepad.button_L_Shoulder);
	// private static final Button auto2 = new JoystickButton(driverGamepad,
	// Gamepad.button_R_Shoulder);
	// private static final Button auto3 = new JoystickButton(driverGamepad,
	// Gamepad.button_B);
	// private static final Button auto4 = new JoystickButton(driverGamepad,
	// Gamepad.button_A);
	// private static final Button auto5 = new JoystickButton(driverGamepad,
	// Gamepad.button_Y);
	// private static final Button auto6 = new JoystickButton(driverGamepad,
	// Gamepad.button_X);

	public OI() {
		revIntake.whileHeld(new RevIntake());
		revOutake.whileHeld(new RevOutake());

		toggleIntakePiston.whenPressed(new ToggleIntakePiston());
		toggleLoaderPiston.whenPressed(new ToggleLoaderPiston());

		deliverScale.whileHeld(new RevShooterHigh());
		deliverSwitch.whileHeld(new RevShooterLow());

		// auto1.whenPressed(new DriveForADistance(320, 0.5));
		// auto2.whenPressed(new RotateToAngle(90, false));
		// auto3.whenPressed(new DrivePastBaseline());
		// auto5.whenPressed(new DeliverScaleAuto());
		// auto4.whenPressed(new RevShooterUntilTimeoutHigh());
		// auto6.whenPressed(new DeliverFromRight());
	}
}
