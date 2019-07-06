package aircraft;

import weather.*;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower = Simulation.weatherTower;

    JetPlane(String name, Coordinates coordinates){
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
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                if (this.coordinates.getHeight() > 100) {
                    this.coordinates.setHeight(100);
                }
                FileLogger.log("JetPlane#" + this.name + "(" + this.id + ") This rain won't stop?");
                break;
            case "FOG":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                if (this.coordinates.getHeight() > 100) {
                    this.coordinates.setHeight(100);
                }
                FileLogger.log("JetPlane#" + this.name + "(" + this.id + ") It's too foggy these days!!");
                break;
            case "SUN":
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                if (this.coordinates.getHeight() > 100) {
                    this.coordinates.setHeight(100);
                }
                FileLogger.log("JetPlane#" + this.name + "(" + this.id + ") Wow the sun is shining brighter today");
                break;
            case "SNOW":
                this.coordinates.setHeight(this.coordinates.getHeight() - 7);
                if (this.coordinates.getHeight() > 100) {
                    this.coordinates.setHeight(100);
                }
                FileLogger.log("JetPlane#" + this.name + "(" + this.id + ") This snow is unbearable.");
                break;
            default:
                return;
        }

        if(this.coordinates.getHeight() <= 0){
            FileLogger.log("JetPlane#" + this.name + "(" + this.id + ") Has landed");
            FileLogger.log("Tower says : JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower");
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower){
        FileLogger.log("Tower says : JetPlane#" + this.name + "(" + this.id + ") registered to weather tower");
    }
}
