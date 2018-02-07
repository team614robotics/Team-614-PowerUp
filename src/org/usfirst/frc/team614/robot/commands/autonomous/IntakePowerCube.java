package org.usfirst.frc.team614.robot.commands.autonomous;

import org.usfirst.frc.team614.robot.commands.intake.RevIntakeTimed;
import org.usfirst.frc.team614.robot.commands.intake.ToggleIntakePistonWithDelay;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakePowerCube extends CommandGroup {
	
	public IntakePowerCube()
	{
		addParallel(new RevIntakeTimed());
		addParallel(new ToggleIntakePistonWithDelay());
	}
}
