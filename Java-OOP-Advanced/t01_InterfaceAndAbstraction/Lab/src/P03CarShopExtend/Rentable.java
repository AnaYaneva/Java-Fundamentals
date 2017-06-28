package P03CarShopExtend;

public interface Rentable extends Car {
    int getMinRentDays();

    double getPricePerDay();
}
