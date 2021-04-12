package com.tevolvers.scratchingfallabelashop.stepdefinitions;

import com.tevolvers.scratchingfallabelashop.questions.TheProductList;
import com.tevolvers.scratchingfallabelashop.tasks.Close;
import com.tevolvers.scratchingfallabelashop.tasks.Search;
import com.tevolvers.scratchingfallabelashop.utils.ExportList;
import com.tevolvers.scratchingfallabelashop.utils.SendMail;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class GetPricesStepDefinitions {
    @Before
    public void setUpStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("that {string} is on Fallabela web page")
    public void thatUserIsOnFallabelaWebPage(String user) {
        System.out.println(user);
        OnStage.theActorCalled(user).wasAbleTo(Open.url("https://www.falabella.com.co/falabella-co/"),
                Close.popup());

    }


    @When("he searches {string}")
    public void heSearchesProduct(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(Search.theProduct(productName));
    }
    @Then("he should see prices of every product")
    public void heShouldSeePricesOfEveryProduct() {

        ExportList.toFile(OnStage.theActorInTheSpotlight().asksFor(TheProductList.available()));
        SendMail.withResults();
    }
}
