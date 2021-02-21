package com.jedrzejewski.guitarscalecoach.enumerated;

public enum NumberOfFrets {

    NINETEEN(19),
    TWENTY_TWO(22),
    TWENTY_FOUR(24);

    private int frVal;

    NumberOfFrets(int frVal) { this.frVal = frVal; }

    @Override
    public String toString() {
        return Integer.valueOf(frVal).toString();
    }
}
