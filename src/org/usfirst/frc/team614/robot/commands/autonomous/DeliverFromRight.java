package org.usfirst.frc.team614.robot.commands.autonomous;

import org.usfirst.frc.team614.robot.commands.SpinTalonMotors;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveUntilStopped;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DeliverFromRight extends CommandGroup {

    public DeliverFromRight() {
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
    	
    	if (SmartDashboard.getBoolean("R1", false))
    	{
    		if (SmartDashboard.getBoolean("R2", false)
    				&& SmartDashboard.getBoolean("Go For Scale", false))
    		{
    			this.addSequential(new DriveForADistance(168, speed));
    			this.addSequential(new RotateToAngle(-90, true));
    		}
    		
    		else
    		{
    			this.addSequential(new DriveUntilStopped(speed, 3));
    		}
    	
			this.addSequential(new SpinTalonMotors());
    	}
    	
    	else if (SmartDashboard.getBoolean("L1", false))
    	{
    		this.addSequential(new DriveForADistance(80, speed));
    	}
    	
    	else
    	{
    		this.addSequential(new DoNothing());
    	}
    }
}
