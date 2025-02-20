package com.sofka.petstoretest.tasks;

import com.sofka.petstoretest.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UpdateUser implements Task {

    private final String username;
    private final User user;

    public UpdateUser(String username, User user) {
        this.username = username;
        this.user = user;
    }

    public static UpdateUser withDetails(String username, User user) {
        return instrumented(UpdateUser.class, username, user);
    }

    @Override
    @Step("{0} updates the user information for username #username")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("/v2/user/{username}")
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .pathParam("username", username)
                                .body(user))
        );
    }
}