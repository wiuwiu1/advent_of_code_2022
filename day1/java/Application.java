import java.io.File;

class Application {

    private final static String ELVES_FILE_PATH = "C:/Users/Patrick.Welter/Desktop/advent_of_code_2022/day1/input.txt"; 

    public static void main (String[] args) throws Exception {
        var elvesFile = new File(ELVES_FILE_PATH);
        var elfReader = new ElfReader(elvesFile);
        var elf = elfReader.getElfWithMostSupplyCalories();
        System.out.println("The elf with the most supply calories has an amount of: " + elf.supplyCalories());
    }
}

