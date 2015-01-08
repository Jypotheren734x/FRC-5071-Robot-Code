package org.usfirst.frc.team5071.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick Joy = new Joystick(1);
	JoystickButton button = new JoystickButton(Joy, 12);

	public OI() {
		button.whenPressed(new Command());
	}
}