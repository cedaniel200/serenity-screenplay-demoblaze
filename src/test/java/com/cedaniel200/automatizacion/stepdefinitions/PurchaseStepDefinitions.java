package com.cedaniel200.automatizacion.stepdefinitions;

import com.cedaniel200.automatizacion.interactions.Resize;
import com.cedaniel200.automatizacion.models.Product;
import com.cedaniel200.automatizacion.models.Purchaser;
import com.cedaniel200.automatizacion.tasks.Add;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.cedaniel200.automatizacion.models.Purchaser.PURCHASER_INFORMATION;
import static com.cedaniel200.automatizacion.models.PurchaserFactory.createByName;
import static com.cedaniel200.automatizacion.questions.PurchaseSuccessful.thePurchaseIsSuccessful;
import static com.cedaniel200.automatizacion.tasks.Authenticate.authenticate;
import static com.cedaniel200.automatizacion.tasks.Buy.buy;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PurchaseStepDefinitions {

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) is authenticated$")
    public void authenticateActor(String actorName) {
        Purchaser aPurchaser = createByName(actorName);
        theActorCalled(aPurchaser.getName()).attemptsTo(
                Open.browserOn().thePageNamed("home.page"),
                Resize.windowToMaximize(),
                authenticate(aPurchaser.getCredentials())
        );
        theActorInTheSpotlight().remember(PURCHASER_INFORMATION, aPurchaser);
    }

    @Given("^add some products$")
    public void addToCart() {
        Product aProduct = Product.builder().category("Laptops").name("MacBook air").build();
        Product otherProduct = Product.builder().category("Monitors").name("Apple monitor 24").build();

        theActorInTheSpotlight().wasAbleTo(
            Add.toCart(aProduct),
            Add.toCart(otherProduct)
        );
    }

    @When("^[a-zA-Z]{3,50} makes the purchase$")
    public void purchase() {
        theActorInTheSpotlight().attemptsTo(
            buy()
        );
    }

    @Then("should see the message Thank you for your purchase")
    public void shouldSeeTheMessageThankYouForYourPurchase() {
        theActorInTheSpotlight().should(seeThat(thePurchaseIsSuccessful()));
    }
}
