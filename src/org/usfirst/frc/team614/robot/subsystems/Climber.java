import org.usfirst.frc.team614.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public VictorSP winch = new VictorSP(RobotMap.winch);
	public Servo servo = new Servo(RobotMap.servo);

	public Climber() {
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		winch.set(0);
		servo.set(0);
	}
}