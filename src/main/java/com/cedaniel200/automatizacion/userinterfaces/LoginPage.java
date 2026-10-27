package com.cedaniel200.automatizacion.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    private LoginPage() {
    }

    public static final Target USERNAME = Target.the("username").located(By.id("loginusername"));
    public static final Target PASSWORD = Target.the("password").located(By.id("loginpassword"));
    public static final Target LOG_IN_BUTTON = Target.the("Log in button")
            .locatedBy("//*[@id='logInModal']//button[@class='btn btn-primary']");

}
