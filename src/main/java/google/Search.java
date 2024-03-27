package google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Search {
    private final WebDriver driver;
    private final By searchboxInput = By.id("APjFqb");
    public Search(WebDriver driver){
        this.driver = driver;
    }

    public Search goTo(){
        driver.navigate().to("https://www.google.com/");
        return this;
    }

    public Results search(String query){
        driver.findElement(searchboxInput).sendKeys(query + Keys.RETURN);
        return new Results(driver);
    }
}
