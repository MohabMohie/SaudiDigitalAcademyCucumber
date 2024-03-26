package seleniumCucumber;

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

import java.util.List;

public class StepDefinitions {
    WebDriver driver;

    @Given("my browser is open")
    public void my_browser_is_open() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @When("I navigate to google")
    public void i_navigate_to_google() {
        driver.navigate().to("https://www.google.com/");
    }
    @When("I search for selenium webdriver")
    public void i_search_for_selenium_webdriver() {
        By searchboxInput = By.id("APjFqb");
        driver.findElement(searchboxInput).sendKeys("selenium webdriver");
        driver.findElement(searchboxInput).submit();
    }
    @Then("result stats would not be empty")
    public void result_stats_would_not_be_empty() {
        By resultStatsLabel = By.id("result-stats");
        String actualText = driver.findElement(resultStatsLabel).getText();
        Assertions.assertNotEquals("",actualText);
    }

//    @Before
//    public void openBrowser(){
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//    }

    @After()
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot-"+System.currentTimeMillis());
        }
        driver.quit();
    }

    @And("I search for {string}")
    public void iSearchFor(String searchQuery) {
        By searchboxInput = By.id("APjFqb");
        driver.findElement(searchboxInput).sendKeys(searchQuery);
        driver.findElement(searchboxInput).submit();
    }

    @And("I search for the following text:")
    public void iSearchForTheFollowingText(List<String> queries) {
        By searchboxInput = By.id("APjFqb");
        queries.forEach(query ->{
            driver.findElement(searchboxInput).sendKeys(query + " ");
        });
        driver.findElement(searchboxInput).submit();
    }
}
