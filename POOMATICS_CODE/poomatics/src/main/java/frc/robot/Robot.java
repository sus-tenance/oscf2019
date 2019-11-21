package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
private DoubleSolenoid phatSolenoid = new DoubleSolenoid(1, 2);
private Compressor c = new Compressor(0);
private OI oi;
private boolean enabled = c.enabled();
private boolean pressureSwitch = c.getPressureSwitchValue();

  @Override
  public void robotInit() {
  }

  @Override
  public void teleopPeriodic() {
    if (oi.getA()) { //turn valve off
      phatSolenoid.set(DoubleSolenoid.Value.kOff);
    }
    else if (oi.getB()) { //airflow forward
      phatSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    else if (oi.getX()) { //airflow reverse
      phatSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    else if (oi.getDriveRightTrigger()>0 && pressureSwitch==false) { //turn on comp
      c.setClosedLoopControl(true);
    }
    else if (oi.getDriveRightTrigger()>0 || pressureSwitch==true) { //turn off comp
      c.setClosedLoopControl(false);
    }
  }
}