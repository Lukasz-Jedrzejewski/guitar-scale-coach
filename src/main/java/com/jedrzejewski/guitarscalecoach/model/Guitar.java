package com.jedrzejewski.guitarscalecoach.model;

import com.jedrzejewski.guitarscalecoach.enumerated.NumberOfFrets;
import com.jedrzejewski.guitarscalecoach.enumerated.NumberOfStrings;
import com.jedrzejewski.guitarscalecoach.enumerated.Sounds;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guitar {

    private NumberOfStrings numberOfStrings;
    private NumberOfFrets numberOfFrets;
    private Map<Integer, Sounds> tuning;

    public Map<Integer, Sounds> createTuning (List<Sounds> sounds) {
        Map<Integer, Sounds> tuning = new HashMap<>();
        for (int i = 0; i < sounds.size(); i++) {
            tuning.put(i+1, sounds.get(i));
        }
        return tuning;
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

    public Map<Integer, Sounds> getTuning() {
        return tuning;
    }

    public void setTuning(Map<Integer, Sounds> tuning) {
        this.tuning = tuning;
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "numberOfStrings=" + numberOfStrings +
                ", numberOfFrets=" + numberOfFrets +
                ", tuning=" + tuning +
                '}';
    }
}
