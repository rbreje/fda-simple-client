package dev.breje.fdasimpleclient.model;

import dev.breje.fdasimpleclient.model.openfda.response.OpenFdaActiveIngredient;
import dev.breje.fdasimpleclient.model.openfda.response.OpenFdaApiResponse;
import dev.breje.fdasimpleclient.model.openfda.response.OpenFdaProduct;
import dev.breje.fdasimpleclient.model.openfda.response.OpenFdaResult;
import dev.breje.fdasimpleclient.model.response.ActiveIngredient;
import dev.breje.fdasimpleclient.model.response.ApiResponse;
import dev.breje.fdasimpleclient.model.response.Product;
import dev.breje.fdasimpleclient.model.response.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResponseConverter {

    public static ApiResponse fromOpenFdaApiResponse(OpenFdaApiResponse openFdaApiResponse) {
        if (openFdaApiResponse.isSuccess()) {
            return fromSuccessfulOpenFdaApiResponse(openFdaApiResponse);
        }
        return fromErrorOpenFdaApiResponse(openFdaApiResponse);
    }

    private static ApiResponse fromSuccessfulOpenFdaApiResponse(OpenFdaApiResponse openFdaResponse) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setResults(fromOpenFdaResults(openFdaResponse.getResults()));
        apiResponse.setTotal(openFdaResponse.getTotalOccurrences());
        return apiResponse;
    }

    private static ApiResponse fromErrorOpenFdaApiResponse(OpenFdaApiResponse openFdaResponse) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setErrorMessage(openFdaResponse.getError().getCode() + " : " + openFdaResponse.getError().getMessage());
        return apiResponse;
    }

    private static List<Result> fromOpenFdaResults(List<OpenFdaResult> openFdaResults) {
        List<Result> results = new ArrayList<>();
        for (OpenFdaResult openFdaResult : openFdaResults) {
            results.add(fromOpenFdaResult(openFdaResult));
        }
        return results;
    }

    private static Result fromOpenFdaResult(OpenFdaResult openFdaResult) {
        Result result = new Result();
        result.setApplicationNumber(openFdaResult.getApplicationNumber());
        result.setProducts(fromOpenFdaProducts(openFdaResult.getProducts()));
        return result;
    }

    private static List<Product> fromOpenFdaProducts(List<OpenFdaProduct> openFdaProducts) {
        List<Product> products = new ArrayList<>();
        if (Objects.nonNull(openFdaProducts)) {
            for (OpenFdaProduct openFdaProduct : openFdaProducts) {
                products.add(fromOpenFdaProduct(openFdaProduct));
            }
        }
        return products;
    }

    private static Product fromOpenFdaProduct(OpenFdaProduct openFdaProduct) {
        Product product = new Product();
        product.setProductNumber(openFdaProduct.getProductNumber());
        product.setBrandName(openFdaProduct.getBrandName());
        product.setRoute(openFdaProduct.getRoute());
        product.setMarketingStatus(openFdaProduct.getMarketingStatus());
        product.setActiveIngredients(fromOpenFdaActiveIngredients(openFdaProduct.getActiveIngredients()));
        return product;
    }

    private static List<ActiveIngredient> fromOpenFdaActiveIngredients(List<OpenFdaActiveIngredient> openFdaActiveIngredients) {
        List<ActiveIngredient> activeIngredients = new ArrayList<>();
        for (OpenFdaActiveIngredient openFdaActiveIngredient : openFdaActiveIngredients) {
            activeIngredients.add(fromOpenFdaActiveIngredient(openFdaActiveIngredient));
        }
        return activeIngredients;
    }

    private static ActiveIngredient fromOpenFdaActiveIngredient(OpenFdaActiveIngredient openFdaActiveIngredient) {
        ActiveIngredient activeIngredient = new ActiveIngredient();
        activeIngredient.setName(openFdaActiveIngredient.getName());
        activeIngredient.setStrength(openFdaActiveIngredient.getStrength());
        return activeIngredient;
    }

}
