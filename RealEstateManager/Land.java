package RealEstateManager;

public class Land {
    private OccupiesLand occupiedBy;

    public Land() {
        occupiedBy = null;
    }

    public void setOccupiedBy(OccupiesLand p) {
        occupiedBy = p;
    }

    public OccupiesLand getOccupiedBy() {
        return occupiedBy;
    }
}
