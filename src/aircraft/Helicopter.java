package aircraft;

import weather.*;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower = Simulation.weatherTower;

    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);

        this.coordinates.setLatitude(coordinates.getLatitude());
        this.coordinates.setLongitude(coordinates.getLongitude());
        this.coordinates.setHeight(coordinates.getHeight());
        registerTower(weatherTower);
    }

    @Override
    public void updateConditions(){
        String weather = weatherTower.getWeather(this.coordinates);
        switch(weather) {

            case "RAIN":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                if (this.coordinates.getHeight() > 100) {
                    this.coordinates.setHeight(100);
                }
                Logger.log("Helicopter#" + this.name + "(" + this.id + ") Oh no, It's Raining again");
                break;
            case "FOG":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
                if (this.coordinates.getHeight() > 100) {
                    this.coordinates.setHeight(100);
                }
                Logger.log("Helicopter#" + this.name + "(" + this.id + ") It's too Foggy today!");
                break;
            case "SUN":
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                if (this.coordinates.getHeight() > 100) {
                    this.coordinates.setHeight(100);
                }
                Logger.log("Helicopter#" + this.name + "(" + this.id + ") What a beautiful and sunny day");
                break;
            case "SNOW":
                this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                if (this.coordinates.getHeight() > 100) {
                    this.coordinates.setHeight(100);
                }
                Logger.log("Helicopter#" + this.name + "(" + this.id + ") This snow makes it difficult to land!");
                break;
            default:
                return;
        }

        if(this.coordinates.getHeight() <= 0){
            Logger.log("Helicopter#" + this.name + "(" + this.id + ") Has landed");
            Logger.log("Tower says : Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower");
            weatherTower.unregister(this);
        }


    }

    public void registerTower(WeatherTower weatherTower){
        Logger.log("Tower says : Helicopter#" + this.name + "(" + this.id + ") registered to weather tower");

    }
}
