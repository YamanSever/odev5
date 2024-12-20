package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

    TalonFX intakeMotor;
    DigitalInput intakeSensor = new DigitalInput(1);

    public Intake() {
        intakeMotor = new TalonFX(2);
    }

    public boolean getStatus() {
        return intakeSensor.get();
    }

    public void run(double speed) {
        intakeMotor.set(speed);
    }
}
