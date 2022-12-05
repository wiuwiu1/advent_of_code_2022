package day3.java;

public record RucksackItem(char itemType) {

    private final static int UPPER_CASE_PRIORITY_OFFSET = 38;
    private final static int LOWER_CASE_PRIORITY_OFFSET = 96;

    public int getPriority(){
        if(Character.isUpperCase(itemType)){
            return itemType - UPPER_CASE_PRIORITY_OFFSET;
        }     
        return itemType - LOWER_CASE_PRIORITY_OFFSET;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof RucksackItem){
            RucksackItem item = (RucksackItem) obj;
            return this.itemType == item.itemType;
        }
        return false;
    }

}
