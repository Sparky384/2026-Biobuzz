package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Shooter {
    private DcMotor motor;
    private DcMotorEx motorControl;
    private DcMotor shooterEncoder;
    private Servo turretServo;
    private final double MIN_ANGLE = 1;
    private final double MAX_ANGLE = 1;

    // Change resolution once we get encoder
    private final int ENCODER_RESOLUTION = 360;
    private final double GEAR_RATIO = 2.75;
    public Shooter(HardwareMap hardwareMap){
        //Implement Gear Ratio: 2.75:1 | 360/2.75 = 130 (Basically 109.1 or 109)
        motor = hardwareMap.get(DcMotor.class, "ShooterMotor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        shooterEncoder = hardwareMap.get(DcMotor.class, "intake");
        shooterEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        turretServo = hardwareMap.get(Servo.class, "turretServo");

        motorControl = (DcMotorEx) motor;
        motorControl.setVelocity(0);
    }
    public void spinUp (double speed){
        motorControl.setVelocity(speed);
    }
    public double getTurretAngle(){
        int counts = shooterEncoder.getCurrentPosition();
        return GEAR_RATIO * (counts / ENCODER_RESOLUTION);

    }
    //True = left, false = right
    public void turnTurret(boolean direction){
        if (direction){
            turretServo.setPosition(1);
        }
        else {
            turretServo.setPosition(-1);
        }

    }
    public void stopTurret(){
        turretServo.setPosition(0);
    }

    public void stop(){
        spinUp(0);
    }

}