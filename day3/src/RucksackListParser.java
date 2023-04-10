import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class RucksackListParser{

    public List<Rucksack> toList(File file) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<Rucksack> rucksacks = reader.lines()
            .map(this::parseLine)
            .collect(Collectors.toList());
        reader.close();
        return rucksacks;
    }

    private Rucksack parseLine(String line) {
        List<RucksackItem> leftCompartment = extractFirstCompartment(line);
        List<RucksackItem> rightCompartment = extractSecondCompartment(line);
        return new Rucksack(leftCompartment, rightCompartment);
    }

    private List<RucksackItem> extractFirstCompartment(String line) {
        String compartmentString =  line.substring(0, getCompartmentSeparationPosition(line));
        return convertStringIntoCompartment(compartmentString);
    }

    private List<RucksackItem> extractSecondCompartment(String line) {
        String compartmentString = line.substring(getCompartmentSeparationPosition(line), line.length());
        return convertStringIntoCompartment(compartmentString);
    }

    private int getCompartmentSeparationPosition(String line) {
        return line.length() / 2;
    }

    private List<RucksackItem> convertStringIntoCompartment(String compartmentString) {
        return compartmentString.chars()
            .mapToObj(itemType -> (char) itemType)
            .map(itemType -> new RucksackItem(itemType))
            .collect(Collectors.toList());
    }
    
}
