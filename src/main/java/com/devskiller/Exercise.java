package com.devskiller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Exercise {

    public List<Integer> findDuplicates(List<Integer> integers, int numberOfDuplicates) {
        throw new UnsupportedOperationException(/*TODO*/);
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> counts = new HashMap<>();
        integers.forEach(numero -> {
        	if( counts.get(numero)!=null )
        		counts.put(numero, counts.get(numero)+1);
        	else
        		counts.put(numero, 1);
        });
        counts.keySet().forEach(numero -> {
        	if( counts.get(numero)==numberOfDuplicates )
        		result.add(numero);
        });
        return result;
    }

}
