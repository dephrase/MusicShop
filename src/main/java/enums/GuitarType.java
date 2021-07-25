package enums;

public enum GuitarType {

    ACOUSTIC("Acoustic", 6),
    ELECTRIC("Electric", 6),
    BASS("Bass", 4),
    TWELVESTRING("Twelve String", 12);

    private final String typeValue;
    private final int numOfStrings;

    GuitarType(String guitarType, int numOfStrings){
        this.typeValue = guitarType;
        this.numOfStrings = numOfStrings;
    }

    public String getGuitarType() {
        return typeValue;
    }

    public int getNumOfStrings() {
        return numOfStrings;
    }
}
