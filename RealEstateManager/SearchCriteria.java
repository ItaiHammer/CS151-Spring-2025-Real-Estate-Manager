package RealEstateManager;

public class SearchCriteria {
    private Double maxPrice;
    private Integer minSize;
    private Boolean forSale;
    private Boolean forRent;
    private Boolean hasYard;
    private Boolean hasPool;
    private String style;

    public SearchCriteria() {
        this.maxPrice = null;
        this.minSize = null;
        this.forSale = null;
        this.forRent = null;
        this.hasYard = null;
        this.hasPool = null;
        this.style = null;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getMinSize() {
        return minSize;
    }

    public void setMinSize(Integer minSize) {
        this.minSize = minSize;
    }

    public Boolean getForSale() {
        return forSale;
    }

    public void setForSale(Boolean forSale) {
        this.forSale = forSale;
    }

    public Boolean getForRent() {
        return forRent;
    }

    public void setForRent(Boolean forRent) {
        this.forRent = forRent;
    }

    public Boolean getHasYard() {
        return hasYard;
    }

    public void setHasYard(Boolean hasYard) {
        this.hasYard = hasYard;
    }

    public Boolean getHasPool() {
        return hasPool;
    }

    public void setHasPool(Boolean hasPool) {
        this.hasPool = hasPool;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String toString() {
        return "SearchCriteria{" + 
                "maxPrice =" + maxPrice +
                ", minSize=" + minSize +
                ", forSale=" + forSale +
                ", forRent=" + forRent +
                ", hasYard=" + hasYard +
                ", hasPool=" + hasPool +
                ", style=" + style +
                "}";
    }
}
