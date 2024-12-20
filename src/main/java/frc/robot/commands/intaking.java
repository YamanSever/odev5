package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Feeder;

public class intaking extends Command {
  double m_intake_speed; 
  Intake m_intake_motor;

  double m_feeder_speed;
  Feeder m_feeder_motor;

  public intaking(Intake intake_motor, double intake_speed, Feeder feeder_motor, double feeder_speed) {
    this.m_intake_speed = intake_speed;
    this.m_intake_motor = intake_motor;

    this.m_feeder_speed = feeder_speed;
    this.m_feeder_motor = feeder_motor;
    addRequirements(m_intake_motor, m_feeder_motor);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    if (!m_intake_motor.getStatus()) {
      m_intake_motor.run(m_intake_speed); m_feeder_motor.run(m_feeder_speed);
    } else {
      m_intake_motor.run(0);
    }
    if (!m_feeder_motor.getStatus()) {
      m_feeder_motor.run(m_feeder_speed); m_intake_motor.run(m_intake_speed);
    } else {
      m_feeder_motor.run(0);
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_intake_motor.run(0); 
    m_feeder_motor.run(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}