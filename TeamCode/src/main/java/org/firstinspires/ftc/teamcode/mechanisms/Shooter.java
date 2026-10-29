package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Shooter {
    private DcMotor motor;
    private DcMotorEx motorControl;

    public Shooter(HardwareMap hardwareMap){
        motor = hardwareMap.get(DcMotor.class, "ShooterMotor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motorControl = (DcMotorEx) motor;
    }
    public void spinUp (double speed){

    }

    public void stop(){
        motor.setPower(0);
    }

}
