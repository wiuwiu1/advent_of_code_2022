import java.util.List;

public record Rucksack(List<RucksackItem> firstCompartment, List<RucksackItem> secondCompartment) {

    public RucksackItem findCommonItemOfCompartments(){
        return firstCompartment.stream()
            .filter(item -> secondCompartment.contains(item))
            .findAny()
            .orElse(null);
    }

}
