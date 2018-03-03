package org.usfirst.frc.team614.robot.commands.autonomous;

import org.usfirst.frc.team614.robot.commands.drivetrain.DriveForADistance;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DrivePastBaseline extends CommandGroup {
	public DrivePastBaseline() {
		double speed = 0.7;
		addSequential(new DriveForADistance(135, speed));
	}
}
