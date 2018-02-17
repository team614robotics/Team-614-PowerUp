package org.usfirst.frc.team614.robot.commands.autonomous;

import org.usfirst.frc.team614.robot.commands.drivetrain.DriveForADistance;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveUntilCollisionDetected;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveUntilHitCube;
import org.usfirst.frc.team614.robot.commands.drivetrain.DriveUntilStopped;
import org.usfirst.frc.team614.robot.commands.drivetrain.RotateToAngle;
import org.usfirst.frc.team614.robot.commands.intake.ToggleIntakePiston; 
import org.usfirst.frc.team614.robot.commands.shooter.DeliverSwitchAuto;
import org.usfirst.frc.team614.robot.commands.shooter.RevShooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DeliverFromRightScale extends CommandGroup {

    public DeliverFromRightScale() {
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
    	
    	if (SmartDashboard.getBoolean("R2", false) && SmartDashboard.getBoolean("Go For Scale", false)) {
    		addSequential(new DriveForADistance(324, speed));
			addSequential(new RotateToAngle(90, false));
			addSequential(new DriveUntilCollisionDetected(speed));
			addSequential(new DeliverSwitchAuto());
			
			//Mode 2
			
			/*^       (----------------)         *
			 *-|      (-----Scale------)         *
			 * |                                 * 
			 * |      [-----Switch-----}         *
			 * |      [----------------]         *
			 * ()                                *
			 * ----------------------------------*
			 * | Move
			 * - Rotate
			 * = Move
			 * ^ Shoot
			 *() Robot
			 * 
			 * Drives to mid-field then hit the wall and shoot
			 */
			
		}   	
    	else if (SmartDashboard.getBoolean("R1", false))
    	{
    		addSequential(new DriveForADistance(168, speed));
			addSequential(new RotateToAngle(90, false));
			addSequential(new DriveUntilCollisionDetected(speed));
			addSequential(new DeliverSwitchAuto());
			
            //Mode 1
			
			/*        (----------------)         *
			 *        (-----Scale------)         *
			 *^                                  * 
			 *-|      [-----Switch-----}         *
			 * |      [----------------]         *
			 * ()                                *
			 * ----------------------------------*
			 * | Move
			 * - Rotate
			 * = Move
			 * ^ Shoot
			 *() Robot
			 * 
			 * Drives to mid-switch then hit the wall and shoot
			 */
    	}
    	
    	else if (SmartDashboard.getBoolean("L2", false) && SmartDashboard.getBoolean("Go For Scale", false) && SmartDashboard.getBoolean("Go For Opposite Side", false)) {
    		addSequential(new DriveForADistance(261.47, speed));
			addSequential(new RotateToAngle(-90, false));
			addSequential(new DriveUntilCollisionDetected(speed));
			addSequential(new RotateToAngle(90, false));
			addSequential(new DriveForADistance(65.47, speed));
			addSequential(new DeliverSwitchAuto());
			
			//Mode 2
			                                    
			/*                                  ^
			 *        (-----Scale------)        |*
			 * |-================================* 
			 * |      [-----Switch-----}         *
			 * |      [----------------]         *
			 * ()                                *
			 * ----------------------------------*
			 * 
			 * | Move
			 * - Rotate
			 * = Move
			 * ^ Shoot
			 * () Robot
			 */
			
		}
    	else{
    		addSequential(new DrivePastBaseline());
    	}
    }
}
