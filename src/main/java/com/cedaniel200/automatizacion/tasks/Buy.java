package com.cedaniel200.automatizacion.task;

import com.cedaniel200.automatizacion.model.Purchaser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.cedaniel200.automatizacion.model.Purchaser.PURCHASER_INFORMATION;
import static com.cedaniel200.automatizacion.userinterface.CartPage.PLACE_ORDER_BUTTON;
import static com.cedaniel200.automatizacion.userinterface.MenuPage.CART_MENU;
import static com.cedaniel200.automatizacion.userinterface.PlaceOrderPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Buy implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        Purchaser purchaser = actor.recall(PURCHASER_INFORMATION);
        actor.attemptsTo(
                Click.on(CART_MENU),
                WaitUntil.the(PLACE_ORDER_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(PLACE_ORDER_BUTTON),
                WaitUntil.the(NAME, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(purchaser.getName()).into(NAME),
                Enter.theValue(purchaser.getCountry()).into(COUNTRY),
                Enter.theValue(purchaser.getCity()).into(CITY),
                Enter.theValue(purchaser.getCard()).into(CARD),
                Enter.theValue(purchaser.getMonth()).into(MONTH),
                Enter.theValue(purchaser.getYear()).into(YEAR),
                Click.on(PURCHASE_BUTTON)
        );
    }

    public static Buy buy(){
       return instrumented(Buy.class);
    }
}
