/**
 * Rally car specialized for gravel surfaces.
 */
public class GravelCar extends RallyCar {
    public GravelCar(String make, String model, int horsepower) {
        super(make, model, horsepower);
    }

    @Override
    public double calculatePerformance() {
        return getHorsepower() * 1.08 + 18.5;
    }
}