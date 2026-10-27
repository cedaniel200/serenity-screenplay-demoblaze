package com.cedaniel200.automatizacion.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PlaceOrderPage {

    private PlaceOrderPage() {
    }

    public static final Target NAME = Target.the("Name").located(By.id("name"));
    public static final Target COUNTRY = Target.the("Country").located(By.id("country"));
    public static final Target CITY = Target.the("City").located(By.id("city"));
    public static final Target CARD = Target.the("Card").located(By.id("card"));
    public static final Target MONTH = Target.the("month").located(By.id("month"));
    public static final Target YEAR = Target.the("year").located(By.id("year"));

    public static final Target PURCHASE_BUTTON = Target.the("Place Order button")
            .locatedBy("//button[text()='Purchase']");

    public static final Target MESSAGE_SUCCESS_PURCHASE = Target.the("Message Thank you for your purchase!")
            .locatedBy("//h2[text()='Thank you for your purchase!']");
}
