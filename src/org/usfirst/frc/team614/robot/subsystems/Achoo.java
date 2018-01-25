package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.commands.CompressorControl;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Achoo extends Subsystem {
	public Compressor compressor;
	public DoubleSolenoid squeezer;

	public Achoo() {
		compressor = new Compressor(0);
        squeezer = new DoubleSolenoid(2, 3);
		squeezer.set(RobotMap.AchoopistonIn);
	}

	public void extend() {
		squeezer.set(RobotMap.AchoopistonOut);
	}

	public void retract() {
		squeezer.set(RobotMap.AchoopistonIn);
	}

	public DoubleSolenoid.Value getState() {
		return squeezer.get();
	}

	public void setState(DoubleSolenoid.Value state) {
		squeezer.set(state);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new CompressorControl());
	}
}
