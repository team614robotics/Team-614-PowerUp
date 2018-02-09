package org.usfirst.frc.team614.robot.commands.autonomous;

import org.usfirst.frc.team614.robot.commands.drivetrain.DriveForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveUntilCollisionDetected;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveUntilHitCube;
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
    		addSequential(new DeliverSwitch());
    		if(SmartDashboard.getBoolean("L2", false) && SmartDashboard.getBoolean("Go For Scale", true)) {
    			   addSequential(new RotateToAngle(135, false));
		           addSequential(new ToggleIntakePiston());
		           addSequential(new DriveUntilHitCube(speed));
		           addSequential(new ToggleIntakePiston());
		           addSequential(new IntakePowerCube());
		           addSequential(new DriveUntilCollisionDetected(-speed));
		           addSequential(new RotateToAngle(-90, false));
		           addSequential(new DriveForADistance(184, speed));
		           addSequential(new RotateToAngle(-90, false));
		           addSequential(new DeliverHighScale());
    		}
    		else if(SmartDashboard.getBoolean("R2", false) && SmartDashboard.getBoolean("Go For Scale", true)) {
    			   addSequential(new RotateToAngle(135, false));
		           addSequential(new ToggleIntakePiston());
		           addSequential(new DriveUntilHitCube(speed));
		           addSequential(new ToggleIntakePiston());
		           addSequential(new IntakePowerCube());
		           addSequential(new DriveUntilCollisionDetected(-speed));
		           addSequential(new RotateToAngle(-90, false));
		           addSequential(new DriveForADistance(121, speed));
		           addSequential(new RotateToAngle(90, false));
		           addSequential(new DriveUntilCollisionDetected(speed));
		           addSequential(new RotateToAngle(-90, false));
		           addSequential(new DriveForADistance(63, speed));
		           addSequential(new RotateToAngle(90, false));
		           addSequential(new DeliverHighScale());
    		}
    		else{
    			addSequential(new DoNothing());
    			// Backup 1
    		}
    	}
    	
    	else if (SmartDashboard.getBoolean("R1", false))
    	{
    		addSequential(new RotateToAngle(45, false));
    		addSequential(new DriveForADistance(distance, speed));
    		addSequential(new DeliverSwitch());
    		if(SmartDashboard.getBoolean("R2", false) && SmartDashboard.getBoolean("Go For Scale", true)) {
    			   addSequential(new RotateToAngle(-135, false));
		           addSequential(new ToggleIntakePiston());
		           addSequential(new DriveUntilHitCube(speed));
		           addSequential(new ToggleIntakePiston());
		           addSequential(new IntakePowerCube());
		           addSequential(new DriveUntilCollisionDetected(-speed));
		           addSequential(new RotateToAngle(90, false));
		           addSequential(new DriveForADistance(184, speed));
		           addSequential(new RotateToAngle(90, false));
		           addSequential(new DeliverHighScale());
		           
    		}
    		else if(SmartDashboard.getBoolean("L2", false) && SmartDashboard.getBoolean("Go For Scale", true)) {
    			   addSequential(new RotateToAngle(-135, false));
		           addSequential(new ToggleIntakePiston());
		           addSequential(new DriveUntilHitCube(speed));
		           addSequential(new ToggleIntakePiston());
		           addSequential(new IntakePowerCube());
		           addSequential(new DriveUntilCollisionDetected(-speed));
		           addSequential(new RotateToAngle(90, false));
		           addSequential(new DriveForADistance(121, speed));
		           addSequential(new RotateToAngle(-90, false));
		           addSequential(new DriveUntilCollisionDetected(speed));
		           addSequential(new RotateToAngle(90, false));
		           addSequential(new DriveForADistance(63, speed));
		           addSequential(new RotateToAngle(-90, false));
		           addSequential(new DeliverHighScale());
    		}
    		else{
    			addSequential(new DoNothing());
    			// Backup 1
    		}
    	}
    	
    	else
    	{
    		addSequential(new DrivePastBaseline());
    		//Backup 3
    	}
    }
}
