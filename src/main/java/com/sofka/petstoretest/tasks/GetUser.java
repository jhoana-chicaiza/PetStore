package com.sofka.petstoretest.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUser implements Task {

    private final String username;

    public GetUser(String username) {
        this.username = username;
    }

    public static GetUser withUsername(String username) {
        return instrumented(GetUser.class, username);
    }

    @Override
    @Step("{0} retrieves the user information for username #username")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/v2/user/{username}")
                        .with(request -> request
                                .pathParam("username", username))
        );
    }
}