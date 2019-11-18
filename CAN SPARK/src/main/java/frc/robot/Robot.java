/*
           _           _     _                  
          | |         | |   (_)                 
 _ __ ___ | |__   ___ | |_   _  __ ___   ____ _ 
| '__/ _ \| '_ \ / _ \| __| | |/ _` \ \ / / _` |
| | | (_) | |_) | (_) | |_ _| | (_| |\ V / (_| |
|_|  \___/|_.__/ \___/ \__(_) |\__,_| \_/ \__,_|
                           _/ |                 
                          |__/                  
*/
package frc.robot;//imports robot

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private Joystick m_leftStick = new Joystick(0); //                                     |       |
  private static final int FleftMotorID = 1;  // NEED TO FIND THIS OUT                  ||1     2||
  private static final int FrightMotorID = 2; // THIS ONE TOO                            |  5|   |
  private static final int RleftMotorID = 3;  // NEED TO FIND THIS OUT                  ||3     4||
  private static final int RrightMotorID = 4; // THIS ONE TOO                            |       |
  private static final int horizontalMotorID = 5; // NEED TO FIND THIS OUT
  private CANSparkMax m_FleftMotor;
  private CANSparkMax m_FrightMotor;
  private CANSparkMax m_RleftMotor;
  private CANSparkMax m_RrightMotor;
  private CANSparkMax m_HorizontalMotor;

  private OI oi;

  @Override //also overrides
  public void robotInit() {
 
    m_FleftMotor = new CANSparkMax(FleftMotorID, MotorType.kBrushless); //make motor 1
    m_RleftMotor = new CANSparkMax(RleftMotorID, MotorType.kBrushless); //make also motor 2
    m_FrightMotor = new CANSparkMax(FrightMotorID, MotorType.kBrushless); //make motor 3
    m_RrightMotor = new CANSparkMax(RrightMotorID, MotorType.kBrushless); //make also motor 4
    m_HorizontalMotor = new CANSparkMax(horizontalMotorID, MotorType.kBrushless);//make motor 5

    SpeedControllerGroup m_Right = new SpeedControllerGroup(m_FleftMotor, m_RleftMotor);
    SpeedControllerGroup m_Left = new SpeedControllerGroup(m_FrightMotor, m_RrightMotor);

    m_myRobot = new DifferentialDrive(m_Left, m_Right);

  }

  @Override //overrides
  public void teleopPeriodic() {
    m_myRobot.arcadeDrive(m_leftStick.getX(),  m_leftStick.getY()); 

    //horizontal drive
    m_HorizontalMotor.set(oi.getDriveRightX());

  }
}