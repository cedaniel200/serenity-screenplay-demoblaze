package com.cedaniel200.automatizacion.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductPage {

    private ProductPage() {
    }

    public static final Target ADD_TO_CART_BUTTON = Target.the("Add to cart button")
            .located(By.linkText("Add to cart"));
}
