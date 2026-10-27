package com.cedaniel200.automatizacion.interaction;

import net.serenitybdd.screenplay.actions.DriverTask;
import org.openqa.selenium.WebDriver;

import java.util.function.Consumer;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Resize extends DriverTask {

    public Resize(Consumer<WebDriver> action) {
        super(action);
    }

    public static Resize windowToMaximize(){
        Consumer<WebDriver> action = webDriver -> webDriver.manage().window().maximize();
        return instrumented(Resize.class,action);
    }
}
