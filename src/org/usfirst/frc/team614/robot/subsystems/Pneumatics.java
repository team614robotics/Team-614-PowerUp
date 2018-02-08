package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.commands.intake.ToggleIntakeLight;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public Compressor compressor;
	public DoubleSolenoid loaderPiston;
	public DoubleSolenoid intakePistonA;
	public DoubleSolenoid intakePistonB;
	public Solenoid intakeRingLight;
	

	public Pneumatics()
	{
		compressor = new Compressor(RobotMap.compressor);
		intakePistonA = new DoubleSolenoid(RobotMap.intakeSolenoidA, RobotMap.intakeSolenoidB);
		intakePistonA.set(RobotMap.PistonOut);
		intakePistonB = new DoubleSolenoid(RobotMap.intakeSolenoidC, RobotMap.intakeSolenoidD);
		intakePistonB.set(RobotMap.PistonOut);
		loaderPiston = new DoubleSolenoid(RobotMap.loaderSolenoidA, RobotMap.loaderSolenoidB);
		loaderPiston.set(RobotMap.PistonIn);
		intakeRingLight = new Solenoid(RobotMap.ringLightSolenoid);
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new CompressorControl());
		
    }
    
   public void extendLoader(){
    	loaderPiston.set(RobotMap.PistonOut);
    }
    
    public void retractLoader(){
    	loaderPiston.set(RobotMap.PistonIn);
    }
    
    public DoubleSolenoid.Value getLoaderState(){
    	return loaderPiston.get();
    }
    
    public void setLoaderState(DoubleSolenoid.Value state){
    	loaderPiston.set(state);
    }
	
    public void extendIntake() {
		intakePistonA.set(RobotMap.PistonOut);
		intakePistonB.set(RobotMap.PistonOut);
	}

	public void retractIntake() {
		intakePistonA.set(RobotMap.PistonIn);
		intakePistonB.set(RobotMap.PistonIn);
	}

	public DoubleSolenoid.Value getIntakeState() {
		return intakePistonA.get();
	}

	public void setIntakeState(DoubleSolenoid.Value state) {
		intakePistonA.set(state);
		intakePistonB.set(state);
	}
}

