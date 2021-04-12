package com.tevolvers.scratchingfallabelashop.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = "com.tevolvers.scratchingfallabelashop.stepdefinitions"
)
public class GetPricesRunner {
}
