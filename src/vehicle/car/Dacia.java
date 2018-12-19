package vehicle.car;

public abstract class Dacia extends Car {


    public Dacia(Color color, int productionYear) {
        super(color, productionYear);
    }

    @Override
    public String getProducer() {
        return "Dacia";
    }
}
