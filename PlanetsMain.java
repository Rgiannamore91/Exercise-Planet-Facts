package planets;
/**
 * PlanetMain - An application which uses Generic Collections to sort information about planets
 * 
 */ 
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/** 
 * Prints facts about planets - practice using Collections methods
 */
public class PlanetsMain {

    public static void main(String[] args) {
    	// Adds each planet to ArrayList
        // Source https://nssdc.gsfc.nasa.gov/planetary/factsheet/
        List<Planet> planets = new ArrayList<>(9);
        planets.add(new Planet("Mercury", 0.33, 58));
        planets.add(new Planet("Venus", 4.87, 108));
        planets.add(new Planet("Earth", 5.97, 150));
        planets.add(new Planet("Mars", .642, 228));
        planets.add(new Planet("Jupiter", 1898, 779));
        planets.add(new Planet("Saturn", 568, 1434));
        planets.add(new Planet("Uranus", 86.8, 2873));
        planets.add(new Planet("Neptune", 102, 4495));
        planets.add(new Planet("Pluto", 0.0146, 5906));

        System.out.println("Orignal order:");
        printPlanets(planets);

        // Randomizes items in "planets"
        Collections.shuffle(planets);
        
        System.out.println("Planets in a random order:");
        printPlanets(planets);

        // Removes Pluto from "planets"
        Iterator<Planet> i = planets.iterator();
        Planet item;
        while(i.hasNext()) {
        	item = (Planet) i.next();
        	if (item.getName().equals("Pluto")) {
        		i.remove();
        	}
        }
   
        System.out.println("Removed Pluto:");
        printPlanets(planets);

        // Sort by distance from sun using Natural Ordering 
        Collections.sort(planets);

        System.out.println("Sorted by distance from sun:");
        printPlanets(planets);

        // Sort alphabetically
        SortAlphabetically Alph = new SortAlphabetically();
        Collections.sort(planets, Alph);
        
        System.out.println("Sorted alphabetically:");
        printPlanets(planets);

        // Sort by mass (Hint: you need a Comparator class)
        // TODO
    
        Collections.sort(planets, new Comparator<Planet>(){
        	public int compare(Planet planet1, Planet planet2) {
        		
        		if (planet1.getMass() > planet2.getMass()) {
        			return 1;
        		}
        		else if (planet1.getMass() < planet2.getMass()) {
        			return -1;
        		}
        		else {
        			return 0;
        		}
        	}
        });
        System.out.println("Sorted by mass:");
        printPlanets(planets);

        // Add each planet in your list to a Map (name => Planet)
        Map<String, Planet> planetMap = new HashMap<>();
        // Hint - use an enhanced for loop
        
        for (Planet planet : planets) {
        	planetMap.put(planet.getName(), planet);
        }
        

        System.out.println("Earth:" + planetMap.get("Earth"));
        // Retrieve and print Mars
        System.out.println("Mars:" + planetMap.get("Mars"));

    }

    /**
     * Print the planet list in a table
     */
    private static void printPlanets(List<Planet> planets) {

        System.out.println("------------------------------------------------------------");
        System.out.printf("%-10s%-15s%-10s%n%n", "Planet", "Mass", "Distance");

        for (Planet planet : planets) {
            System.out.printf("%-10s%-15.3f%-10d%n", planet.getName(),
                    planet.getMass(), planet.getDistance());
        }

        System.out.println("------------------------------------------------------------\n\n");
    }

}
