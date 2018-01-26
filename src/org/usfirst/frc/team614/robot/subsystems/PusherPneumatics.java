package org.usfirst.frc.team614.robot.subsystems;

import org.usfirst.frc.team614.robot.RobotMap;
import org.usfirst.frc.team614.robot.commands.shooter.PusherCompressorControl;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PusherPneumatics extends Subsystem {
	public Compressor compressorPusherPneumatics;
	public DoubleSolenoid pusherAchoo;
	
	public PusherPneumatics() {
		compressorPusherPneumatics = new Compressor(RobotMap.compressorPusherPneumatics);
		pusherAchoo = new DoubleSolenoid(RobotMap.pusherPneumaticsSolenoidA, RobotMap.pusherPneumaticsSolenoidB);
		pusherAchoo.set(RobotMap.pusherPneumaticsPistonIn);
	}
	
	public void extend() {
		pusherAchoo.set(RobotMap.pusherPneumaticsPistonOut);
	}
	
	public void retract() {
		pusherAchoo.set(RobotMap.pusherPneumaticsPistonIn);
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
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new PusherCompressorControl());
    }
}

