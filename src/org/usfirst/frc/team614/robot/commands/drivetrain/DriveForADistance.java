
package org.usfirst.frc.team614.robot.commands.drivetrain;


import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Makes the drivetrain drive straight for a distance in inches
 */
public class DriveForADistance extends Command
{
	private double distance, speed;

	public DriveForADistance(double distance, double speed)
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drivetrain);
		this.distance = distance; // in units of inches (ideally)
		this.speed = speed;
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		Robot.drivetrain.leftEncoder.reset();
		//Robot.drivetrain.rightEncoder.reset();
//        Robot.drivetrain.getDistanceController().setSetpoint(SmartDashboard.getNumber("Drivetrain Target Distance", 0));
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{

		Robot.drivetrain.arcadeDrive(speed, 0);

//		}
		
		
	}

	// Returns true once the distance travelled by the encoder is greater than
	// distance.
	// Unit conversions are done in Constants.
	// The size of the wheel MUST be changed in Constants if changed!
	protected boolean isFinished()
	{

    	// Robot isn't at the immediate start of command and may be stopped b/c it never even started
//    	if(this.timeSinceInitialized() > .2) {
	    	// PID stuff is done
//	    	if(!Robot.navX.isMoving()) {
//	    		return true;
//	    	}


//    		if(Robot.drivetrain.rightEncoder.getRate() < 2.5 && Robot.drivetrain.rightEncoder.getRate() > -2.5) {
//				return true;
//			}
//    	}	
//		return false; 
//		 only tests right side... we're driving straight, so who cares.
<<<<<<< HEAD
		if (SmartDashboard.getNumber("Drivetrain Left Encoder Distance", 0) > distance * 1.18) {
=======
		if (SmartDashboard.getNumber("Drivetrain left Encoder Distance (inches)", 0) > distance * 1.18) {
>>>>>>> 0f511ea3dfcb62091a046c8d5c1ae4b1aa030acf
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		Robot.drivetrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		Robot.drivetrain.stop();
	}
}
