import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

public class Application {

    public final static String RUCKSACK_LIST_PATH = "C:/dev/advent_of_code/advent_of_code_2022/day3/input.txt";
    public static void main(String[] args) throws IOException {
        File rucksackListFile = new File(RUCKSACK_LIST_PATH);
        int prioritySum = calculatePrioritySum(rucksackListFile);
        System.out.println(String.format("The sum of the priorities of all item types, which were sorted wrong, is: %s", prioritySum));    
    }

    private static int calculatePrioritySum(File rucksackListFile) throws IOException {
        RucksackListParser rucksackListParser = new RucksackListParser();
        return rucksackListParser.toList(rucksackListFile)
            .stream()
            .map(Rucksack::findCommonItemOfCompartments)
            .collect(Collectors.summingInt(RucksackItem::getPriority));
    }

}
