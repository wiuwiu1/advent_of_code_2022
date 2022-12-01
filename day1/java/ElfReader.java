import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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