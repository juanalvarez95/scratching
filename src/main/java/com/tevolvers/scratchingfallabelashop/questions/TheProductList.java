package com.tevolvers.scratchingfallabelashop.questions;

import com.google.gson.JsonArray;
import com.tevolvers.scratchingfallabelashop.models.Product;
import com.tevolvers.scratchingfallabelashop.user_interface.SearchComponent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TheProductList implements Question<List<Product>> {

    @Override
    public List<Product> answeredBy(Actor actor) {
        List<String> productNames = actor.asksFor(Text.of(SearchComponent.PRODUCT_NAME).asAList());
        List<String> productPrices = actor.asksFor(Text.of(SearchComponent.PRODUCT_PRICE).asAList());
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < productNames.size(); i++) {
            products.add(new Product(productNames.get(i), productPrices.get(i)));
        }

        return products;
    }

    public static TheProductList available(){
        return new TheProductList();
    }
}
