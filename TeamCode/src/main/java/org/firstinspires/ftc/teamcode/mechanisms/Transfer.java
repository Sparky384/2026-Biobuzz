package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Transfer {
    private DcMotor motor;

    public Transfer(HardwareMap hardwareMap){
        motor = hardwareMap.get(DcMotor.class, "transferMotor");
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void transferIn(){
        motor.setPower(1);
    }

    public void transferStop(){
        motor.setPower(0);
    }

    public void transferOut(){
        motor.setPower(-1);
    }

}
