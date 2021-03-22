package com.jedrzejewski.guitarscalecoach.model;

import com.jedrzejewski.guitarscalecoach.enumerated.NumberOfFrets;
import com.jedrzejewski.guitarscalecoach.enumerated.NumberOfStrings;
import com.jedrzejewski.guitarscalecoach.enumerated.Sounds;

import java.util.Arrays;
import java.util.List;

public class ExercisesModel extends Guitar {

    private static final NumberOfStrings NUMBER_OF_STRINGS = NumberOfStrings.SIX;
    private static final NumberOfFrets NUMBER_OF_FRETS = NumberOfFrets.TWENTY_FOUR;
    private static final List<Sounds> TUNING = Arrays.asList(Sounds.E, Sounds.B, Sounds.G, Sounds.D, Sounds.A, Sounds.E);

    public NumberOfStrings getNUMBER_OF_STRINGS() {
        return NUMBER_OF_STRINGS;
    }

    public NumberOfFrets getNUMBER_OF_FRETS() {
        return NUMBER_OF_FRETS;
    }

    public List<Sounds> getTUNING() {
        return TUNING;
    }

    @Override
    public String toString() {
        return "ExercisesModel{" + "numberOfStrings=" + NUMBER_OF_STRINGS +
                ", numberOfFrets=" + NUMBER_OF_FRETS +
                ", tuning=" + TUNING  + '}';
    }
}
