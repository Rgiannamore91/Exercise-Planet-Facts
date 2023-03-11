package planets;
/**
 * PlanetMain - A Supplementary comparator class that sorts the planets alphabetically
 * Copyright 2023 Howard Community College
 * @author Ryan Giannamore
 * @version 1.0
 */ 
import java.util.Comparator;
public class SortAlphabetically implements Comparator<Planet>{
	@Override
	public int compare(Planet planet1, Planet planet2){
		
		return planet1.getName().compareTo(planet2.getName());
	}
}