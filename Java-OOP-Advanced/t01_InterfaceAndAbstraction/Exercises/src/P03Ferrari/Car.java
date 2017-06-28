public interface Car {
    String getDriverName();

    default String pushBrakes(){
        return "Brakes!";
    }

    default String pushGasPedal(){
        return "Zadu6avam sA!";
    }
}
