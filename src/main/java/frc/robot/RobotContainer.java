package frc.robot;

import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IntakeAngle;
import frc.robot.commands.IntakeAngleCommand;
import frc.robot.commands.intaking;

public class RobotContainer {
  PS5Controller ps5 = new PS5Controller(0);
  Feeder feederKraken = new Feeder();
  Intake intakeKraken = new Intake();
  IntakeAngle intakeAngle = new IntakeAngle();

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    new JoystickButton(ps5, 1).whileTrue(new intaking(intakeKraken, 1, feederKraken, 0.7));
    new JoystickButton(ps5, 2).whileTrue(new intaking(intakeKraken, -1, feederKraken, -0.7));
    new JoystickButton(ps5, 3).onTrue(new IntakeAngleCommand(intakeAngle, 25));
    new JoystickButton(ps5, 4).onTrue(new IntakeAngleCommand(intakeAngle, 0));
  }
  public Command getAutonomousCommand() {
    return null;  
  }
}
