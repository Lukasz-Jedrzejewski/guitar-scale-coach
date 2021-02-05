package com.jedrzejewski.guitarscalecoach.service.serviceImpl;

import com.jedrzejewski.guitarscalecoach.enumerated.NumberOfFrets;
import com.jedrzejewski.guitarscalecoach.enumerated.NumberOfStrings;
import com.jedrzejewski.guitarscalecoach.enumerated.Sounds;
import com.jedrzejewski.guitarscalecoach.service.GuitarModelService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GuitarModelServiceImpl implements GuitarModelService {

    @Override
    public Map<Integer, Sounds> createTuning(List<Sounds> sounds) {
        Map<Integer, Sounds> tuning = new HashMap<>();
        for (int i = 0; i < sounds.size(); i++) {
            tuning.put(i+1, sounds.get(i));
        }
        return tuning;
    }

    @Override
    public List<Integer> getNumberOfStringsEnumValues() {
        List<NumberOfStrings> numberOfStrings = Arrays.asList(NumberOfStrings.values());
        List<Integer> numbers = new ArrayList<>();
        for (NumberOfStrings n : numberOfStrings) {
            numbers.add(n.getVal());
        }
        return numbers;
    }

    @Override
    public List<Integer> getNumberOfFretsEnumValues() {
        List<NumberOfFrets> numberOfFrets = Arrays.asList(NumberOfFrets.values());
        List<Integer> numbers = new ArrayList<>();
        for (NumberOfFrets n : numberOfFrets) {
            numbers.add(n.getVal());
        }
        return numbers;
    }
}
