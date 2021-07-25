package enums;

public enum GuitarStringType {

    STEEL("Steel"),
    BRASS("Brass");

    private final String value;

    GuitarStringType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
