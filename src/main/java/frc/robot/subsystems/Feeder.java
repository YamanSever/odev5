package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Feeder extends SubsystemBase {

    public TalonFX FeederMotor;
    public static DigitalInput feederSensor = new DigitalInput(2);
    
    public Feeder() {
        FeederMotor = new TalonFX(1);
    }

    public boolean getStatus() {
        return feederSensor.get();
    }

    public void run(double speed) {
        FeederMotor.set(speed);
    }
}
