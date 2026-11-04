package org.firstinspires.ftc.teamcode;

public enum MotorSpeeds {
    //These numbers are just placeholders
    SHORT (250),
    MEDIUM (500),
    LONG (1000);
    private final int value;

    private MotorSpeeds(int v){
        value = v;
    }

    public int getValue() {
        return value;
    }
}