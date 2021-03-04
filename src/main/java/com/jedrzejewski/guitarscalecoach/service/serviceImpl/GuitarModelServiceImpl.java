package com.jedrzejewski.guitarscalecoach.service.serviceImpl;

import com.jedrzejewski.guitarscalecoach.enumerated.NumberOfFrets;
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
            tuning.put(i + 1, sounds.get(i));
        }
        return tuning;
    }

    @Override
    public List<Sounds> fill(Sounds sound, NumberOfFrets numberOfFrets) {
        List<Sounds> sounds = new ArrayList<Sounds>(EnumSet.allOf(Sounds.class));
        List<Sounds> resultList = new ArrayList<>();
        int frets = Integer.parseInt(numberOfFrets.toString());
        int index = sounds.indexOf(sound)+1;
        for (int i = 0; i < frets; i++) {
            if (index >= sounds.size()) {
                index = 0;
            }
            resultList.add(sounds.get(index));
            index++;
        }
        return resultList;
    }

}
