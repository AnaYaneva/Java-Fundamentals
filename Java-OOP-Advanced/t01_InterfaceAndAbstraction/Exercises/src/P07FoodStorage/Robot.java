package P07FoodStorage;

public class Robot extends Entities {
    private String model;

    public Robot(String ID) {
        super(ID);
    }

    public Robot(String model, String ID) {
        super(ID);
        this.setModel(model);
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
