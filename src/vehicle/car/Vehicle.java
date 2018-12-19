package vehicle.car;

import vehicle.exception.*;

public abstract class Vehicle implements VehicleInterface{

    private int currentGear;
    private int currentSpeed;
    private int productionYear;
    private Color color;

    private Vehicle() {
        this(-1,-1);
    }
    private Vehicle(int currentGear, int currentSpeed) {
        this.currentGear = currentGear;
        this.currentSpeed = currentSpeed;
    }
    public Vehicle(Color color, int productionYear) {
        this();
        try {
            this.color = color;
            setProductionYear(productionYear);
        }
        catch (VehicleException e){{
            throw new VehicleRuntimeException("Nu sa putut crea un vehicul");
        }}
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public void setCurrentGear(int currentGear) throws InvalidGearException{
        this.currentGear = currentGear;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) throws InvalidProductionYearException{
        int productionEndYear = getProductionEndYear();
        int productionStartYear = getProductionStartYear();

        if (productionStartYear > productionYear || productionEndYear<productionYear){
            throw new InvalidProductionYearException("The production year must be between "+ productionStartYear +" and " +productionEndYear);
        }
        else{
            this.productionYear = productionYear;
        }
        this.productionYear = productionYear;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


//    private void setProductionYear(int productionYear) throws InvalidProductionYearException {
//        int productionEndYear = getProductionEndYear();
//    }

    /**
     * Changes the gear of a vehicle.
     * @param newGear the new gear to wich the vehicle should change the gear.
     * @throws InvalidGearException
     */
    public void changeGear(int newGear) throws InvalidGearException{
        System.out.println("Changing the gear...");
       if (newGear >= 0 && newGear <= getNumberOfGears()){
           if (newGear > this.currentGear){
               int maxSpeedForGear = getMaxSpeedForGear(newGear);
               if (maxSpeedForGear < this.currentSpeed) {
                   throw new InvalidGearException("You cannnot change the gear " + newGear + "until you slow down to " +maxSpeedForGear);
               }
               this.currentGear = newGear;
           }
           else {
               throw new InvalidGearException("The vehicle only has "+getNumberOfGears() + " gears");
           }
       }
    }

    /**
     * The car is accelerating at a new speed
     * @param acceleration
     * @throws EngineNotStartedException
     * @throws InvalidGearException
     * @throws InvalidSpeedException
     */
    public void accelerate(int acceleration)throws EngineNotStartedException, InvalidGearException, InvalidSpeedException{

        if (acceleration < 0){
            throw new InvalidSpeedException("The speed must be positive");
        }
        int tempSpeed = this.currentSpeed + acceleration;

        // check if the engine is started
        if (this.currentGear < 0){
            throw new EngineNotStartedException("You can't accelerate before starting the engine");
        }

        // the maximum speed that can be achived with the current gear
        int maxSpeed = getMaxSpeedForGear(this.currentGear);

        if (this.currentGear == 0){
            //check if the gear was set
            throw new InvalidGearException("You cannot accelerate without setting a gear");
        }
        else if (tempSpeed <= maxSpeed){
            // the vehicle accelerate
            System.out.println("The vehicle reached the speed of " + tempSpeed);
            this.currentSpeed = tempSpeed;
        }
        else {
            this.currentSpeed = maxSpeed;
            throw new InvalidSpeedException("The speed you will reach by accelerating will be over " +
                    "the maximum speed allowed in the current gear, wich is: " + maxSpeed);
        }

    }


    /**
     * Starts the engine of the vehicle. Sets the speed and gear to 0.
     * @throws EngineNotStartedException
     */
    public void startEngine() throws EngineNotStartedException{
        System.out.println("Starting the engine...");
        if (this.currentGear>=0 || this.currentSpeed >=0){
            throw new EngineNotStartedException("The engine is aleardy running!");
        }
        else {
            this.currentSpeed = 0;
            this.currentGear = 0;
            System.out.println(toString() + ": Engine started.");
        }
    }

    /**
     * Stops the engine of the vehicle. Sets the speed and gear to -1.
     * @throws EngineNotStopedException
     */
    public void stopEngine() throws EngineNotStopedException{
        System.out.println("Stoping the engine...");
        if (this.currentGear < 0 || this.currentSpeed < 0){
            throw new EngineNotStopedException("You can't stop the engine since is already stoped!");
        }
        else {
            this.currentSpeed =-1;
            this.currentGear = -1;
            System.out.println(toString() + ": Engine stoped.");
        }
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "currentGear=" + currentGear +
                ", currentSpeed=" + currentSpeed +
                ", productionYear=" + productionYear +
                ", color=" + color +
                '}';
    }
}
