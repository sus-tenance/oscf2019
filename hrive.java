// -----------------------------H-DRIVE.------------------------------------ //
package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class hrive {

    private OI oi;
    private DifferentialDrive driveType;

    private CANSparkMax frontRight, rearRight, frontLeft, rearLeft, horizontalMotor;

    private static int frontRightID=0, rearRightID=1, frontLeftID=2, rearLeftID=3, horizontalMotorID=4;

    // -----------------------------Before code starts.------------------------------------ //
    public void hDriveInit() {
        oi = new OI();

        frontRight = new CANSparkMax(frontRightID, MotorType.kBrushless);
        rearRight = new CANSparkMax(rearRightID, MotorType.kBrushless);
        frontLeft = new CANSparkMax(frontLeftID, MotorType.kBrushless);
        rearLeft = new CANSparkMax(rearLeftID, MotorType.kBrushless);
        horizontalMotor = new CANSparkMax(horizontalMotorID, MotorType.kBrushless);

        SpeedControllerGroup Right = new SpeedControllerGroup(frontRight, rearRight);
        SpeedControllerGroup Left = new SpeedControllerGroup(frontLeft, rearLeft);

        driveType = new DifferentialDrive(Right, Left);
    }
    // -----------------------------Main program.------------------------------------ //
    public void hDriveMain() {
        driveType.arcadeDrive(oi.getDriveLeftX(), oi.getDriveLeftY());
        horizontalMotor.set(oi.getDriveRightX());
        }
    }
// ----------------------------------------------------------------- //