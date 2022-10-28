package dev.breje.fdasimpleclient.model.response;

import dev.breje.fdasimpleclient.model.entity.DrugRecordEntity;
import dev.breje.fdasimpleclient.model.entity.ProductEntity;
import dev.breje.fdasimpleclient.model.entity.ProductsOfDrugRecordEntity;
import dev.breje.fdasimpleclient.model.helper.Product;
import dev.breje.fdasimpleclient.model.helper.SimpleProduct;
import dev.breje.fdasimpleclient.model.response.openfda.OpenFdaApiResponse;
import dev.breje.fdasimpleclient.model.response.openfda.OpenFdaProduct;
import dev.breje.fdasimpleclient.model.response.openfda.OpenFdaResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class DomainObjectsConverter {

    public static List<DrugRecordDto> fromDrugRecordEntities(List<DrugRecordEntity> drugRecordEntities) {
        List<DrugRecordDto> drugRecords = new ArrayList<>();
        for (DrugRecordEntity drugRecordEntity : drugRecordEntities) {
            drugRecords.add(fromDrugRecordEntity(drugRecordEntity));
        }
        return drugRecords;
    }

    public static DrugRecordDto fromDrugRecordEntity(DrugRecordEntity drugRecordEntity) {
        DrugRecordDto drugRecord = new DrugRecordDto();
        drugRecord.setApplicationNumber(drugRecordEntity.getApplicationNumber());
        drugRecord.setManufacturerName(drugRecordEntity.getManufacturerName());
        drugRecord.setSubstanceName(drugRecordEntity.getSubstanceName());
        drugRecord.setProducts(fromProductEntities(drugRecordEntity.getProducts()));
        return drugRecord;
    }

    private static List<SimpleProduct> fromProductEntities(Set<ProductsOfDrugRecordEntity> productsOfDrugRecordEntities) {
        List<SimpleProduct> products = new ArrayList<>();
        for (ProductsOfDrugRecordEntity productsOfDrugRecord : productsOfDrugRecordEntities) {
            products.add(fromProductEntity(productsOfDrugRecord.getProduct()));
        }
        return products;
    }

    private static SimpleProduct fromProductEntity(ProductEntity productEntity) {
        SimpleProduct simpleProduct = new SimpleProduct();
        simpleProduct.setProductNumber(productEntity.getNumber());
        return simpleProduct;
    }

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
        apiResponse.setErrorMessage(openFdaResponse.getError()
                                                   .getCode() + " : " + openFdaResponse.getError()
                                                                                       .getMessage());
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
        product.setActiveIngredients(openFdaProduct.getActiveIngredients());
        return product;
    }

}
