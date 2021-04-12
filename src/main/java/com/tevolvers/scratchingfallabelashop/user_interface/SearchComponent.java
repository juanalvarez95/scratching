package com.tevolvers.scratchingfallabelashop.user_interface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class SearchComponent {
    public static final Target SEARCH_INPUT = Target.the("Input search")
            .locatedBy("//div[@class='d-none d-lg-block']//input[@data-testid='input-search-box']");

    public static final Target PRODUCT_PRICE = Target.the("Product price")
            .locatedBy("//ol[contains(@class,'prices')]/descendant::span[1]");

    public static final Target PRODUCT_NAME = Target.the("Product name")
            .locatedBy("//b[contains(@class,'pod-subTitle')]");


}
