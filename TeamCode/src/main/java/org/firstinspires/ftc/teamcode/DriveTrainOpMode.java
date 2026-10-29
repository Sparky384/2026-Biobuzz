package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.DriveTrain;

@TeleOp
public class DriveTrainOpMode extends LinearOpMode {
    DriveTrain drive = new DriveTrain();

    @Override
    public void runOpMode() {
        drive.init(hardwareMap);

        waitForStart();
        while (opModeIsActive()){
            double forwardValue = -gamepad1.left_stick_y;
            double turnValue = gamepad1.left_stick_x;

            telemetry.addData("forwardValue", forwardValue);
            telemetry.addData("turnValue", turnValue);
            telemetry.update();

            drive.drive(forwardValue, turnValue);
        }

        drive.stop();
    }
}