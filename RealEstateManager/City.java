package RealEstateManager;

import java.util.HashSet;
import java.util.Set;

public class City {
    private String name;
    private Land[][] grid;

    public City(String name, int width, int height) {
        this.name = name;
        grid = new Land[width][height];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Land();
            }
        }
    }

    public Land[][] getGrid() {
        return grid;
    }

    public boolean addProperty(OccupiesLand o, int x, int y) throws InvalidPropertyDimensionsException {
        RealEstate r = (RealEstate) o;
        
        if (x <= 0 || y <= 0) {
            throw new InvalidPropertyDimensionsException("Invalid dimensions for adding the property: The width and height must be positive and within the city's grid limits.");
        }

        // checking it doesn't overlap with another property
        for (int i = x; i < x + r.getWidth(); i++) {
            for (int j = y; j < y + r.getHeight(); j++) {
                if (grid[i][j].getOccupiedBy() != null) {
                	throw new InvalidPropertyDimensionsException("Invalid dimensions for adding the property: The new width and height must not overlap another property.");
                }
            }
        }

        // allocating land for the property
        for (int i = x; i < x + r.getWidth(); i++) {
            for (int j = y; j < y + r.getHeight(); j++) {
                grid[i][j].setOccupiedBy(o);
            }
        }

        // Set the city information
        r.setLocation(x, y);
        r.setCity(this);

        return true;
    }

    public boolean removeProperty(int x, int y) {
        try {
            RealEstate realEstate = findProperty(x, y);
            int[] location = realEstate.getLocation();
            int topLeftX = location[0];
            int topLeftY = location[1];

            for (int i = topLeftX; i < topLeftX + realEstate.getWidth(); i++) {
                for (int j = topLeftY; j < topLeftY + realEstate.getHeight(); j++) {
                    grid[i][j].setOccupiedBy(null);
                }
            }
            return true;
        } catch (PropertyNotFoundException e) {
            return false;
        }
    }

    public boolean removeProperty(OccupiesLand o) {
        RealEstate realEstate = (RealEstate) o;
        int[] location = realEstate.getLocation();
        return removeProperty(location[0], location[1]);
    }

    public void displayGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].getOccupiedBy() == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(grid[i][j].getOccupiedBy());
                }
            }
            System.out.println();
        }
    }

    public RealEstate findProperty(int x, int y) throws PropertyNotFoundException {
        RealEstate property = (RealEstate) grid[x][y].getOccupiedBy();
        if (property == null) {
            throw new PropertyNotFoundException("Property not found at coordinates (" + x + ", " + y + ")");
        }
        return property;
    }

    public RealEstate findProperty(String address) throws PropertyNotFoundException {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                RealEstate r = (RealEstate) grid[i][j].getOccupiedBy();
                if (r != null && r.getAddress().equals(address)) {
                    return r;
                }
            }
        }
        throw new PropertyNotFoundException("Property not found with address: " + address);
    }

    public Set<RealEstate> searchProperties(SearchCriteria criteria) {
        Set<RealEstate> results = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                RealEstate r = (RealEstate) grid[i][j].getOccupiedBy();

                if (r != null && !results.contains(r) &&
                    (criteria.getMaxPrice() == null || r.getPrice() <= criteria.getMaxPrice()) &&
                    (criteria.getMinSize() == null || r.getArea() >= criteria.getMinSize()) &&
                    (criteria.getForSale() == null || r.isForSale() == criteria.getForSale()) &&
                    (criteria.getForRent() == null || r.isForRent() == criteria.getForRent()) &&
                    (criteria.getHasYard() == null || r.hasYard() == criteria.getHasYard()) &&
                    (criteria.getHasPool() == null || r.hasPool() == criteria.getHasPool()) &&
                    (criteria.getStyle() == null || r.getStyle().equals(criteria.getStyle()))) {
                    results.add(r);
                }
            }
        }

        return results;
    }

    @Override
    public String toString() {
        return "City{name='" + name + "'}";
    }
}
