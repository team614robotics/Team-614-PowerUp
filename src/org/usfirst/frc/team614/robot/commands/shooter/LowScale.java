package org.usfirst.frc.team614.robot.commands.shooter;

import org.usfirst.frc.team614.robot.subsystems.IntakePneumatics;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * 
 *This is for shooting when the scale is already occupied
 *by our alliance. (Our side of the scale is lower than their side)
 *
 */
public class LowScale extends CommandGroup {

    public LowScale() {
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
    	
    	addSequential(new TogglePiston());
    	addParallel(new ShooterHigh());
    	addSequential(new WaitUntilBoxIsZwooshed());
    	addSequential(new TogglePiston());
    	
    }

	
		// TODO Auto-generated method stub
}    