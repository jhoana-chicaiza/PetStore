package com.sofka.petstoretest.stepdefinitions;

import com.sofka.petstoretest.models.User;
import com.sofka.petstoretest.questions.UserGetResult;
import com.sofka.petstoretest.tasks.GetUser;
import com.sofka.petstoretest.questions.ResponseUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.sofka.petstoretest.utils.Constants.ACTOR;
import static com.sofka.petstoretest.utils.Constants.BASE_URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class GetUserStepDefinitions {

    private Actor jhoana = Actor.named(ACTOR);
    private String username;

    @Given("Jhoana wants to retrieve the user information for username {string}")
    public void jhoanaWantsToRetrieveTheUserInformationForUsername(String username) {
        jhoana.whoCan(CallAnApi.at(BASE_URL));
        this.username = username;
    }

    @When("she sends the request to get the user information")
    public void sheSendsTheRequestToGetTheUserInformation() {
        jhoana.attemptsTo(GetUser.withUsername(username));
    }

    @Then("the user information should be retrieved successfully")
    public void theUserInformationShouldBeRetrievedSuccessfully() {
        jhoana.should(
                seeThat("response message", UserGetResult.putResult(), equalTo(username))
        );
    }
}