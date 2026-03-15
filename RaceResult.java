import java.util.Map;

/**
 * Abstraction for recording and reading race results.
 */
public interface RaceResult {
    void recordResult(Driver driver, int position);
    Map<Integer, Driver> getRacePositions();
    int getPointsForDriver(Driver driver);
    String getRaceName();
    String getLocation();
    String getSurface();
}