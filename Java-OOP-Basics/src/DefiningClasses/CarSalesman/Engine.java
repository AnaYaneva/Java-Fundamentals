package CarSalesman;

public class Engine {
    private static final int DEFAULT_DISPLACEMENT=0;
    private static final String DEFAULT_EFFICIENCY="n/a";

    private String engineModel;
    private int power;
    private int displacements;
    private String efficiency;

    public Engine(String engineModel,int power){
        this.engineModel=engineModel;
        this.power=power;
        this.displacements=DEFAULT_DISPLACEMENT;
        this.efficiency=DEFAULT_EFFICIENCY;
    }

    public Engine(String engineModel, int power,int displacements){
        this.engineModel=engineModel;
        this.power=power;
        this.displacements=displacements;
        this.efficiency=DEFAULT_EFFICIENCY;
    }

    public Engine(String engineModel, int power, String efficiency) {
        this.engineModel = engineModel;
        this.power = power;
        this.displacements=DEFAULT_DISPLACEMENT;
        this.efficiency = efficiency;
    }

    public Engine(String engineModel, int power, int displacements, String efficiency) {
        this.engineModel = engineModel;
        this.power = power;
        this.displacements = displacements;
        this.efficiency = efficiency;
    }

    public String getEngineModel() {
        return this.engineModel;
    }

    public int getPower() {
        return this.power;
    }

    public int getDisplacements() {
        return this.displacements;
    }

    public String getEfficiency() {
        return this.efficiency;
    }
}
