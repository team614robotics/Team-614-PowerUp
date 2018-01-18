package org.usfirst.frc.team614.robot.subsystems;


import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.commands.drivetrain.TankDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Drivetrain extends Subsystem {
	
	public RobotDrive drivetrain;
	public Encoder leftEncoder;
	public Encoder rightEncoder;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public VictorSP leftMotorA = new VictorSP(RobotMap.leftMotorA);
	public VictorSP leftMotorB = new VictorSP(RobotMap.leftMotorB);
	public VictorSP rightMotorA = new VictorSP(RobotMap.rightMotorA);
	public VictorSP rightMotorB = new VictorSP(RobotMap.rightMotorB);
	
	public Drivetrain()
	{
		drivetrain = new RobotDrive(leftMotorA, leftMotorB, rightMotorA, rightMotorB);
		leftEncoder = new Encoder(RobotMap.leftMotorEncoderA, RobotMap.leftMotorEncoderB, false, Encoder.EncodingType.k4X);
		rightEncoder = new Encoder(RobotMap.rightMotorEncoderA, RobotMap.rightMotorEncoderB, false, Encoder.EncodingType.k4X);
	
		leftEncoder.setDistancePerPulse(RobotMap.DRIVETRAIN_DISTANCE_PER_PULSE);
		rightEncoder.setDistancePerPulse(RobotMap.DRIVETRAIN_DISTANCE_PER_PULSE);
		
		
        
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	 setDefaultCommand(new TankDrive());
    }
 
    public void arcadeDrive(double moveValue, double rotateValue) {
		// TODO Auto-generated method stub
		drivetrain.arcadeDrive(moveValue, -rotateValue);
		
	}
    
    public void stop(){
    	
    	drivetrain.arcadeDrive(0, 0);
    }
public void setDistancePerPulse(double dpp)
{
	leftEncoder.setDistancePerPulse(dpp);
	rightEncoder.setDistancePerPulse(dpp);
}
public void reset(){
	leftEncoder.reset();
	rightEncoder.reset();
}
	
		// TODO Auto-generated method stub
		
	
}

