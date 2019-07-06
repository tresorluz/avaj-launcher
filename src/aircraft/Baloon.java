package aircraft;

import weather.*;

public class Baloon  extends Aircraft implements Flyable {

    private WeatherTower weatherTower = Simulation.weatherTower;

    Baloon(String name, Coordinates coordinates){
        super(name, coordinates);

        this.coordinates.setLatitude(coordinates.getLatitude());
        this.coordinates.setLongitude(coordinates.getLongitude());
        this.coordinates.setHeight(coordinates.getHeight());
        registerTower(weatherTower);

    }

    @Override
    public void updateConditions(){

        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "RAIN":
                this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                if (this.coordinates.getHeight() > 100) {
                    this.coordinates.setHeight(100);
                }
                FileLogger.log("Baloon#" + this.name + "(" + this.id + ") This Rain is too much!!");
                break;
            case "FOG":
                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                if (this.coordinates.getHeight() > 100) {
                    this.coordinates.setHeight(100);
                }
                FileLogger.log("Baloon#" + this.name + "(" + this.id + ") It's Foggy i can't see clearly");
                break;
            case "SUN":
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                if (this.coordinates.getHeight() > 100) {
                    this.coordinates.setHeight(100);
                }
                FileLogger.log("Baloon#" + this.name + "(" + this.id + ") Finally it's Sunny today");
                break;
            case "SNOW":
                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                if (this.coordinates.getHeight() > 100) {
                    this.coordinates.setHeight(100);
                }
                FileLogger.log("Baloon#" + this.name + "(" + this.id + ") This Snow is too much and i'm freezing ");
                break;
            default:
                break;
        }
        if(this.coordinates.getHeight() <= 0){
            FileLogger.log("Baloon#" + this.name + "(" + this.id + ") Has landed successfully");
            FileLogger.log("Tower says : Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower");
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower){
        FileLogger.log("Tower says : Baloon#" + this.name + "(" + this.id + ") registered to weather tower");
    }
}
