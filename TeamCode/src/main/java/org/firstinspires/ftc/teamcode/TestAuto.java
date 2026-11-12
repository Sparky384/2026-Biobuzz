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
        runAuto();
    }
    public void drive(double forward, double spin){
        double left = -(forward + spin);
        double right = forward - spin;

        frontLeft.setPower(left);
        backLeft.setPower(left);
        frontRight.setPower(right);
        backRight.setPower(right);
    }
    private void runAuto(){
        timer.reset();
        while (timer.milliseconds() < 4750 ){
            drive(1,-.07);
        }
        timer.reset();
        while (timer.milliseconds() < 1000){
            drive(0,-1);
        }
        timer.reset();
        while (timer.milliseconds() < 2500){
            drive(1,-.07);
        }
    }
}
