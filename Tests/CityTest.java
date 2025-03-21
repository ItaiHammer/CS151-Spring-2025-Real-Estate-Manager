package Tests;
import org.junit.jupiter.api.Test;

import RealEstateManager.City;
import RealEstateManager.House;
import RealEstateManager.ApartmentBuilding;

import static org.junit.jupiter.api.Assertions.*;

public class CityTest {

    @Test
    public void testToString() {
        City city = new City("TestCity", 10, 10);
        String expected = "City{name='TestCity'}";
        assertEquals(expected, city.toString());
    }

    @Test
    public void testAddProperty() {
        City city = new City("TestCity", 10, 10);
        House house = new House(city, "123 Main St", 100000, 2, 2, null);
        boolean result = city.addProperty(house, 0, 0);
        assertTrue(result);
        assertEquals(house, city.findProperty(0, 0));
    }

    @Test
    public void testAddPropertyOverlap() {
        City city = new City("TestCity", 10, 10);
        House house1 = new House(city, "123 Main St", 100000, 2, 2, null);
        House house2 = new House(city, "456 Elm St", 150000, 2, 2, null);
        city.addProperty(house1, 0, 0);
        boolean result = city.addProperty(house2, 1, 1);
        assertFalse(result);
    }

    @Test
    public void testRemoveProperty() {
        City city = new City("TestCity", 10, 10);
        House house = new House(city, "123 Main St", 100000, 2, 2, null);
        city.addProperty(house, 0, 0);
        boolean result = city.removeProperty(0, 0);
        assertTrue(result);
        assertNull(city.findProperty(0, 0));
    }

    @Test
    public void testRemovePropertyByObject() {
        City city = new City("TestCity", 10, 10);
        House house = new House(city, "123 Main St", 100000, 2, 2, null);
        city.addProperty(house, 0, 0);
        boolean result = city.removeProperty(house);
        assertTrue(result);
        assertNull(city.findProperty(0, 0));
    }

    @Test
    public void testFindPropertyByAddress() {
        City city = new City("TestCity", 10, 10);
        House house = new House(city, "123 Main St", 100000, 2, 2, null);
        house.setAddress("123 Main St");
        city.addProperty(house, 0, 0);
        House foundProperty = (House) city.findProperty("123 Main St");
        assertEquals(house, foundProperty);
    }

    @Test
    public void testFindPropertyByCoordinates() {
        City city = new City("TestCity", 10, 10);
        House house = new House(city, "123 Main St", 100000, 2, 2, null);
        city.addProperty(house, 0, 0);
        House foundProperty = (House) city.findProperty(0, 0);
        assertEquals(house, foundProperty);
    }

    @Test
    public void testDisplayGrid() {
        City city = new City("TestCity", 10, 10);
        House house = new House(city, "123 Main St", 100000, 2, 2, null);
        city.addProperty(house, 0, 0);
        city.displayGrid();
        // This test is for visual inspection, no assertions
    }

    @Test
    public void testApartmentBuilding() {
        City city = new City("TestCity", 10, 10);
        ApartmentBuilding building = new ApartmentBuilding("456 Elm St", 500000, 4, 4, null, 2, 2);
        boolean result = city.addProperty(building, 2, 2);
        assertTrue(result);
        assertEquals(building, city.findProperty(2, 2));
    }

    @Test
    public void testExpandHouse() {
        City city = new City("TestCity", 10, 10);
        House house = new House(city, "123 Main St", 100000, 2, 2, null);
        city.addProperty(house, 0, 0);
        boolean result = house.expand(3, 3);
        assertTrue(result);
        assertEquals(3, house.getWidth());
        assertEquals(3, house.getHeight());
    }

    @Test
    public void testExpandApartmentBuilding() {
        City city = new City("TestCity", 10, 10);
        ApartmentBuilding building = new ApartmentBuilding("456 Elm St", 500000, 4, 4, null, 2, 2);
        city.addProperty(building, 2, 2);
        boolean result = building.expand(5, 5);
        assertTrue(result);
        assertEquals(5, building.getWidth());
        assertEquals(5, building.getHeight());
    }
    
    @Test
    public void testSearchPropertiesEasy() {
        City city = new City("TestCity", 10, 10);
        ApartmentBuilding building = new ApartmentBuilding("456 Elm St", 500000, 4, 4, null, 2, 2);
        ApartmentBuilding building2 = new ApartmentBuilding("125 Elm St", 300000, 4, 4, null, 2, 2);
        city.addProperty(building, 2, 2);
        assertEquals(5, building.getWidth());
        assertEquals(5, building.getHeight());
    }
}