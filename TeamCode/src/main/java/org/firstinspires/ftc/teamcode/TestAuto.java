package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class TestAuto extends LinearOpMode {

    private DcMotor frontLeft;
    private DcMotor backLeft;

    private DcMotor frontRight;
    private DcMotor backRight;
    private ElapsedTime timer = new ElapsedTime();

    @Override
    public void runOpMode() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backRight = hardwareMap.get(DcMotor.class, "backRight");

        waitForStart();

        setMotorPower(.5);

        timer.reset();
        while (timer.milliseconds() < 2000){
            //Do nothing inside
        }
        setMotorPower(0);
    }

    private void setMotorPower(double motorPower){
        frontLeft.setPower(motorPower);
        backLeft.setPower(motorPower);
        frontRight.setPower(motorPower);
        backRight.setPower(motorPower);
    }
}
