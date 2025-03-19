package RealEstateManager;

public class Land {
    private OccupiesLand occupiedBy;

    public Land() {
        occupiedBy = null;
    }

    public void setOccupiedBy(OccupiesLand o) {
        occupiedBy = o;
    }

    public OccupiesLand getOccupiedBy() {
        return occupiedBy;
    }
}
