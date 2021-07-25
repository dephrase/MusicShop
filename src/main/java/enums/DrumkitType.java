package enums;

public enum DrumkitType {

    ELECTRIC("Electric"),
    ACOUSTIC("Acoustic"),
    COCKTAIL("Cocktail");

    private final String drumkitType;

    DrumkitType(String drumkitType){
        this.drumkitType = drumkitType;
    }

    public String getvalue() {
        return drumkitType;
    }
}
