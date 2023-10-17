package StepDefinitions;

import PageObjectModels.Example;
import Utilities.Events;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ExampleSteps {
    Example elements = new Example();

    @Given("Enter {string} to search box")
    public void enterToSearchBox(String name) {
        Events.sendKeys(elements.searchBox, name);
    }

    @And("Click to search button")
    public void clickToSearchButton() {
        Events.jsClick(elements.searchBtn);
    }

    @When("I should see the results")
    public void iShouldSeeTheResultsIncludeJamesGosling() {

    }
}
