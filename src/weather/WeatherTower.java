package weather;

import aircraft.*;

public class WeatherTower extends Tower{

    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getWeatherProvider().getCurrentWeather(coordinates);
    }
}
