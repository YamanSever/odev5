package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeAngle;

public class IntakeAngleCommand extends Command {
  IntakeAngle m_intakeangle;
  public double m_Position;

  public IntakeAngleCommand(IntakeAngle intakeAngle, double Position) {
    this.m_intakeangle = intakeAngle;
    this.m_Position = Position;
    addRequirements(intakeAngle);
  }

  @Override
  public void initialize() {}


  @Override
  public void execute() {
    m_intakeangle.setMotorPosition(m_Position);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
