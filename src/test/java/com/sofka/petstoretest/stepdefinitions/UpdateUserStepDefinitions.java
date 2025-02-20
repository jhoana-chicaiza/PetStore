package com.sofka.petstoretest.stepdefinitions;

import com.sofka.petstoretest.models.User;
import com.sofka.petstoretest.tasks.UpdateUser;
import com.sofka.petstoretest.questions.ResponseCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.sofka.petstoretest.utils.Constants.ACTOR;
import static com.sofka.petstoretest.utils.Constants.BASE_URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class UpdateUserStepDefinitions {

    private Actor jhoana = Actor.named(ACTOR);
    private User user;
    private String username;

    @Given("Jhoana wants to update the user information for username {string}")
    public void jhoanaWantsToUpdateTheUserInformationForUsername(String username) {
        jhoana.whoCan(CallAnApi.at(BASE_URL));
        this.username = username;
        user = new User();
        user.setId(0L);
        user.setUsername("cchs");
        user.setFirstName("Cristina");
        user.setLastName("Chicaiza");
        user.setEmail("cchs.email.com");
        user.setPassword("121313");
        user.setPhone("1313131");
        user.setUserStatus(0);
    }

    @When("she sends the updated user information")
    public void sheSendsTheUpdatedUserInformation() {
        jhoana.attemptsTo(UpdateUser.withDetails(username, user));
    }

    @Then("the user information should be updated successfully")
    public void theUserInformationShouldBeUpdatedSuccessfully() {
        jhoana.should(
                seeThat("The response code is 200", ResponseCode.is(), equalTo(200))
        );
    }
}