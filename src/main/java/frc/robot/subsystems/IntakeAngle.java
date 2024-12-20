package frc.robot.subsystems;

import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeAngle extends SubsystemBase {

  TalonFX intakeAngleMotor = new TalonFX(3);  
  Slot0Configs slot0Configs = new Slot0Configs();
  final MotionMagicVoltage m_motmag = new MotionMagicVoltage(0);

  MotionMagicConfigs motionMagicConfigs = new MotionMagicConfigs();
  TalonFXConfiguration talonFXConfigs = new TalonFXConfiguration();

  public IntakeAngle() {

  Slot0Configs slot0Configs = new Slot0Configs();
  slot0Configs.kS = 0.24; 
  slot0Configs.kV = 0.12; 

  slot0Configs.kP = 4.8;
  slot0Configs.kI = 0;
  slot0Configs.kD = 0.1;

  motionMagicConfigs.MotionMagicAcceleration = 160; 
  motionMagicConfigs.MotionMagicJerk = 1600; 
  intakeAngleMotor.getConfigurator().apply(talonFXConfigs, 0.050);
  m_motmag.Slot = 0;
  intakeAngleMotor.setControl(m_motmag.withPosition(0));

  }
  public void setMotorPosition(double Position) {
    intakeAngleMotor.setControl(m_motmag.withPosition(Position));
  }
  
  public double getMotorPosition() {
    return intakeAngleMotor.getPosition().getValue();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber(getName(), getMotorPosition());
  }

}
