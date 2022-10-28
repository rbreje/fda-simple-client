package dev.breje.fdasimpleclient.model.helper;

import java.util.ArrayList;
import java.util.List;

public class Product extends SimpleProduct {

    private String brandName;
    private List<ActiveIngredient> activeIngredients = new ArrayList<>();
    private String route;
    private String marketingStatus;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<ActiveIngredient> getActiveIngredients() {
        return activeIngredients;
    }

    public void setActiveIngredients(List<ActiveIngredient> activeIngredients) {
        this.activeIngredients = activeIngredients;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getMarketingStatus() {
        return marketingStatus;
    }

    public void setMarketingStatus(String marketingStatus) {
        this.marketingStatus = marketingStatus;
    }
}
