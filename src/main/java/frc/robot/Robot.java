package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Robot extends TimedRobot {
  private static final int Controllerport = 0;
  private static final int Lmotorport = 2;
  private static final int Rmotorport = 4;
  private static final int RRmotorport = 5;
  private static final int RLmotorport = 3;

 private DifferentialDrive drivetrain;
  private Joystick m_controller;
  private CANSparkMax Rear_left_motor;
  private CANSparkMax Rear_right_motor;
  private CANSparkMax right_motor;
  private CANSparkMax left_motor;
  private shooter Mshooter;
  @Override
  public void robotInit() {
    Rear_left_motor = new CANSparkMax(RLmotorport,MotorType.kBrushless);
    Rear_right_motor = new CANSparkMax(RRmotorport,MotorType.kBrushless);
    right_motor = new CANSparkMax(Rmotorport,MotorType.kBrushless);
    left_motor = new CANSparkMax(Lmotorport,MotorType.kBrushless);
    m_controller = new Joystick(Controllerport);
    Rear_right_motor.follow(right_motor);
    Rear_left_motor.follow(left_motor);
    drivetrain = new DifferentialDrive (left_motor,right_motor);
    right_motor.setInverted(true);
    Mshooter = new shooter(m_controller);
  }

  @Override
  public void teleopPeriodic() {
     drivetrain.arcadeDrive(m_controller.getY()*.6, m_controller.getX()*.6);
     Mshooter.periodic();
    }
  }