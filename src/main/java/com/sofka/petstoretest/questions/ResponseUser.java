package com.sofka.petstoretest.questions;

import com.sofka.petstoretest.models.User;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class ResponseUser {
    public static Question<User> information() {
        return actor -> LastResponse.received().answeredBy(actor).as(User.class);
    }
}
