package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.mechanisms.DcMotorDriveTrainTestBench;

@Autonomous
public class MoveAuto extends LinearOpMode {

    private DcMotorDriveTrainTestBench bench = new DcMotorDriveTrainTestBench();
    private ElapsedTime timer = new ElapsedTime();

    @Override
    public void runOpMode() {
        bench.init(hardwareMap);

        waitForStart();

        bench.drive(.5,.2);

        timer.reset();
        while (timer.milliseconds() < 2000){
            //Do nothing inside
        }
        bench.drive(0,0);
    }
}
