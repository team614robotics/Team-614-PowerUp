package org.usfirst.frc.team614.robot.commands.autonomous;

import org.usfirst.frc.team614.robot.commands.drivetrain.DriveForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveUntilCollisionDetected;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveUntilHitCube;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveUntilStopped;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;
import org.usfirst.frc.team614.robot.commands.intake.ToggleIntakePiston;
import org.usfirst.frc.team614.robot.commands.shooter.DeliverSwitch;
import org.usfirst.frc.team614.robot.commands.shooter.RevShooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DeliverFromCenter extends CommandGroup {

    public DeliverFromCenter() {
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
    	
    	double speed = 0.8;
    	double distance = Math.sqrt(2) * (11.5 / 5);
    	
    	if (SmartDashboard.getBoolean("L1", false))
    	{
    		addSequential(new RotateToAngle(-45, false));
    		addSequential(new DriveForADistance(distance, speed));
    		addSequential(new DriveForADistance(5, -speed));
    		addSequential(new RotateToAngle(-135, false));
    		addSequential(new DriveForADistance(3.53553390593, -speed));
    		addSequential(new DeliverSwitch());
    	}
    	
    	else if (SmartDashboard.getBoolean("R1", false))
    	{
    		addSequential(new RotateToAngle(45, false));
    		addSequential(new DriveForADistance(distance, speed));
    		addSequential(new DriveForADistance(5, -speed));
    		addSequential(new RotateToAngle(135, false));
    		addSequential(new DriveForADistance(3.53553390593, -speed));
    		addSequential(new DeliverSwitch());
    	}
    	
    	else
    	{
    		addSequential(new DrivePastBaseline());
    		//Backup 3
    	}
    }
}
