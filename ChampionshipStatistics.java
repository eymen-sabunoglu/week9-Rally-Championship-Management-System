import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class for championship statistics.
 */
public final class ChampionshipStatistics {
    private ChampionshipStatistics() {
    }

    public static double calculateAveragePointsPerDriver(List<Driver> drivers) {
        if (drivers == null || drivers.isEmpty()) {
            return 0.0;
        }

        int total = 0;
        for (Driver driver : drivers) {
            total += driver.getTotalPoints();
        }

        return (double) total / drivers.size();
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        if (drivers == null || drivers.isEmpty()) {
            return "No data";
        }

        Map<String, Integer> countryPoints = new HashMap<>();

        for (Driver driver : drivers) {
            String country = driver.getCountry();
            int currentPoints = countryPoints.getOrDefault(country, 0);
            countryPoints.put(country, currentPoints + driver.getTotalPoints());
        }

        String bestCountry = "No data";
        int bestPoints = -1;

        for (Map.Entry<String, Integer> entry : countryPoints.entrySet()) {
            if (entry.getValue() > bestPoints) {
                bestPoints = entry.getValue();
                bestCountry = entry.getKey();
            }
        }

        return bestCountry;
    }

    public static int countTotalRacesHeld() {
        return RallyRaceResult.getTotalRaces();
    }
}