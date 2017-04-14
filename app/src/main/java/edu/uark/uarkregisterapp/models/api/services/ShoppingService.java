package edu.uark.uarkregisterapp.models.api.services;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import edu.uark.uarkregisterapp.models.api.Product;
import edu.uark.uarkregisterapp.models.api.ProductListing;
import edu.uark.uarkregisterapp.models.api.enums.ApiLevel;
import edu.uark.uarkregisterapp.models.api.enums.ProductApiMethod;
import edu.uark.uarkregisterapp.models.api.interfaces.PathElementInterface;

public class ShoppingService extends BaseRemoteService {
    public List<Product> getProducts() {
        List<Product> activities;
        JSONObject rawJsonObject = this.requestSingle(
                (new PathElementInterface[] { ProductApiMethod.PRODUCT, ApiLevel.ONE, ProductApiMethod.PRODUCTS })
        );

        if (rawJsonObject != null) {
            activities = (new ProductListing()).loadFromJson(rawJsonObject).getProducts();
        } else {
            activities = new ArrayList<>(0);
        }

        return activities;
    }
}