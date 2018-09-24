package pl.szarawara.jakub.items;

public interface Items {

    double getPrice();

    double getSpecialPrice();

    int getUnit();

    double getTotalPrice(int unit);
}
