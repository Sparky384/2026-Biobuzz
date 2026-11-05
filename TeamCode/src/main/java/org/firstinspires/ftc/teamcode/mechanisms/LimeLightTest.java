package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

public class LimeLightTest {
    private static final boolean USE_WEBCAM = true;
    private LimeLight3A limeLight3A;
    private VisionPortal visonPortal;
    private AprilTagProcessor aprilTag;

    public LimeLightTest(HardwareMap hardwareMap){
        visonPortal = hardwareMap.get(VisionPortal.class, "aprilTagTest1");

    }
}
