package customers;

import accessories.Accessory;
import instruments.Drumkit;
import instruments.Instrument;
import interfaces.ISell;
import shop.Shop;

import java.util.ArrayList;

public class Customer {

   private String name;
   private int cash;
   private ArrayList<ISell> purchases;
   private ArrayList<ISell> basket;

    public Customer(String name, int cash) {
        this.name = name;
        this.cash = cash;
        purchases = new ArrayList<>();
        basket = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCash() {
        return cash;
    }

    public void decreaseCash(int amount){
        cash -= amount;
    }

    public int getNumberOfPurchases() {
        return this.purchases.size();
    }

    public void addInstrumentToPurchases(ISell item){
        purchases.add(item);
    }

    public ArrayList<ISell> getPurchases() {
        return purchases;
    }


    public boolean canAfford(Instrument instrument) {
        boolean canAfford = false;
        if(this.getCash() > instrument.getSellPrice()){
            canAfford = true;
        }
        return canAfford;
    }

    public void buyInstrument(Shop shop, Instrument instrument) {
        if(canAfford(instrument)){
            decreaseCash(instrument.getSellPrice());
            addInstrumentToPurchases(instrument);
            shop.removeFromStock(instrument);
            shop.increaseProfit(instrument.getSellPrice());
        }
    }

    public ArrayList<ISell> getBasket(){
        return basket;
    }

    public int getNumberOfItemsInBasket(){
        return basket.size();
    }

    public void addItemToBasket(ISell item) {
        basket.add(item);
    }

    public void removeItemFromBasket(ISell item) {
        basket.remove(item);
    }

    public int getBasketPrice() {
        int total = 0;
        for(ISell item: basket){
            if(item instanceof Instrument){
                total += ((Instrument) item).getSellPrice();
            } else {
                total += ((Accessory) item).getSellPrice();
            }
        }
        return total;
    }

    public boolean canAffordBasket() {
        boolean canAfford = false;
        int basketPrice = getBasketPrice();
        if(getCash() > getBasketPrice()){
            canAfford = true;
        }
        return canAfford;
    }

    public void buyBasket() {
        if(basket.size() == 0){
            System.out.println("Your basket is currently empty");
        } else {
            purchases.addAll(basket);
            basket.removeAll(basket);
        }
    }
}
