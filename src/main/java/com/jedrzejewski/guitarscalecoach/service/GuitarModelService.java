package com.jedrzejewski.guitarscalecoach.service;

import com.jedrzejewski.guitarscalecoach.enumerated.Sounds;

import java.util.List;
import java.util.Map;

public interface GuitarModelService {

    Map<Integer, Sounds> createTuning (List<Sounds> sounds);
}
