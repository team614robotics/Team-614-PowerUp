//package org.usfirst.frc.team614.robot.subsystems;
//
//import org.usfirst.frc.team614.robot.RobotMap;
//import org.usfirst.frc.team614.robot.commands.CompressorControl;
//
//import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.command.Subsystem;
//
///**
// *
// */
//public class Clamp extends Subsystem {
//	public Compressor compressor;
//	public DoubleSolenoid squeezer;
//
//	public Clamp() {
//		compressor = new Compressor(0);
//
//		squeezer = new DoubleSolenoid(1, 2);
//		squeezer.set(RobotMap.pistonIn);
//	}
//
//	public void extend() {
//		squeezer.set(RobotMap.pistonOut);
//	}
//
//	public void retract() {
//		squeezer.set(RobotMap.pistonIn);
//	}
//
//	public DoubleSolenoid.Value getState() {
//		return squeezer.get();
//	}
//
//	public void setState(DoubleSolenoid.Value state) {
//		squeezer.set(state);
//	}
//
//	public void initDefaultCommand() {
//		// Set the default command for a subsystem here.
//		setDefaultCommand(new CompressorControl());
//	}
//}
