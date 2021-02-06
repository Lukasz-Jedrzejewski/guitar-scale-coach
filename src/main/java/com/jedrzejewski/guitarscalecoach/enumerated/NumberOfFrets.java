package com.jedrzejewski.guitarscalecoach.enumerated;

public enum NumberOfFrets {

    NINETEEN(19),
    TWENTY_TWO(22),
    TWENTY_FOUR(24);

    private int frVal;

    NumberOfFrets(int frVal) { this.frVal = frVal; }

    public int getVal() { return this.frVal; }
}
