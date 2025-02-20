package com.sofka.petstoretest.tasks;

import com.sofka.petstoretest.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateUser implements Task {

    private final User user;

    public CreateUser(User user) {
        this.user = user;
    }

    public static CreateUser withDetails(User user) {
        return instrumented(CreateUser.class, user);
    }

    @Override
    @Step("{0} creates a new user")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/v2/user")
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .body(user))
        );
    }
}