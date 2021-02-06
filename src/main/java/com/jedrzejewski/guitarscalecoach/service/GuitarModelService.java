package com.jedrzejewski.guitarscalecoach.service;

import com.jedrzejewski.guitarscalecoach.enumerated.Sounds;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface GuitarModelService {

    Map<Integer, Sounds> createTuning (List<Sounds> sounds);
    List<Integer> getEnumValues(Class<? extends Enum> cl) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
