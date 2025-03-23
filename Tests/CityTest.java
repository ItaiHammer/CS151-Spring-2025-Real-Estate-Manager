package Tests;
import org.junit.jupiter.api.Test;

import RealEstateManager.City;
import RealEstateManager.House;
import RealEstateManager.ApartmentBuilding;
import RealEstateManager.SearchCriteria;
import RealEstateManager.RealEstate;
import RealEstateManager.PropertyNotFoundException;
import RealEstateManager.InvalidPropertyDimensionsException;
import RealEstateManager.PropertyAlreadyExistsException;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CityTest {

    @Test
    public void testToString() {
        City city = new City("TestCity", 10, 10);
        String expected = "City{name='TestCity'}";
        assertEquals(expected, city.toString());
    }

    @Test
    public void testAddProperty() throws InvalidPropertyDimensionsException, PropertyNotFoundException, PropertyAlreadyExistsException {
        City city = new City("TestCity", 10, 10);
        House house = new House("123 Main St", 100000, 2, 2, null);
        boolean result = city.addProperty(house, 0, 0);
        assertTrue(result);
        assertEquals(house, city.findProperty(0, 0));
    }

    @Test
    public void testAddPropertyOverlap() throws InvalidPropertyDimensionsException, PropertyAlreadyExistsException {
        City city = new City("TestCity", 10, 10);
        House house1 = new House("123 Main St", 100000, 2, 2, null);
        House house2 = new House("456 Elm St", 150000, 2, 2, null);
        city.addProperty(house1, 0, 0);
        boolean result = city.addProperty(house2, 1, 1);
        assertFalse(result);
    }

    @Test
    public void testAddPropertyAlreadyExists() throws InvalidPropertyDimensionsException, PropertyAlreadyExistsException {
        City city1 = new City("TestCity1", 10, 10);
        City city2 = new City("TestCity2", 10, 10);
        House house = new House("123 Main St", 100000, 2, 2, null);
        city1.addProperty(house, 0, 0);
        assertThrows(PropertyAlreadyExistsException.class, () -> city2.addProperty(house, 1, 1));
    }

    @Test
    public void testRemoveProperty() throws InvalidPropertyDimensionsException, PropertyNotFoundException, PropertyAlreadyExistsException {
        City city = new City("TestCity", 10, 10);
        House house = new House("123 Main St", 100000, 2, 2, null);
        city.addProperty(house, 0, 0);
        boolean result = city.removeProperty(0, 0);
        assertTrue(result);
        assertThrows(PropertyNotFoundException.class, () -> city.findProperty(0, 0));
    }

    @Test
    public void testRemovePropertyByObject() throws InvalidPropertyDimensionsException, PropertyNotFoundException, PropertyAlreadyExistsException {
        City city = new City("TestCity", 10, 10);
        House house = new House("123 Main St", 100000, 2, 2, null);
        city.addProperty(house, 0, 0);
        boolean result = city.removeProperty(house);
        assertTrue(result);
        assertThrows(PropertyNotFoundException.class, () -> city.findProperty(0, 0));
    }

    @Test
    public void testFindPropertyByAddress() throws InvalidPropertyDimensionsException, PropertyNotFoundException, PropertyAlreadyExistsException {
        City city = new City("TestCity", 10, 10);
        House house = new House("123 Main St", 100000, 2, 2, null);
        house.setAddress("123 Main St");
        city.addProperty(house, 0, 0);
        House foundProperty = (House) city.findProperty("123 Main St");
        assertEquals(house, foundProperty);
    }

    @Test
    public void testFindPropertyByCoordinates() throws InvalidPropertyDimensionsException, PropertyNotFoundException, PropertyAlreadyExistsException {
        City city = new City("TestCity", 10, 10);
        House house = new House("123 Main St", 100000, 2, 2, null);
        city.addProperty(house, 0, 0);
        House foundProperty = (House) city.findProperty(0, 0);
        assertEquals(house, foundProperty);
    }

    @Test
    public void testDisplayGrid() throws InvalidPropertyDimensionsException, PropertyAlreadyExistsException {
        City city = new City("TestCity", 10, 10);
        House house = new House("123 Main St", 100000, 2, 2, null);
        city.addProperty(house, 0, 0);
        city.displayGrid();
        // This test is for visual inspection, no assertions
    }

    @Test
    public void testApartmentBuilding() throws InvalidPropertyDimensionsException, PropertyNotFoundException, PropertyAlreadyExistsException {
        City city = new City("TestCity", 10, 10);
        ApartmentBuilding building = new ApartmentBuilding("456 Elm St", 500000, 4, 4, null, 2, 2);
        boolean result = city.addProperty(building, 2, 2);
        assertTrue(result);
        assertEquals(building, city.findProperty(2, 2));
    }

    @Test
    public void testExpandHouse() throws InvalidPropertyDimensionsException, PropertyNotFoundException, PropertyAlreadyExistsException {
        City city = new City("TestCity", 10, 10);
        House house = new House("123 Main St", 100000, 2, 2, null);
        city.addProperty(house, 0, 0);
        boolean result = house.expand(3, 3);
        assertTrue(result);
        assertEquals(3, house.getWidth());
        assertEquals(3, house.getHeight());
    }

    @Test
    public void testExpandApartmentBuilding() throws InvalidPropertyDimensionsException, PropertyNotFoundException, PropertyAlreadyExistsException {
        City city = new City("TestCity", 10, 10);
        ApartmentBuilding building = new ApartmentBuilding("456 Elm St", 500000, 4, 4, null, 2, 2);
        city.addProperty(building, 2, 2);
        boolean result = building.expand(5, 5);
        assertTrue(result);
        assertEquals(5, building.getWidth());
        assertEquals(5, building.getHeight());
    }
    
    @Test
    public void testSearchPropertiesEasy() throws InvalidPropertyDimensionsException, PropertyAlreadyExistsException {
        City city = new City("TestCity", 10, 10);
        ApartmentBuilding building = new ApartmentBuilding("456 Elm St", 500000, 4, 4, null, 2, 2);
        ApartmentBuilding building2 = new ApartmentBuilding("125 Elm St", 300000, 4, 4, null, 2, 2);
        city.addProperty(building, 2, 2);
        city.addProperty(building2, 6, 0);

        SearchCriteria criteria = new SearchCriteria();
        criteria.setMaxPrice(400000.0);

        Set<RealEstate> results = city.searchProperties(criteria);
        assertEquals(1, results.size());
        assertTrue(results.contains(building2));
    }

    @Test
    public void testSearchPropertiesByStyle() throws InvalidPropertyDimensionsException, PropertyAlreadyExistsException {
        City city = new City("TestCity", 10, 10);
        House house = new House("123 Main St", 100000, 2, 2, null);
        house.setStyle("Victorian");
        ApartmentBuilding building = new ApartmentBuilding("456 Elm St", 500000, 4, 4, null, 2, 2);
        building.setStyle("Modern");
        city.addProperty(house, 0, 0);
        city.addProperty(building, 2, 2);

        SearchCriteria criteria = new SearchCriteria();
        criteria.setStyle("Victorian");

        Set<RealEstate> results = city.searchProperties(criteria);
        assertEquals(1, results.size());
        assertTrue(results.contains(house));
    }

    @Test
    public void testSearchPropertiesWithMultipleCriteria() throws InvalidPropertyDimensionsException, PropertyAlreadyExistsException {
        City city = new City("TestCity", 10, 10);
        House house = new House("123 Main St", 100000, 2, 2, null);
        house.setStyle("Victorian");
        ApartmentBuilding building = new ApartmentBuilding("456 Elm St", 500000, 4, 4, null, 2, 2);
        building.setStyle("Modern");
        city.addProperty(house, 0, 0);
        city.addProperty(building, 2, 2);

        SearchCriteria criteria = new SearchCriteria();
        criteria.setMaxPrice(200000.0);
        criteria.setStyle("Victorian");

        Set<RealEstate> results = city.searchProperties(criteria);
        assertEquals(1, results.size());
        assertTrue(results.contains(house));
    }
}