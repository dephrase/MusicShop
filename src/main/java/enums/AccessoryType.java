package enums;

public enum AccessoryType {

    SHEETMUSIC("Sheet Music"),
    DRUMSTICKS("Drum Sticks"),
    GUITARSTRINGS("Guitar Strings");

    private final String value;

    AccessoryType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
