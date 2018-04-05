package org.usfirst.frc.team614.robot.commands.autonomous;

import org.usfirst.frc.team614.robot.commands.drivetrain.DriveForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;
import org.usfirst.frc.team614.robot.commands.intake.RevIntakeTimed;
import org.usfirst.frc.team614.robot.commands.intake.ToggleLoaderPiston;
import org.usfirst.frc.team614.robot.commands.shooter.DeliverScaleAuto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightScaleTwoCube extends CommandGroup {

    public RightScaleTwoCube() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	double speed = 0.7;
    	
		addSequential(new DriveForADistance(300, speed));
		addParallel(new RotateToAngle(90, false));
		addSequential(new DeliverScaleAuto());
		
		// Two Cube
		addSequential(new ToggleLoaderPiston());
		addSequential(new RotateToAngle(-260, false));
		addParallel(new DriveForADistance(120, speed));
		addSequential(new RevIntakeTimed());
    }
}
