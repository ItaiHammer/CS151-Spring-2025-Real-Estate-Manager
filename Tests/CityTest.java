package Tests;
import org.junit.jupiter.api.Test;

import RealEstateManager.City;
import RealEstateManager.RealEstate;

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
        RealEstate property = new RealEstate("Property1", 2, 2); //replace real estate with a non abstract real estate class
        boolean result = city.addProperty(property, 0, 0);
        assertTrue(result);
        assertEquals(property, city.findProperty(0, 0));
    }

    @Test
    public void testAddPropertyOverlap() {
        City city = new City("TestCity", 10, 10);
        RealEstate property1 = new RealEstate("Property1", 2, 2); //replace real estate with a non abstract real estate class
        RealEstate property2 = new RealEstate("Property2", 2, 2); //replace real estate with a non abstract real estate class
        city.addProperty(property1, 0, 0);
        boolean result = city.addProperty(property2, 1, 1);
        assertFalse(result);
    }

    @Test
    public void testRemoveProperty() {
        City city = new City("TestCity", 10, 10);
        RealEstate property = new RealEstate("Property1", 2, 2); //replace real estate with a non abstract real estate class
        city.addProperty(property, 0, 0);
        boolean result = city.removeProperty(0, 0);
        assertTrue(result);
        assertNull(city.findProperty(0, 0));
    }

    @Test
    public void testRemovePropertyByObject() {
        City city = new City("TestCity", 10, 10);
        RealEstate property = new RealEstate("Property1", 2, 2); //replace real estate with a non abstract real estate class
        city.addProperty(property, 0, 0);
        boolean result = city.removeProperty(property);
        assertTrue(result);
        assertNull(city.findProperty(0, 0));
    }

    @Test
    public void testFindPropertyByAddress() {
        City city = new City("TestCity", 10, 10);
        RealEstate property = new RealEstate("Property1", 2, 2); //replace real estate with a non abstract real estate class
        property.setAddress("123 Main St");
        city.addProperty(property, 0, 0);
        RealEstate foundProperty = city.findProperty("123 Main St");
        assertEquals(property, foundProperty);
    }

    @Test
    public void testFindPropertyByCoordinates() {
        City city = new City("TestCity", 10, 10);
        RealEstate property = new RealEstate("Property1", 2, 2); //replace real estate with a non abstract real estate class
        city.addProperty(property, 0, 0);
        RealEstate foundProperty = city.findProperty(0, 0);
        assertEquals(property, foundProperty);
    }

    @Test
    public void testDisplayGrid() {
        City city = new City("TestCity", 10, 10);
        RealEstate property = new RealEstate("Property1", 2, 2); //replace real estate with a non abstract real estate class
        city.addProperty(property, 0, 0);
        city.displayGrid();
        // This test is for visual inspection, no assertions
    }
}