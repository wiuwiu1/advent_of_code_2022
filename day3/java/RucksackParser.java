package day3.java;

import java.util.List;

public class RucksackParser {

    public RucksackItem findCommonItemOfCompartments(Rucksack rucksack){
        List<RucksackItem> secondCompartment = rucksack.secondCompartment(); 
        return rucksack.firstCompartment()
            .stream()
            .filter(item -> secondCompartment.contains(item))
            .findAny()
            .orElseThrow();
    }
    
}
