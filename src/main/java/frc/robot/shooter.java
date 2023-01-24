package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class shooter extends SubsystemBase {
  private static final int shooter_id = 13;
  private CANSparkMax MShooter;
  private Joystick m_controller;

  public shooter(Joystick controller) {
    MShooter = new CANSparkMax(shooter_id, MotorType.kBrushless);
    m_controller = controller;
  }

  @Override
  public void periodic() {
    if (m_controller.getRawButton(1)) {
      MShooter.set(.50);
    }
    else if (m_controller.getRawButton(2)) {
      MShooter.set(.1);
    }
    else {
      MShooter.set(0);
    }
  }
}
