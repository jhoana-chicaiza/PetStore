package com.sofka.petstoretest.stepdefinitions;

import com.sofka.petstoretest.tasks.GetUser;
import com.sofka.petstoretest.questions.ResponseUsername;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.sofka.petstoretest.utils.Constants.ACTOR;
import static com.sofka.petstoretest.utils.Constants.BASE_URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class SearchUpdateUserStepDefinitions {

    private Actor jhoana = Actor.named(ACTOR);
    private String username;

    @Given("Jhoana wants to retrieve the user update information for username {string}")
    public void jhoanaWantsToRetrieveTheUserUpdateInformationForUsername(String username) {
        jhoana.whoCan(CallAnApi.at(BASE_URL));
        this.username = username;
    }

    @When("she sends the request to get the user update information")
    public void sheSendsTheRequestToGetTheUserUpdateInformation() {
        jhoana.attemptsTo(GetUser.withUsername(username));
    }

    @Then("the username in the response should be {string}")
    public void theUsernameInTheResponseUpdateShouldBe(String expectedUsername) {
        jhoana.should(
                seeThat("The username in the response", ResponseUsername.fromResponse(), equalTo(expectedUsername))
        );
    }
}