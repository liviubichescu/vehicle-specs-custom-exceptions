package vehicle.car;

import vehicle.exception.InvalidGearException;

public class DaciaDuster extends Dacia {

    public DaciaDuster(Color color, int productionYear) {
        super(color, productionYear);
    }

    private static final int[] GEAR_RANGES = { 0, 20, 40, 80, 120, 180 };

    @Override
    public int getMaxSpeed() {
        return 250;
    }

    @Override
    public String getModel() {
        return "Duster";
    }

    @Override
    public int getProductionStartYear() {
        return 2000;
    }

    @Override
    public int getProductionEndYear() {
        return 2018;
    }

    @Override
    public int getNumberOfGears() {
        return 5;
    }

    @Override
    public int getMaxSpeedForGear(int gear) throws InvalidGearException {

        if (gear >= 0 && gear < GEAR_RANGES.length){
            return  GEAR_RANGES[gear];
        }
        else {
            throw new InvalidGearException("Invalid gear. Dacia Duster");
        }
    }

}
