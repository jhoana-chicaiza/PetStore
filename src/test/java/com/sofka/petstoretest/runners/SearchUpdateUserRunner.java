package com.sofka.petstoretest.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/searchupdateuser.feature",
        glue = "com.sofka.petstoretest.stepdefinitions"
)

public class SearchUpdateUserRunner {
}
