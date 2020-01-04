
package frc.robot;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class macanum {

    private CANSparkMax frontRightMotor, rearRightMotor, frontLeftMotor, rearLeftMotor;
    private static int frontRightMotorID=1, rearRightMotorID=2, frontLeftMotorID=3, rearLeftMotorID=4;
    private OI oi;
    private DifferentialDrive driverType;

    public void macanumInit() {
        oi = new OI();
        frontRightMotor = new CANSparkMax(frontRightMotorID, CANSparkMax.MotorType.kBrushless);
        rearRightMotor = new CANSparkMax(rearRightMotorID, CANSparkMax.MotorType.kBrushless);
        frontLeftMotor = new CANSparkMax(frontLeftMotorID, CANSparkMax.MotorType.kBrushless);
        rearLeftMotor = new CANSparkMax(rearLeftMotorID, CANSparkMax.MotorType.kBrushless);

        // FORWARD BACKWARD
        SpeedControllerGroup forwardb = new SpeedControllerGroup(frontRightMotor, rearRightMotor);
        SpeedControllerGroup forwardba = new SpeedControllerGroup(frontLeftMotor, rearLeftMotor);
        SpeedControllerGroup forwardbFull = new SpeedControllerGroup(forwardb, forwardba);
        // ROTATE
        SpeedControllerGroup rotate = new SpeedControllerGroup(frontRightMotor, frontLeftMotor);
        SpeedControllerGroup rotatea = new SpeedControllerGroup(rearRightMotor, rearLeftMotor);
        SpeedControllerGroup rotateFull = new SpeedControllerGroup(rotate, rotatea);


        driverType = new DifferentialDrive(forwardbFull, rotateFull);
    }
    
    public void macanumMain() {
        driverType.arcadeDrive(oi.getDriveRightX(), oi.getDriveRightY());
		if (oi.getDriveLeftX()>0) {
            frontRightMotor.set(.3);
            frontLeftMotor.set(.3);
        }
        else {
            rearLeftMotor.set(.3);
            rearRightMotor.set(.3);
        }
    }
}
