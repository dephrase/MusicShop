package accessories;

public class DrumStick extends Accessory{

    private String colour;

    public DrumStick(String name, int buyPrice, int sellPrice, String colour) {
        super(name, buyPrice, sellPrice);
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public int calculateMarkup() {
        return getSellPrice() - getBuyPrice();
    }
}
