package com.example.listycity;


import static org.junit.Assert.*;

import org.junit.Test;

public class CityListTest {

    /**
     * Creates and returns a mock CityList with one city
     * @return CityList with Edmonton added
     */
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    /**
     * Creates and returns a mock City object
     * @return City object for Edmonton, Alberta
     */
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    /**
     * Test adding cities to the list
     */
    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    /**
     * Test that adding a duplicate city throws an exception
     */
    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * Test getting cities and verify sorting order
     */
    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();

        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
}