package com.sofka.petstoretest.stepdefinitions;

import com.sofka.petstoretest.tasks.DeleteUser;
import com.sofka.petstoretest.questions.ResponseMessage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.sofka.petstoretest.utils.Constants.ACTOR;
import static com.sofka.petstoretest.utils.Constants.BASE_URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteUserStepDefinitions {

    private Actor jhoana = Actor.named(ACTOR);
    private String username;

    @Given("Jhoana wants to delete the user with username {string}")
    public void jhoanaWantsToDeleteTheUserWithUsername(String username) {
        jhoana.whoCan(CallAnApi.at(BASE_URL));
        this.username = username;
    }

    @When("she sends the request to delete the user")
    public void sheSendsTheRequestToDeleteTheUser() {
        jhoana.attemptsTo(DeleteUser.withUsername(username));
    }

    @Then("the response message should contain the username {string}")
    public void theResponseMessageShouldContainTheUsername(String expectedUsername) {
        jhoana.should(
                seeThat("The response message contains the username", ResponseMessage.fromResponse(), equalTo(expectedUsername))
        );
    }
}