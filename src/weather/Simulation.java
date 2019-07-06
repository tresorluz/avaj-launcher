package weather;

import aircraft.AircraftFactory;
import aircraft.Flyable;

import java.io.*;


public class Simulation {

    public static WeatherTower weatherTower = new WeatherTower();




    public static void main(String[] args) {
        try{
            FileLogger.createSimulationFile("simulation.txt");
            BufferedReader reader = new BufferedReader(new FileReader("scenario.txt"));
            String line = reader.readLine();
            int i = 0;
            int height;
            if(line != null) {
                int simulations = Integer.parseInt(line.split(" ")[0]);
                if(simulations < 0){
                    System.out.println("Simulations value Incorrect: " + simulations);
                    System.exit(1);
                }

                while ((line = reader.readLine()) != null) {

                    String craftValues[] = line.split(" ");

                    if (craftValues.length == 0){
                        System.out.println("Error, Empty line");
                        System.exit(1);
                    } else if (craftValues.length !=  5){
                        System.out.println("Error, Invalid values for AirCraft" + line);
                        System.exit(1);
                    } else {
                        if((Integer.parseInt(craftValues[2]) > -1) && (Integer.parseInt(craftValues[3]) > -1) && (Integer.parseInt(craftValues[4]) > -1)){
                            height = (Integer.parseInt(craftValues[4]) > 101) ?  100 :  Integer.parseInt(craftValues[4]);

                            Flyable flyable = AircraftFactory.newAircarft(craftValues[0], craftValues[1], Integer.parseInt(craftValues[2]), Integer.parseInt(craftValues[3]), height);
                            weatherTower.register(flyable);
                        } else {
                            System.out.println("Error, Invalid coordinates" + line);
                            System.exit(1);
                        }
                    }
                }
                reader.close();

                while(i++ < simulations){
                    weatherTower.conditionsChanged();
                }
                return;
            } else
                System.out.println("Error, File '" + args[0] + "' is empty");
        }
        catch (FileNotFoundException e){
            System.out.println("Error could not find file : " + args[0]);
        } catch (IOException e) {
            System.out.println("There was an error reading file : " + args[0]);
        }
        catch (NumberFormatException e){
            System.out.println("Invalid number of simulations");
        }
    }
}

