package aircraft;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    protected  Aircraft(String name, Coordinates coordinates){
        this.coordinates = coordinates;
        this.name = name;
        this.id = idCounter;
        nextId();
    }

    private long nextId(){
        if(idCounter == 0) {
            return (idCounter++);
        }
        idCounter += 1;
        return idCounter;
    }
}
