package seleniumCucumber;

import google.Results;
import google.Search;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class StepDefinitions {
    WebDriver driver;
    Results results;
    Search search;

    @Given("my browser is open")
    public void my_browser_is_open() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @When("I navigate to google")
    public void i_navigate_to_google() {
        search = new Search(driver).goTo();
    }
    @When("I search for selenium webdriver")
    public void i_search_for_selenium_webdriver() {
        results = new Search(driver).search("selenium webdriver");
    }
    @Then("result stats would not be empty")
    public void result_stats_would_not_be_empty() {
        Assertions.assertNotEquals("", results.getResultStats());
    }

    @Step("Closing Browser")
    @After()
    public void closeBrowser(Scenario scenario) {
//        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot-"+System.currentTimeMillis());
//        }
        driver.quit();
    }

    @And("I search for {string}")
    public void iSearchFor(String searchQuery) {
        results = new Search(driver).search(searchQuery);
    }

    @When("I search for something")
    public void iSearchForSomething() {
        results = new Search(driver).goTo().search("Parameterized search query");
    }

    @And("I search for the following text:")
    public void iSearchForTheFollowingText(List<String> queries) {
        StringBuilder queryStringBuilder = new StringBuilder();

        queries.forEach(query ->{
            queryStringBuilder.append(query);
            queryStringBuilder.append(" ");
        });

        search.search(queryStringBuilder.toString());
    }
}
