package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.Robot;
import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class DrivetrainCompanion extends Subsystem implements PIDOutput {
	PIDController distanceController;

    private double PIDdistanceSpeed;
    
    private boolean usingDistancePID;
    
    /* The following PID Controller coefficients will need to be tuned */
    /* to match the dynamics of your drive system.  Note that the      */
    /* SmartDashboard in Test mode has support for helping you tune    */
    /* controllers by displaying a form where you can enter new P, I,  */
    /* and D constants and test the mechanism.                         */
    

    static final double distanceTolerance = 0.1f;
	
	// VictorSP motor controllers
//	VictorSP leftMotor = new VictorSP(RobotMap.drivetrainLeftMotor);
//	VictorSP rightMotor = new VictorSP(RobotMap.drivetrainRightMotor);

	
	public DrivetrainCompanion() {
		
		usingDistancePID = false;

		distanceController = new PIDController(
				RobotMap.drivetrainDistanceP,
				RobotMap.drivetrainDistanceI,
				RobotMap.drivetrainDistanceD,
				RobotMap.drivetrainDistanceF,
				Robot.drivetrain.rightEncoder, this
		);
        distanceController.setOutputRange(-1.0, 1.0);
        distanceController.setAbsoluteTolerance(distanceTolerance);

        /* Add the PID Controller to the Test-mode dashboard, allowing manual  */
        /* tuning of the Turn Controller's P, I and D coefficients.            */
        /* Typically, only the P value needs to be modified.                   */
        LiveWindow.addActuator("DriveSystem", "DistanceController", distanceController);
        
	}
	
	public void setUsingDistancePID(boolean set) {
		usingDistancePID = true;
		if(set == true) {
			distanceController.enable();
		} else {
			distanceController.disable();
		}
	}
	public boolean getUsingDistancePID() {
		return usingDistancePID;
	}
	public double getPIDSpeed() {
		return PIDdistanceSpeed;
	}
	public PIDController getDistanceController() {
		return distanceController;
	}

	public void pidWrite(double output) {
		if(usingDistancePID) {
			PIDdistanceSpeed = output;
		}
	}

    public void initDefaultCommand() {}
}


