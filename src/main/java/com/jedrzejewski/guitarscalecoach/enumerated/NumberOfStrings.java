package com.jedrzejewski.guitarscalecoach.enumerated;

public enum NumberOfStrings {

    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    TEN(10),
    TWELVE(12);

    private int stVal;

    NumberOfStrings(int stVal) {
        this.stVal = stVal;
    }

    public int getVal() {
        return this.stVal;
    }
}

