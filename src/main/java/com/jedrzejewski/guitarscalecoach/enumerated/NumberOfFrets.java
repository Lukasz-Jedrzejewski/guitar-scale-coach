package com.jedrzejewski.guitarscalecoach.enumerated;

public enum NumberOfFrets {

    NINETEEN(19),
    TWENTY_TWO(22),
    TWENTY_FOUR(24);

    private int numberOfFrets;

    NumberOfFrets(int numberOfFrets) {
        this.numberOfFrets = numberOfFrets;
    }

    public int getVal() {
        return this.numberOfFrets;
    }
}
