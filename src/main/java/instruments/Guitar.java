package instruments;

import enums.GuitarType;
import enums.InstrumentType;


public class Guitar extends Instrument{

    private GuitarType guitarType;

    public Guitar(String colour, InstrumentType instrumentType, int buyPrice, int sellPrice, GuitarType guitarType) {
        super(colour, instrumentType, buyPrice, sellPrice);
        this.guitarType = guitarType;
    }

    public GuitarType getGuitarType() {
        return guitarType;
    }

    @Override
    public String play() {
        return "Guitar plays a chord";
    }

    @Override
    public int calculateMarkup() {
        return getSellPrice() - getBuyPrice();
    }
}
