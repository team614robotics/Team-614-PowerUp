package org.usfirst.frc.team614.robot.commands.autonomous;

import org.usfirst.frc.team614.robot.commands.drivetrain.DriveForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveUntilStopped;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;
import org.usfirst.frc.team614.robot.commands.intake.ToggleIntakePiston;
import org.usfirst.frc.team614.robot.commands.shooter.DeliverHighScale;
import org.usfirst.frc.team614.robot.commands.shooter.DeliverSwitch;
import org.usfirst.frc.team614.robot.commands.shooter.RevShooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DeliverFromLeft extends CommandGroup {

    public DeliverFromLeft() {
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
    	
    	if (SmartDashboard.getBoolean("L1", false))
    	{
    		this.addSequential(new DriveForADistance(168, speed));
			this.addSequential(new RotateToAngle(90, true));
			this.addSequential(new DeliverSwitch());
    		
    		if (SmartDashboard.getBoolean("L2", false)
    				&& SmartDashboard.getBoolean("Go For Scale", false))
    		{
    			this.addSequential(new RotateToAngle(-90, false));
    			this.addSequential(new DriveForADistance(24, speed));
    			this.addSequential(new RotateToAngle(90, false));
    			this.addSequential(new DriveForADistance(72, speed));
    			this.addSequential(new IntakePowerCube());
    			this.addSequential(new RotateToAngle(180, false));
    			this.addSequential(new DriveForADistance(72, speed));
    			this.addSequential(new RotateToAngle(90, false));
    			this.addSequential(new DriveForADistance(120, speed));
    			this.addSequential(new RotateToAngle(90, false));
    			this.addSequential(new DeliverHighScale());
    			// Mode 6
    		}
   		  else if (SmartDashboard.getBoolean("R2", false)
    				&& SmartDashboard.getBoolean("Go For Scale", false)) {
   			addSequential(new RotateToAngle(90, false));
			addSequential(new DriveForADistance(24, speed));
			addSequential(new RotateToAngle(90, false));
			//addSequential(new DriveUntilHitCube()); <-- Class isn't added yet; if cubes aren't being exactly place it will kill us
			addSequential(new IntakePowerCube());
			addSequential(new RotateToAngle(-180, false));
			addSequential(new DriveForADistance(72, speed));
			addSequential(new RotateToAngle(-90, false));
			addSequential(new DriveForADistance(59.5, speed));
			addSequential(new RotateToAngle(-90, false));
			addSequential(new DriveUntilStopped(speed, 2));
			addSequential(new RotateToAngle(-90, false));
			addSequential(new DriveForADistance(59, speed));
			addSequential(new RotateToAngle(-90, false));
			addSequential(new DeliverHighScale());
 			
    		}
    		else {
    			addSequential(new DoNothing());
    			//Backup 3
    		}
    	}
    	
    	else if (SmartDashboard.getBoolean("R1", false))
    	{
    		this.addSequential(new DriveForADistance(80, speed));
    		// One of the modes is to get to R1 so this is subject to change
    		// Should add Mode 8 and Mode 9
    		
    	}
    	
    	else
    	{
    		this.addSequential(new DrivePastBaseline());
    		// Again subject to change
    	}
    }
}
