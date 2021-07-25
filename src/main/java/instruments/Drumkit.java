package instruments;

import enums.DrumkitType;
import enums.InstrumentType;
import interfaces.IPlay;
import interfaces.ISell;

public class Drumkit extends Instrument implements ISell, IPlay {

    DrumkitType drumkitType;
    public Drumkit(String colour, InstrumentType instrumentType, int buyPrice, int sellPrice, DrumkitType drumkitType) {
        super(colour, instrumentType, buyPrice, sellPrice);
        this.drumkitType = drumkitType;
    }

    @Override
    public String play() {
        return "Drumkit plays a beat";
    }

    @Override
    public int calculateMarkup() {
        return getSellPrice() - getBuyPrice();
    }

    public DrumkitType getDrumkitType() {
        return drumkitType;
    }
}
