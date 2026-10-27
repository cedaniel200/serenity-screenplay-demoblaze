package com.cedaniel200.automatizacion.tasks;

import com.cedaniel200.automatizacion.exceptions.AuthenticationError;
import com.cedaniel200.automatizacion.models.Credentials;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static com.cedaniel200.automatizacion.exceptions.AuthenticationError.MESSAGE_FAILED_AUTHENTICATION;
import static com.cedaniel200.automatizacion.userinterfaces.LoginPage.*;
import static com.cedaniel200.automatizacion.userinterfaces.MenuPage.LOG_IN_MENU;
import static com.cedaniel200.automatizacion.userinterfaces.MenuPage.LOG_OUT_MENU;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class Authenticate implements Task {

    private final Credentials credentials;

    public Authenticate(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    @Step("{0} performs an authentication")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LOG_IN_MENU),
                WaitUntil.the(USERNAME, isVisible()).forNoMoreThan(Duration.ofSeconds(10)),
                Enter.theValue(credentials.getUsername()).into(USERNAME),
                Enter.theValue(credentials.getPassword()).into(PASSWORD),
                Click.on(LOG_IN_BUTTON)
        );

        actor.should(seeThat(the(LOG_OUT_MENU.waitingForNoMoreThan(Duration.ofSeconds(10))), isVisible())
                .orComplainWith(AuthenticationError.class, MESSAGE_FAILED_AUTHENTICATION));
    }

    public static Authenticate authenticate(Credentials credentials){
        return instrumented(Authenticate.class, credentials);
    }
}
