package com.cedaniel200.automatizacion.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

    private CartPage() {
    }

    public static final Target PLACE_ORDER_BUTTON = Target.the("Place Order button")
            .locatedBy("//button[text()='Place Order']");
}
