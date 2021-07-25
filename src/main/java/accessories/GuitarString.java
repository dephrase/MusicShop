package accessories;

import enums.AccessoryType;
import enums.GuitarStringType;

public class GuitarString extends Accessory{

    private GuitarStringType stringType;

    public GuitarString(String name, int buyPrice, int sellPrice, GuitarStringType stringType) {
        super(name, buyPrice, sellPrice);
        this.stringType = stringType;
        setAccessoryType(AccessoryType.GUITARSTRINGS);
    }

    @Override
    public int calculateMarkup() {
        return getSellPrice() - getBuyPrice();
    }

    public GuitarStringType getStringType() {
        return stringType;
    }
}
