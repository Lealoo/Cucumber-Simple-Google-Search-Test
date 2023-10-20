import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GoogleSearch {
    private WebDriver driver;

    @Given("an open browser with google.com")
    public void anOpenBrowserWithGoogleCom() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");
        driver.findElement(By.id("W0wltc")).click();
    }
    @When("^a keyword (.*) is entered in input field$")
    public void aKeywordSeleniumIsEnteredInInputField(String keyword) {
        WebElement element = driver.findElement(By.name("q"));
        element.click();
        element.sendKeys(keyword);
    }

    @And ("search button is clicked")
        public void searchButtonISClicked(){
        driver.findElement(By.name("btnK")).click();
        }


    @Then("^the first one should contain (.*)$")
    public void theFirstOneShouldContainSelenium(String keyword) {
        String searchText = driver.findElement(By.cssSelector("a h3")).getText();
        Assert.assertEquals(keyword, searchText.toLowerCase());

    }

    @And("close browser")
    public void closeBrowser() {
       driver.quit();
    }


}
