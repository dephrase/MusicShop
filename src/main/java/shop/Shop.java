package shop;

import accessories.Accessory;
import accessories.DrumStick;
import instruments.Drumkit;
import instruments.Instrument;
import interfaces.ISell;

import java.util.ArrayList;

public class Shop {

    private String name;
    private ArrayList<ISell> stock;
    private int money;

    public Shop(String name, int money){
        this.name = name;
        stock = new ArrayList<>();
        this.money = money;
    }

    public void addToStock(ISell item){
        stock.add(item);

    }

    public void removeFromStock(ISell item){
        stock.remove(item);
    }

    public int numberOfItemsInStock(){
        return stock.size();
    }

    public String getName() {
        return this.name;
    }

    public int calculatePotentialProfit() {
        int total = 0;
        for(ISell item: stock){
            total += item.calculateMarkup();
        }
        return total;
    }

    public int getMoney() {
        return money;
    }

    public void increaseProfit(int increment) {
        money += increment;
    }

    public void decreaseMoney(int amount){
        money -= amount;
    }

    public boolean canAffordInstrument(Instrument instrument) {
        boolean canAfford = false;
        if(money > instrument.getBuyPrice()){
            canAfford = true;
        }
        return canAfford;
    }

    public void addInstrumentToStock(Instrument instrument) {
        if(instrument != null){
            addToStock(instrument);
            decreaseMoney(instrument.getBuyPrice());
        }
    }

    public void addAccessoryToStock(Accessory accessory) {
        addToStock(accessory);
        decreaseMoney(accessory.getBuyPrice());
    }

    public ArrayList<ISell> getStock() {
        return stock;
    }
}
