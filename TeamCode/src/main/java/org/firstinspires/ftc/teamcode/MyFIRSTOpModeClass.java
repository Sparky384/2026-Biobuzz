package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp

public class MyFIRSTOpModeClass extends LinearOpMode {
    private DcMotor frontLeft;
    private DcMotor backLeft;

    private DcMotor frontRight;
    private DcMotor backRight;
    @Override
    public void runOpMode() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backRight = hardwareMap.get(DcMotor.class, "backRight");

        waitForStart();

        telemetry.addData("Is Started", isStarted());
        telemetry.update();

        while (opModeIsActive()) {
            double drive = gamepad1.left_stick_y * -1;
            double turn = gamepad1.left_stick_x;
            double left = -(drive + turn);
            double right = drive - turn;

            frontLeft.setPower(left);
            backLeft.setPower(left);
            frontRight.setPower(right);
            backRight.setPower(right);
        }
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
    }
}