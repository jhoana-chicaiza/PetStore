package com.sofka.petstoretest.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.TheResponse;

public class ResponseCode {
    public static Question<Integer> is() {
        return TheResponse.statusCode();
    }
}