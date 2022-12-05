package day3.java;

import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

public class Application {

    public final static String RUCKSACK_LIST_PATH = "C:/Users/Patrick.Welter/Desktop/advent_of_code_2022/day3/input.txt";
    public static void main(String[] args) throws IOException {
        RucksackParser rucksackParser = new RucksackParser();
        RucksackListParser rucksackListParser = new RucksackListParser();
        int prioritySum = rucksackListParser.toList(new File(RUCKSACK_LIST_PATH))
            .stream()
            .map(rucksack -> rucksackParser.findCommonItemOfCompartments(rucksack))
            .collect(Collectors.summingInt(RucksackItem::getPriority));
        System.out.println(String.format("The sum of the priorities of all item types, which were sorted wrong, is: %s", prioritySum));    
    }

}
