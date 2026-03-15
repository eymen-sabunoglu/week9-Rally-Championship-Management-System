/**
 * Abstract parent class for all rally cars.
 */
public abstract class RallyCar {
    private String make;
    private String model;
    private int horsepower;

    public RallyCar(String make, String model, int horsepower) {
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    /**
     * Returns a performance rating for the car.
     */
    public abstract double calculatePerformance();

    @Override
    public String toString() {
        return make + " " + model + " (" + horsepower + " hp)";
    }
}