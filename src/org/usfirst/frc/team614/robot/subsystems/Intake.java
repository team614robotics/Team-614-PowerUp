package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.commands.intake.CompressorControl;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public VictorSP intakeLeft = new VictorSP(RobotMap.intakeLeft);
	public VictorSP intakeRight = new VictorSP(RobotMap.intakeRight);

	public Compressor compressor;
	public DoubleSolenoid pusher;
	
	public Intake()
	{
		compressor = new Compressor(RobotMap.compressor);
		pusher = new DoubleSolenoid(RobotMap.SolenoidA, RobotMap.SolenoidB);
		pusher.set(RobotMap.PistonIn);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		intakeLeft.set(0);
		intakeRight.set(0);
		
		setDefaultCommand(new CompressorControl());
	}
	
	public void set(double speed)
	{
		intakeLeft.set(speed);
		intakeRight.set(-speed);
	}

	public void extend() {
		pusher.set(RobotMap.PistonOut);
	}

	public void retract() {
		pusher.set(RobotMap.PistonIn);
	}

	public DoubleSolenoid.Value getState() {
		return pusher.get();
	}

	public void setState(DoubleSolenoid.Value state) {
		pusher.set(state);
	}
}
