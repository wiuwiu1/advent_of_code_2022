import java.io.File;
import java.util.List;

class Application {

    private final static String ELVES_FILE_PATH = "C:/Users/Patrick.Welter/Desktop/advent_of_code_2022/day1/input.txt"; 

    public static void main (String[] args) throws Exception {
        printSolutionForFirstPart();
        printSolutionForSecondPart();
       }

    private static void printSolutionForFirstPart() throws Exception {
        var elfReader = getElfReader();
        var elf = elfReader.getElfWithMostSupplyCalories();
        System.out.println("Solution one: The elf with the most supply calories has an amount of: " + elf.supplyCalories());
    }

    private static void printSolutionForSecondPart() throws Exception {
        var elfReader = getElfReader();
        List<Elf> sortedElfs = elfReader.getElfListSortedBySupplyCalories();
        System.out.println("Solution two: The sum of the supply calories of the three elves, which have the most, is: " + sumSupplyCaloriesOfTopThreeElves(sortedElfs));
    }

    private static int sumSupplyCaloriesOfTopThreeElves(List<Elf> sortedElfs) {
        int caloriesSum = 0;
        for(int i = 0; i < 3; i++){
            caloriesSum += sortedElfs.get(i).supplyCalories();
        }
        return caloriesSum;
    }

    private static ElfReader getElfReader() {
        var elvesFile = new File(ELVES_FILE_PATH);
        return new ElfReader(elvesFile);
    }

    
}

