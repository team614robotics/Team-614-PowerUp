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
public class DeliverFromLeftScale extends CommandGroup {

	public DeliverFromLeftScale() {
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.

		double speed = 0.7;

		if (SmartDashboard.getBoolean("L2", false)) {
			addSequential(new DriveForADistance(300, speed));
			addParallel(new RotateToAngle(-90, false));
			addParallel(new DeliverScaleAuto());
			addSequential(new DoNothing(3));
			addSequential(new RotateToAngle(240, false));
			addParallel(new DriveForADistance(100, 0.5));
//			addParallel(new IntakePowerCube());
//			addSequential(new DriveForADistance(128, -0.5));
//			addParallel(new RotateToAngle(-128, false));
//			addParallel(new DeliverScaleAuto());
		} else if (SmartDashboard.getBoolean("R2", false)) {
			addSequential(new DriveForADistance(261.47, speed));
			addSequential(new RotateToAngle(90, false));
			addSequential(new DriveForADistance(294, speed));
			addSequential(new RotateToAngle(-90, false));
			addSequential(new DriveForADistance(108, speed));
			addParallel(new RotateToAngle(90, false));
			addParallel(new DeliverScaleAuto());
		} else if (SmartDashboard.getBoolean("L1", false)) {
			addSequential(new DriveForADistance(168, speed));
			addSequential(new RotateToAngle(-90, false));
			addSequential(new DeliverSwitchAuto());
		} else {
			addSequential(new DrivePastBaseline());
		}
	}
}
