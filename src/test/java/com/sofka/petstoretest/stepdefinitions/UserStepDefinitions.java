package com.sofka.petstoretest.stepdefinitions;

import com.sofka.petstoretest.models.User;
import com.sofka.petstoretest.tasks.CreateUser;
import com.sofka.petstoretest.questions.ResponseCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.sofka.petstoretest.utils.Constants.ACTOR;
import static com.sofka.petstoretest.utils.Constants.BASE_URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class UserStepDefinitions {

    private Actor jhoana = Actor.named(ACTOR);
    private User user;

    @Given("Jhoana wants to create a new user")
    public void jhoanaWantsToCreateANewUser() {
        jhoana.whoCan(CallAnApi.at(BASE_URL));
        user = new User();
        user.setId(0L);
        user.setUsername("jchs");
        user.setFirstName("Jhoana");
        user.setLastName("Chicaiza");
        user.setEmail("jchs.email.com");
        user.setPassword("121313");
        user.setPhone("121213");
        user.setUserStatus(0);
    }

    @When("she sends the user information")
    public void sheSendsTheUserInformation() {
        jhoana.attemptsTo(CreateUser.withDetails(user));
    }

    @Then("the user should be created successfully")
    public void theUserShouldBeCreatedSuccessfully() {
        jhoana.should(
                seeThat("The response code is 200", ResponseCode.is(), equalTo(200))
        );
    }
}