package pl.szarawara.jakub.items;

import org.springframework.stereotype.Component;

@Component
public class Item implements Items {

    private double price;
    private int unit;
    private double specialPrice;

    public Item() {

    }

    public Item(double price, int unit, double specialPrice) {
        this.price = price;
        this.unit = unit;
        this.specialPrice = specialPrice;
    }

    public double getPrice() {
        return price;
    }

    public double getSpecialPrice() {
        return specialPrice;
    }

    public int getUnit() {
        return unit;
    }

    public double getTotalPrice(int unit) {
        return (unit / this.unit) * specialPrice + (unit % this.unit) * price;
    }

}
