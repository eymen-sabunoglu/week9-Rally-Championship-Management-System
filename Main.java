import java.util.List;

/**
 * Demonstrates the Rally Championship Management System.
 */
public class Main {
    public static void main(String[] args) {
        ChampionshipManager manager = ChampionshipManager.getInstance();

        RallyCar ogierCar = new GravelCar("Toyota", "GR Yaris Rally1", 380);
        RallyCar rovanperaCar = new GravelCar("Toyota", "GR Yaris Rally1", 385);
        RallyCar tanakCar = new GravelCar("Hyundai", "i20 N Rally1", 378);
        RallyCar neuvilleCar = new GravelCar("Ford", "Puma Rally1", 376);

        Driver ogier = new Driver("Sebastien Ogier", "France", ogierCar);
        Driver rovanpera = new Driver("Kalle Rovanpera", "Finland", rovanperaCar);
        Driver tanak = new Driver("Ott Tanak", "Estonia", tanakCar);
        Driver neuville = new Driver("Thierry Neuville", "Belgium", neuvilleCar);

        manager.registerDriver(ogier);
        manager.registerDriver(rovanpera);
        manager.registerDriver(tanak);
        manager.registerDriver(neuville);

        RallyRaceResult rallyFinland = new RallyRaceResult("Rally Finland", "Jyvaskyla", "Gravel");
        rallyFinland.recordResult(ogier, 1);
        rallyFinland.recordResult(tanak, 2);
        rallyFinland.recordResult(rovanpera, 3);
        rallyFinland.recordResult(neuville, 4);
        manager.addRaceResult(rallyFinland);

        ogier.setCar(new AsphaltCar("Toyota", "GR Yaris Rally1", 380));
        rovanpera.setCar(new AsphaltCar("Toyota", "GR Yaris Rally1", 385));
        tanak.setCar(new AsphaltCar("Hyundai", "i20 N Rally1", 378));
        neuville.setCar(new AsphaltCar("Ford", "Puma Rally1", 376));

        RallyRaceResult monteCarlo = new RallyRaceResult("Monte Carlo Rally", "Monaco", "Asphalt");
        monteCarlo.recordResult(rovanpera, 1);
        monteCarlo.recordResult(neuville, 2);
        monteCarlo.recordResult(ogier, 3);
        monteCarlo.recordResult(tanak, 4);
        manager.addRaceResult(monteCarlo);

        printStandings();
        printLeader();
        printStatistics(manager.getDrivers());
        printRaceResults(manager.getRaceResults());
        printPerformanceRatings();
    }

    private static void printStandings() {
        System.out.println("===== CHAMPIONSHIP STANDINGS =====");
        List<Driver> standings = ChampionshipManager.getChampionshipStandings();

        int position = 1;
        for (Driver driver : standings) {
            System.out.println(position + ". " + driver.getName() + " (" + driver.getCountry() + "): "
                    + driver.getTotalPoints() + " points");
            position++;
        }
        System.out.println();
    }

    private static void printLeader() {
        Driver leader = ChampionshipManager.getLeadingDriver();

        System.out.println("===== CHAMPIONSHIP LEADER =====");
        if (leader != null) {
            System.out.println(leader.getName() + " with " + leader.getTotalPoints() + " points");
        }
        System.out.println();
    }

    private static void printStatistics(List<Driver> drivers) {
        System.out.println("===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + Driver.getTotalDrivers());
        System.out.println("Total Races: " + ChampionshipStatistics.countTotalRacesHeld());
        System.out.printf("Average Points Per Driver: %.2f%n",
                ChampionshipStatistics.calculateAveragePointsPerDriver(drivers));
        System.out.println("Most Successful Country: "
                + ChampionshipStatistics.findMostSuccessfulCountry(drivers));
        System.out.println("Total Championship Points: "
                + ChampionshipManager.calculateTotalChampionshipPoints());
        System.out.println();
    }

    private static void printRaceResults(List<RaceResult> results) {
        System.out.println("===== RACE RESULTS =====");

        for (RaceResult result : results) {
            System.out.println("Race: " + result.getRaceName() + " (" + result.getLocation() + ") - "
                    + result.getSurface());

            for (Integer position : result.getRacePositions().keySet()) {
                Driver driver = result.getRacePositions().get(position);
                System.out.println(" Position " + position + ": " + driver.getName()
                        + " - " + result.getPointsForDriver(driver) + " points");
            }
        }
        System.out.println();
    }

    private static void printPerformanceRatings() {
        RallyCar gravelExample = new GravelCar("Toyota", "GR Yaris Rally1", 375);
        RallyCar asphaltExample = new AsphaltCar("Hyundai", "i20 N Rally1", 380);

        System.out.println("===== CAR PERFORMANCE RATINGS =====");
        System.out.printf("Gravel Car Performance: %.1f%n", gravelExample.calculatePerformance());
        System.out.printf("Asphalt Car Performance: %.1f%n", asphaltExample.calculatePerformance());
    }
}