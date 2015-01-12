package org.usfirst.frc.team5071.robot;

import org.usfirst.frc.team5071.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	private RobotDrive robit;
	private Joystick xbox;
	public Command autonomousCommand;
	private boolean AButton, BButton, XButton, YButton, RightBumper,
			LeftBumper;
	private double axisXleft, axisYleft, axisXright, axisYright, Trigger;
	public Talon leftMotor, rightMotor;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		xbox = new Joystick(0);
		autonomousCommand = new Autonomous();
		leftMotor = new Talon(0);
		rightMotor = new Talon(1);
		leftMotor.enableDeadbandElimination(true);

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		AButton = xbox.getRawButton(1);
		BButton = xbox.getRawButton(2);
		XButton = xbox.getRawButton(3);
		YButton = xbox.getRawButton(4);
		while (true) {
			axisXleft = xbox.getRawAxis(1);
			axisYleft = xbox.getRawAxis(2);
			Trigger = xbox.getRawAxis(3);
			axisXright = xbox.getRawAxis(4);
			axisYright = xbox.getRawAxis(5);
			leftMotor.set(axisXleft - axisYleft);
			rightMotor.set(axisYleft - axisXleft);
		}
		/*
		 * if (button == true) { talon.set(.5); } else if (button == false) {
		 * talon.set(0); }
		 */
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
