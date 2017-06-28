package CarSalesman;

public class Car {
    private static final int DEFAULT_WEIGHT=0;
    private static final String DEFAULT_COLOR="n/a";

    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight=DEFAULT_WEIGHT;
        this.color=DEFAULT_COLOR;
    }

    public Car(String model, Engine engine, int weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color=DEFAULT_COLOR;
    }

    public Car(String model, Engine engine, String color) {
        this.model = model;
        this.engine = engine;
        this.weight=DEFAULT_WEIGHT;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return this.model;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getColor() {
        return this.color;
    }
}
