package aircraft;

public class Coordinates {

    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height){
        setLongitude(longitude);
        setLatitude(latitude);
        setHeight(height);

    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }
}
