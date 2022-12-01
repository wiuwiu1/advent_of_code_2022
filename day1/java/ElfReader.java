import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class ElfReader {

    private final File file;

    public ElfReader(File file) {
        this.file = file;
    }

    public Elf getElfWithMostSupplyCalories() throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(this.file));
        Elf elfWithMostCalories = null;
        
        for(Elf currentElf = readNextElf(reader); currentElf != null; currentElf = readNextElf(reader)){
            if(!wasAnElfAlreadyFound(elfWithMostCalories) || currentElf.hasMoreSupplyCalories(elfWithMostCalories)){
               elfWithMostCalories = currentElf; 
            }
        }
       
        reader.close();
        return elfWithMostCalories;
    }

    public List<Elf> getElfListSortedBySupplyCalories() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(this.file));

        TreeSet<Elf> elvesSortedByCalories = getCaloriesComparableElfTreeSet();

        for(Elf currentElf = readNextElf(reader); currentElf != null; currentElf = readNextElf(reader)){
            elvesSortedByCalories.add(currentElf);
        }

        reader.close();

        return new ArrayList<Elf>(elvesSortedByCalories.descendingSet());
    }

    private TreeSet<Elf> getCaloriesComparableElfTreeSet() {
        return new TreeSet<>(new Comparator<Elf>() {
            @Override
            public int compare(Elf elf1, Elf elf2) {
                if(elf1.hasMoreSupplyCalories(elf2))
                    return 1;
                if(elf2.hasMoreSupplyCalories(elf1))    
                    return -1;
                return 0;    
            }
        });
    }

    private boolean wasAnElfAlreadyFound(Elf elfWithMostCalories) {
        return elfWithMostCalories != null;
    }

    private Elf readNextElf(BufferedReader reader) throws IOException{
        String line = reader.readLine();
        if(isEndOfFile(line)){
            return null;
        }
    
        int calories = 0;
        while(!isEndOfElf(line)){
            calories += Integer.parseInt(line);
            line = reader.readLine();
        }
       
        return new Elf(calories);
    }

    private boolean isEndOfFile(String line) {
        return line == null;
    }

    private boolean isEndOfElf(String line) {
        return isEndOfFile(line) || line.isBlank();
    }

}