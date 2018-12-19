package vehicle.car;

public abstract class Car extends Vehicle{

    public Car(Color color, int productionYear) {
        super(color, productionYear);
    }

    @Override
    public int getNumberOfWheels() {
        return 4;
    }


}
