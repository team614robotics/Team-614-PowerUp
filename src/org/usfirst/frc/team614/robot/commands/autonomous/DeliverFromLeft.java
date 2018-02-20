package org.usfirst.frc.team614.robot.commands.autonomous;

import org.usfirst.frc.team614.robot.commands.drivetrain.DriveForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveUntilCollisionDetected;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;
import org.usfirst.frc.team614.robot.commands.shooter.DeliverScaleAuto;
import org.usfirst.frc.team614.robot.commands.shooter.DeliverSwitchAuto;

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
    	
    	if(SmartDashboard.getBoolean("L2", false) && SmartDashboard.getBoolean("Go For Scale", false)) 
    	{
    		    addSequential(new DriveForADistance(250, 1)); //Proportional Value
    	        addParallel(new RotateToAngle(-90, false));
		        addParallel(new DeliverScaleAuto());
		        // Code we tested today exactly
		        
		        //This worked fine so for now not going to add a value
    	}
    	else if(SmartDashboard.getBoolean("R2", false) && SmartDashboard.getBoolean("Go For Scale", false)) {
    		// Actual Values in Order   
    		// addSequential(new DriveForADistance(261.47, speed)); 
    		// addSequential(new DriveForADistance(63.53, speed));
    		
    		    addSequential(new DriveForADistance(201.75, speed)); // Proportional Value   
			    addSequential(new RotateToAngle(-90, false));
			    addSequential(new DriveForADistance(290, speed)); // Distances is probably messed up so no proportional value
			    addSequential(new RotateToAngle(90, false));
			    addSequential(new DriveForADistance(48.25, speed)); // Proportional Value
			    addParallel(new RotateToAngle(-90, false));
			    addParallel(new DeliverScaleAuto());
			    
    	}	
    	else if(SmartDashboard.getBoolean("L1", false)){
    		// Actual Values
    		// addSequential(new DriveForADistance(157, speed)); 
    		
    		    addSequential(new DriveForADistance(129.62, speed)); //Proportional Value
    		    addSequential(new RotateToAngle(-90, false));
    		    addSequential(new DriveUntilCollisionDetected(-speed));
    		    addSequential(new DeliverSwitchAuto());
    		    // This is to test if collision detection works compared to the unreliable DriveForADistance
    		    // again main priority is the scale
    		    
    		    // This is sequential because DriveUntilCollisionDetected might not work, once we know it 
    		    // works we will put it in parallel
    	}
    	else {
    		addSequential(new DrivePastBaseline());
    		// This shouldn't ever happen, last case scenario (we don't read FMS values)
    	}
    }
}
