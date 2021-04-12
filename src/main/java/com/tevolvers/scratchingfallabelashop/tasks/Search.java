package com.tevolvers.scratchingfallabelashop.tasks;

import com.tevolvers.scratchingfallabelashop.user_interface.SearchComponent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static com.tevolvers.scratchingfallabelashop.user_interface.SearchComponent.SEARCH_INPUT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class Search implements Task {

    private String productName;

    public Search(String productName) {
        this.productName = productName;
    }

    @Step("{0} searches the product name #productName")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(productName).into(SEARCH_INPUT)
                .thenHit(Keys.ENTER));
    }

    public static Search theProduct(String productName){
        return Tasks.instrumented(Search.class, productName);
    }
}
