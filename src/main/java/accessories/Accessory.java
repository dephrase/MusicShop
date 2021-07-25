package accessories;

import enums.AccessoryType;
import interfaces.ISell;

public abstract class Accessory implements ISell {

    private String name;
    private int buyPrice;
    private int sellPrice;
    private AccessoryType accessoryType;

    public Accessory(String name, int buyPrice, int sellPrice) {
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.accessoryType = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public void setAccessoryType(AccessoryType accessoryType) {
        this.accessoryType = accessoryType;
    }

    public AccessoryType getAccessoryType() {
        return accessoryType;
    }
}
