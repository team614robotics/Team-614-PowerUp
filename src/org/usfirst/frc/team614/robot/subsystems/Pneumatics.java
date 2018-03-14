package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;

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
	public DoubleSolenoid loaderTopPiston;
	public DoubleSolenoid loaderBottomPiston;
	public DoubleSolenoid intakePiston;
	public Solenoid intakeRingLight;

	public Pneumatics() {
		compressor = new Compressor(RobotMap.compressor);
		intakePiston = new DoubleSolenoid(RobotMap.intakeSolenoidA, RobotMap.intakeSolenoidB);
		intakePiston.set(RobotMap.PistonIn);
		loaderTopPiston = new DoubleSolenoid(RobotMap.loaderSolenoidA, RobotMap.loaderSolenoidB);
		loaderTopPiston.set(RobotMap.PistonIn);
		loaderBottomPiston = new DoubleSolenoid(RobotMap.loaderSolenoidC, RobotMap.loaderSolenoidD);
		loaderBottomPiston.set(RobotMap.PistonIn);
		intakeRingLight = new Solenoid(RobotMap.ringLightSolenoid);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new CompressorControl());
	}

	public void setLoaderFullIn() {
		loaderTopPiston.set(RobotMap.PistonIn);
		loaderBottomPiston.set(RobotMap.PistonIn);
	}

	public void setLoaderHalfIn() {
		loaderTopPiston.set(RobotMap.PistonIn);
		loaderBottomPiston.set(RobotMap.PistonOut);
	}

	public void setLoaderOut() {
		loaderTopPiston.set(RobotMap.PistonOut);
		loaderBottomPiston.set(RobotMap.PistonOut);
	}

	public boolean isLoaderFullIn() {
		return loaderTopPiston.get().equals(RobotMap.PistonIn) && loaderBottomPiston.get().equals(RobotMap.PistonIn);
	}

	public boolean isLoaderHalfIn() {
		return loaderTopPiston.get().equals(RobotMap.PistonIn) && loaderBottomPiston.get().equals(RobotMap.PistonOut);
	}

	public DoubleSolenoid.Value getIntakeState() {
		return intakePiston.get();
	}

	public void setIntakeState(DoubleSolenoid.Value state) {
		intakePiston.set(state);
	}
}
