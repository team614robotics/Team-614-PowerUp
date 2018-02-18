package org.usfirst.frc.team614.robot.commands.autonomous;

import org.usfirst.frc.team614.robot.commands.drivetrain.DriveForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DrivePastBaseline extends CommandGroup {
    public DrivePastBaseline() {
    	addSequential(new DriveForADistance(100, 0.5));
    	addSequential(new RotateToAngle(90, false));
    }
}
