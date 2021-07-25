package shop;

import interfaces.ISell;

import java.util.ArrayList;

public class Shop {

    private String name;
    private ArrayList<ISell> stock;

    public Shop(String name){
        this.name = name;
        stock = new ArrayList<>();
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
}
