package com.cedaniel200.automatizacion.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DemoBlazeHomePage {

    private DemoBlazeHomePage() {
    }

    public static final Target BANNER = Target.the("homepage banner").located(By.id("narvbarx"));

    public static final Target CATEGORY_MENU = Target.the("Category of {0}")
            .locatedBy("//a[@id='itemc'][text()='{0}']");
    public static final Target PRODUCT = Target.the("Product {0}")
            .locatedBy("//div[contains(@class,'card')]//a[text()='{0}']");

}
