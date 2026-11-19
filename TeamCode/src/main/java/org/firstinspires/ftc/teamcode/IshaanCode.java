package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class IshaanCode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotorEx flywheel = hardwareMap.get(DcMotorEx.class, "flywheel");
        DcMotorEx encoder = hardwareMap.get(DcMotorEx.class, "encoder1");
        CRServo servo = hardwareMap.get(CRServo.class, "servo1");
        encoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        double p = 0.00028;
        double d = 0.000018;
        double error = 0;
        double revolutions = 0;
        double angle = 0;
        double target = 244;
        double zeroPosition = target;
        ElapsedTime timer = new ElapsedTime();
        double lastError = 0;
        waitForStart();
        while (opModeIsActive()) {
            flywheel.setVelocityPIDFCoefficients(40.0, 0.9, 20.0, 0.05);

            if (gamepad1.a)
                flywheel.setVelocity(1575);
            else if (gamepad1.b)
                flywheel.setVelocity(0);


            if (gamepad1.left_bumper)
                target = 8192 / 2 + 244;
            else if (gamepad1.right_bumper)
                target = -8192 / 2 + 244;
            else
                target = zeroPosition;


            error = target - encoder.getCurrentPosition();
            double time = timer.seconds();
            revolutions = (error / 8192) * 1 / 2.75;
            angle = revolutions * 360;
            double derivative = (error - lastError) / time;
            double pidPower = (p * error) + (d * derivative);
            double power = Range.clip(pidPower, -1.0, 1.0);
            servo.setPower(power);


            lastError = error;
            timer.reset();


            telemetry.addData("Current position: ", encoder.getCurrentPosition());
            telemetry.addData("Revolutions: ", revolutions);
            telemetry.addData("Angle: ", angle);
            telemetry.addData("pidPower", pidPower);
            telemetry.addData("Power: ", power);
            telemetry.update();
        }


    }

}