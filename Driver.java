/**
 * Represents a rally driver in the championship.
 */
public class Driver {
    private static int totalDrivers = 0;

    private String name;
    private String country;
    private int totalPoints;
    private RallyCar car;

    /**
     * Creates a driver and injects the current car for the driver.
     */
    public Driver(String name, String country, RallyCar car) {
        this.name = name;
        this.country = country;
        this.car = car;
        this.totalPoints = 0;
        totalDrivers++;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public RallyCar getCar() {
        return car;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCar(RallyCar car) {
        this.car = car;
    }

    /**
     * Adds championship points to the driver.
     */
    public void addPoints(int points) {
        if (points > 0) {
            totalPoints += points;
        }
    }

    public static int getTotalDrivers() {
        return totalDrivers;
    }

    @Override
    public String toString() {
        return name + " (" + country + ")";
    }
} 
    

