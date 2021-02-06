package com.jedrzejewski.guitarscalecoach.service.serviceImpl;

import com.jedrzejewski.guitarscalecoach.enumerated.NumberOfFrets;
import com.jedrzejewski.guitarscalecoach.enumerated.NumberOfStrings;
import com.jedrzejewski.guitarscalecoach.enumerated.Sounds;
import com.jedrzejewski.guitarscalecoach.service.GuitarModelService;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    public List<Integer> getEnumValues(Class<? extends Enum> cl) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        EnumSet enumSet = EnumSet.allOf(cl);
        List<Integer> numbers = new ArrayList<>();
        for (Object o : enumSet) {
            Method getVal = cl.getMethod("getVal");
            numbers.add((Integer) getVal.invoke(o));
        }
        return numbers;
    }

}
