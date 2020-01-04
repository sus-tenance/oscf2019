package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
  private Mecanum MD;


  @Override
  public void robotInit() {
    MD = new Mecanum();
    MD.MecanumInit();
  }

  @Override
  public void teleopPeriodic() {
   MD.MecanumMain(); 
  }
}