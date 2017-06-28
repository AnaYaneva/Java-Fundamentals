import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    private List<Coffee> coffees;
    private List <Coin> coins;

    public CoffeeMachine() {
        this.coffees = new ArrayList<>();
        this.coins = new ArrayList<>();
    }

    void buyCoffee(String size, String type) {
        CoffeeSize coffeeSize = CoffeeSize.valueOf(size.toUpperCase());
        CoffeeType coffeeType = CoffeeType.valueOf(type.toUpperCase());
        Coffee coffee = new Coffee(coffeeSize, coffeeType);
        int price = coffee.getPrice();
        int currentSum = this.coins.stream().mapToInt(Coin::getValue).sum();
        if (currentSum >= price) {
            this.coffees.add(coffee);
            this.coins.clear();
        }
    }

    void insertCoin(String coin) {
        this.coins.add(Coin.valueOf(coin.toUpperCase()));
    }

    Iterable<Coffee> coffeesSold() {
        return this.coffees;
    }

}
