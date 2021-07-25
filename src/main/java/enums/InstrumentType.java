package enums;

public enum InstrumentType {

    STRING("String"),
    PERCUSSION("Percussion"),
    BRASS("Brass"),
    WOODWIND("Woodwind"),
    GUITAR("Guitar");

    private final String type;

    InstrumentType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
