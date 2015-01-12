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
	private Talon leftMotor, rightMotor;

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
		axisXleft = xbox.getRawAxis(1);
		axisYleft = xbox.getRawAxis(2);
		Trigger = xbox.getRawAxis(3);
		axisXright = xbox.getRawAxis(4);
		axisYright = xbox.getRawAxis(5);
		leftMotor.set(axisXleft - axisYleft);
		rightMotor.set(axisYleft - axisXleft);

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	

	public RobotDrive getRobit() {
		return robit;
	}

	public void setRobit(RobotDrive robit) {
		this.robit = robit;
	}

	public Joystick getXbox() {
		return xbox;
	}

	public void setXbox(Joystick xbox) {
		this.xbox = xbox;
	}

	public Command getAutonomousCommand() {
		return autonomousCommand;
	}

	public void setAutonomousCommand(Command autonomousCommand) {
		this.autonomousCommand = autonomousCommand;
	}

	public boolean isAButton() {
		return AButton;
	}

	public void setAButton(boolean aButton) {
		AButton = aButton;
	}

	public boolean isBButton() {
		return BButton;
	}

	public void setBButton(boolean bButton) {
		BButton = bButton;
	}

	public boolean isXButton() {
		return XButton;
	}

	public void setXButton(boolean xButton) {
		XButton = xButton;
	}

	public boolean isYButton() {
		return YButton;
	}

	public void setYButton(boolean yButton) {
		YButton = yButton;
	}

	public boolean isRightBumper() {
		return RightBumper;
	}

	public void setRightBumper(boolean rightBumper) {
		RightBumper = rightBumper;
	}

	public boolean isLeftBumper() {
		return LeftBumper;
	}

	public void setLeftBumper(boolean leftBumper) {
		LeftBumper = leftBumper;
	}

	public double getAxisXleft() {
		return axisXleft;
	}

	public void setAxisXleft(double axisXleft) {
		this.axisXleft = axisXleft;
	}

	public double getAxisYleft() {
		return axisYleft;
	}

	public void setAxisYleft(double axisYleft) {
		this.axisYleft = axisYleft;
	}

	public double getAxisXright() {
		return axisXright;
	}

	public void setAxisXright(double axisXright) {
		this.axisXright = axisXright;
	}

	public double getAxisYright() {
		return axisYright;
	}

	public void setAxisYright(double axisYright) {
		this.axisYright = axisYright;
	}

	public double getTrigger() {
		return Trigger;
	}

	public void setTrigger(double trigger) {
		Trigger = trigger;
	}

	public Talon getLeftMotor() {
		return leftMotor;
	}

	public void setLeftMotor(Talon leftMotor) {
		this.leftMotor = leftMotor;
	}

	public Talon getRightMotor() {
		return rightMotor;
	}

	public void setRightMotor(Talon rightMotor) {
		this.rightMotor = rightMotor;
	}
}
