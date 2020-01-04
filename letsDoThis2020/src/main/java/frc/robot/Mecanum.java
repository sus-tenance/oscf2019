// -----------------------------Mecanum.------------------------------------ //
package frc.robot;

import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class Mecanum {
    private OI oi;
    private PWMSparkMax m_frontRightMotor;
    private static final int m_frontRightMotorID = 0;
    private PWMSparkMax m_rearRightMotor;
    private static final int m_rearRightMotorID = 1;
    private PWMSparkMax m_frontLeftMotor;
    private static final int m_frontLeftMotorID = 2;
    private PWMSparkMax m_rearLeftMotor;
    private static final int m_rearLeftMotorID = 3;

    private MecanumDrive m_robotDrive;
// -----------------------------Before code starts.------------------------------------ //
    public void MecanumInit() {     
        oi = new OI();
        m_frontRightMotor = new PWMSparkMax(m_frontRightMotorID);
        m_rearRightMotor = new PWMSparkMax(m_rearRightMotorID);
        m_frontLeftMotor = new PWMSparkMax(m_frontLeftMotorID);
        m_rearLeftMotor = new PWMSparkMax(m_rearLeftMotorID);

        m_robotDrive = new MecanumDrive(m_frontRightMotor, m_rearRightMotor, m_frontLeftMotor, m_rearLeftMotor);
    }
// -----------------------------Main program.------------------------------------ //
    public void MecanumMain() {
        m_robotDrive.driveCartesian(oi.getDriveRightX(), oi.getDriveRightY(), oi.getDriveLeftX());
        }
    }
// ----------------------------------------------------------------- //