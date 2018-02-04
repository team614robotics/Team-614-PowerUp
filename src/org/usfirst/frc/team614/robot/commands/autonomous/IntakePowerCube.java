package org.usfirst.frc.team614.robot.commands.autonomous;

import org.usfirst.frc.team614.robot.commands.intake.RevIntake;
import org.usfirst.frc.team614.robot.commands.intake.ToggleIntakePistonWithDelay;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakePowerCube extends CommandGroup {
	
	public IntakePowerCube()
	{
		addParallel(new RevIntake());
		addParallel(new ToggleIntakePistonWithDelay());
	}
}
