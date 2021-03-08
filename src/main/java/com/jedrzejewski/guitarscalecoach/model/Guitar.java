package com.jedrzejewski.guitarscalecoach.model;

import com.jedrzejewski.guitarscalecoach.enumerated.NumberOfFrets;
import com.jedrzejewski.guitarscalecoach.enumerated.NumberOfStrings;
import com.jedrzejewski.guitarscalecoach.enumerated.Sounds;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class Guitar {

    @NotNull
    private NumberOfStrings numberOfStrings;
    @NotNull
    private NumberOfFrets numberOfFrets;
    @NotNull
    @Size(min = 4, max = 12)
    private List<Sounds> tuning;
    private List<Sounds> scale;

    public List<Sounds> fill(Sounds sound, NumberOfFrets numberOfFrets) {
        List<Sounds> sounds = new ArrayList<Sounds>(EnumSet.allOf(Sounds.class));
        List<Sounds> resultList = new ArrayList<>();
        int frets = Integer.parseInt(numberOfFrets.toString());
        int index = sounds.indexOf(sound) + 1;
        for (int i = 0; i < frets; i++) {
            if (index >= sounds.size()) {
                index = 0;
            }
            resultList.add(sounds.get(index));
            index++;
        }
        return resultList;
    }

    public boolean checkScale(List<Sounds> sounds, Sounds singleSound) {
        return sounds.contains(singleSound);
    }

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
