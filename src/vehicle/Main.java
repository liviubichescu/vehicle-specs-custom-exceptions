package vehicle;

import vehicle.car.Color;
import vehicle.car.DaciaDuster;
import vehicle.exception.VehicleException;

public class Main {

    public static void main(String[] args) throws VehicleException {
        DaciaDuster daciaDuster = new DaciaDuster(Color.BLACK,2002);
        System.out.println(daciaDuster.getCurrentGear());

        daciaDuster.startEngine();
        daciaDuster.changeGear(1);
        daciaDuster.accelerate(15);

        daciaDuster.changeGear(2);
        daciaDuster.accelerate(15);


    }
}
