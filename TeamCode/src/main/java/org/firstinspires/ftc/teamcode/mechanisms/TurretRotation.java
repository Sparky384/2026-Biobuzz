package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class TurretRotation {
    private Servo servoTurretRot;

    public TurretRotation(HardwareMap hardwareMap) {
        servoTurretRot = hardwareMap.get(Servo.class, "servo-turret-rotation");
    }

    public void setServoRot(double power){
        servoTurretRot.setPower(power)
    }

}
