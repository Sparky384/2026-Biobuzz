package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {
    private DcMotor motor;
    private final double OPEN_POSITION = 1.0;
    private final double CLOSED_POSITION = 0.0;
    private Servo leftGate;
    private Servo rightGate;

    private ColorSensor colorSensor;
    private int ammo;
    private boolean prevBall;
    public Intake(HardwareMap hardwareMap){
        leftGate = hardwareMap.get(Servo.class, "leftGate");
        rightGate = hardwareMap.get(Servo.class, "rightGate");
        motor = hardwareMap.get(DcMotor.class, "intake");
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor");
        ammo = 0;
        prevBall = false;
    }

    public void periodic(){
        boolean hasBall = Math.max(colorSensor.blue(), colorSensor.red()) > 0;
        hasBall = hasBall || colorSensor.green() > 0;
        if (hasBall && !prevBall){
            ammo++;
        }
        prevBall = hasBall;
    }

    public void openGate(){
        leftGate.setPosition(OPEN_POSITION);
        rightGate.setPosition(OPEN_POSITION);
    }
    public void closeGate(){
        leftGate.setPosition(CLOSED_POSITION);
        rightGate.setPosition(CLOSED_POSITION);
    }
    public void intake(){
        motor.setPower(1);

    }
    public void outtake(){
        motor.setPower(-1);
    }
    public void stop(){
        motor.setPower(0);
    }
}
