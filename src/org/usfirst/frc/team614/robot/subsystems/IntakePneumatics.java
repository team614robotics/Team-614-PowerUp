package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.commands.shooter.AchooCompressorControl;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakePneumatics extends Subsystem {
	public Compressor compressorAchoo;
	public DoubleSolenoid pusherAchoo;

	public IntakePneumatics() {
		compressorAchoo = new Compressor(RobotMap.compressor);
		pusherAchoo = new DoubleSolenoid(RobotMap.SolenoidA, RobotMap.SolenoidB);
		pusherAchoo.set(RobotMap.PistonIn);
	}

	public void extend() {
		pusherAchoo.set(RobotMap.PistonOut);
	}

	public void retract() {
		pusherAchoo.set(RobotMap.PistonIn);
	}

	public DoubleSolenoid.Value getState() {
		return pusherAchoo.get();
	}

	public void setState(DoubleSolenoid.Value state) {
		pusherAchoo.set(state);
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new AchooCompressorControl());
	}
}
