package com.jedrzejewski.guitarscalecoach.model;

import com.jedrzejewski.guitarscalecoach.enumerated.NumberOfFrets;
import com.jedrzejewski.guitarscalecoach.enumerated.NumberOfStrings;
import com.jedrzejewski.guitarscalecoach.enumerated.Sounds;

import java.util.List;

public class Guitar {

    private NumberOfStrings numberOfStrings;
    private NumberOfFrets numberOfFrets;
    private List<Sounds> tuning;
    private List<Sounds> scale;

    public NumberOfStrings getNumberOfStrings() {
        return numberOfStrings;
    }

    public void setNumberOfStrings(NumberOfStrings numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    public NumberOfFrets getNumberOfFrets() {
        return numberOfFrets;
    }

    public void setNumberOfFrets(NumberOfFrets numberOfFrets) {
        this.numberOfFrets = numberOfFrets;
    }

    public List<Sounds> getTuning() {
        return tuning;
    }

    public void setTuning(List<Sounds> tuning) {
        this.tuning = tuning;
    }

    public List<Sounds> getScale() {
        return scale;
    }

    public void setScale(List<Sounds> scale) {
        this.scale = scale;
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "numberOfStrings=" + numberOfStrings +
                ", numberOfFrets=" + numberOfFrets +
                ", tuning=" + tuning +
                ", scale=" + scale +
                '}';
    }
}
