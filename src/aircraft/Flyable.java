package aircraft;

import weather.*;

public interface Flyable {

    void updateConditions();

    void registerTower(WeatherTower weatherTower);

}
