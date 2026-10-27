package com.cedaniel200.automatizacion.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuPage {

    private MenuPage() {
    }

    public static final Target CART_MENU = Target.the("Cart Menu").located(By.id("cartur"));
    public static final Target HOME_MENU = Target.the("Home Menu").locatedBy("//a[text()='Home ']");
    public static final Target LOG_IN_MENU = Target.the("Log in Menu").located(By.id("login2"));
    public static final Target LOG_OUT_MENU = Target.the("Log out Menu").located(By.id("logout2"));
}