package dev.breje.fdasimpleclient.model.response.openfda;

import com.google.gson.annotations.SerializedName;
import dev.breje.fdasimpleclient.model.helper.ActiveIngredient;

import java.util.List;

public class OpenFdaProduct {

    @SerializedName("product_number")
    private String productNumber;

    @SerializedName("reference_drug")
    private String referenceDrug;

    @SerializedName("brand_name")
    private String brandName;

    @SerializedName("active_ingredients")
    private List<ActiveIngredient> activeIngredients;

    @SerializedName("reference_standard")
    private String referenceStandard;

    @SerializedName("dosage_form")
    private String dosageForm;

    private String route;

    @SerializedName("marketing_status")
    private String marketingStatus;

    @SerializedName("te_code")
    private String teCode;

    public String getProductNumber() {
        return productNumber;
    }

    public String getReferenceDrug() {
        return referenceDrug;
    }

    public String getBrandName() {
        return brandName;
    }

    public List<ActiveIngredient> getActiveIngredients() {
        return activeIngredients;
    }

    public String getReferenceStandard() {
        return referenceStandard;
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public String getRoute() {
        return route;
    }

    public String getMarketingStatus() {
        return marketingStatus;
    }

    public String getTeCode() {
        return teCode;
    }
}
