package com.jedrzejewski.guitarscalecoach.service.serviceImpl;

import com.jedrzejewski.guitarscalecoach.enumerated.Sounds;
import com.jedrzejewski.guitarscalecoach.service.GuitarModelService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
