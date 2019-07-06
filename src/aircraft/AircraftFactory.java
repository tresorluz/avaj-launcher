package aircraft;

public class AircraftFactory {

    public static Flyable newAircarft(String type, String name, int longitude, int latitude, int height){

        Coordinates coordinates = new Coordinates(longitude,latitude, height);

        if(type.compareToIgnoreCase("baloon") == 0){
            return new Baloon(name, coordinates);
        } else if (type.compareToIgnoreCase("helicopter") == 0){
            return new Helicopter(name, coordinates);
        } else if (type.compareToIgnoreCase("jetplane") == 0){
            return new JetPlane(name, coordinates);
        } else {
            return null;
        }
    }
}
