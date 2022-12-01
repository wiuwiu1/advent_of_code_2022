public record Elf(int supplyCalories) {

    public Elf {
        if(supplyCalories < 0)
            throw new IllegalArgumentException("Parameters cant be negative");
    }

    public boolean hasMoreSupplyCalories(Elf anotherElf){
        return this.supplyCalories > anotherElf.supplyCalories;
    }

}