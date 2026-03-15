import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Stores results for one rally race.
 */
public class RallyRaceResult implements RaceResult {
    private static int totalRaces = 0;

    private String raceName;
    private String location;
    private String surface;
    private Map<Integer, Driver> racePositions;

    public RallyRaceResult(String raceName, String location, String surface) {
        this.raceName = raceName;
        this.location = location;
        this.surface = surface;
        this.racePositions = new LinkedHashMap<>();
        totalRaces++;
    }

    @Override
    public void recordResult(Driver driver, int position) {
        if (driver == null || position < 1) {
            return;
        }

        racePositions.put(position, driver);
        driver.addPoints(calculatePoints(position));
    }

    @Override
    public Map<Integer, Driver> getRacePositions() {
        return Collections.unmodifiableMap(racePositions);
    }

    @Override
    public int getPointsForDriver(Driver driver) {
        for (Map.Entry<Integer, Driver> entry : racePositions.entrySet()) {
            if (entry.getValue().equals(driver)) {
                return calculatePoints(entry.getKey());
            }
        }
        return 0;
    }

    @Override
    public String getRaceName() {
        return raceName;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public String getSurface() {
        return surface;
    }

    public static int getTotalRaces() {
        return totalRaces;
    }

    private int calculatePoints(int position) {
        switch (position) {
            case 1:
                return 25;
            case 2:
                return 18;
            case 3:
                return 15;
            case 4:
                return 12;
            case 5:
                return 10;
            case 6:
                return 8;
            case 7:
                return 6;
            case 8:
                return 4;
            case 9:
                return 2;
            case 10:
                return 1;
            default:
                return 0;
        }
    }
}