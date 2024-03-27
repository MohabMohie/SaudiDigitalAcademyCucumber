package google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Results {
    private final WebDriver driver;
    private final By resultStatsLabel = By.id("result-stats");
    public Results(WebDriver driver){
        this.driver = driver;
    }

    public String getResultStats(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> !driver.findElement(resultStatsLabel).getText().isEmpty());
        return driver.findElement(resultStatsLabel).getText();
    }
}
