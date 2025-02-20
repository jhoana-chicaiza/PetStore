package com.sofka.petstoretest.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class ResponseUsername {
    public static Question<String> fromResponse() {
        return actor -> LastResponse.received().answeredBy(actor).jsonPath().getString("username");
    }
}