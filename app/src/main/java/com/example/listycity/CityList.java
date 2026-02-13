package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * this is a class keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * this add a city to the list if the city doesn't exist.
     * @param city
     *  this is a candiaite city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already exists");
        } else {
            cities.add(city);
        }
    }

    /**
     * Gets the list of cities sorted by city name
     * @return List of cities
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Checks if a city is in the list
     * @param city
     *  the city to check
     * @return true if the city is in the list, false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes a city from the list
     * @param city
     *  the city to delete
     * @throws IllegalArgumentException if the city is not in the list
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not found in the list");
        }
        cities.remove(city);
    }

    /**
     * Returns the number of cities in the list
     * @return the number of cities in the list
     */
    public int countCities() {
        return cities.size();
    }
}