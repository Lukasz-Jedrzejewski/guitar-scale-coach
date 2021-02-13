package com.jedrzejewski.guitarscalecoach.enumerated;

public enum Sounds {

    A("A"),
    AIS("A#"),
    B("B"),
    C("C"),
    CIS("C#"),
    D("D"),
    DIS("D#"),
    E("E"),
    F("F"),
    FIS("F#"),
    G("G"),
    GIS("G#");

    private String sound;

    Sounds(String str) {
        this.sound = str;
    }

    @Override
    public String toString() {
        return sound;
    }
}
