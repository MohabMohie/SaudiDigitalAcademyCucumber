package seleniumCucumber;

import google.Results;
import google.Search;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    Search searchPage;

    @Given("my browser is open")
    public void my_browser_is_open() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @When("I navigate to google")
    public void i_navigate_to_google() {
//        driver.navigate().to("https://www.google.com/");
        searchPage = new Search(driver);
    }
    @When("I search for selenium webdriver")
    public void i_search_for_selenium_webdriver() {
        searchPage.search("selenium webdriver");
    }
    @Then("result stats would not be empty")
    public void result_stats_would_not_be_empty() {
        Results results = new Results(driver);
        Assertions.assertNotEquals("", results.getResultStats());
    }

//    @Before
//    public void openBrowser(){
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//    }

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
        searchPage.search(searchQuery);
    }

//    @And("I search for the following text:")
//    public void iSearchForTheFollowingText(List<String> queries) {
//        StringBuilder queryStringBuilder = new StringBuilder();
//
//        queries.forEach(query ->{
//            queryStringBuilder.append(query);
//            queryStringBuilder.append(" ");
//        });
//
//        searchPage.search(queryStringBuilder.toString());
//    }
}
