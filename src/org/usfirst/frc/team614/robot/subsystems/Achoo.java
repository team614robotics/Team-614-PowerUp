package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.commands.shooter.AchooCompressorControl;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Achoo extends Subsystem {
	public Compressor compressorAchoo;
	public DoubleSolenoid pusherAchoo;
	
	public Achoo() {
		compressorAchoo = new Compressor(RobotMap.compressorAchoo);  //creates compressor
		pusherAchoo = new DoubleSolenoid(RobotMap.achooSolenoidA, RobotMap.achooSolenoidB); //creates double solenoid
		pusherAchoo.set(RobotMap.achooPistonIn);
	}
	
	public void extend() {
		pusherAchoo.set(RobotMap.achooPistonOut);
	}
	
	public void retract() {
		pusherAchoo.set(RobotMap.achooPistonIn);
	
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
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new AchooCompressorControl());
    }
}

