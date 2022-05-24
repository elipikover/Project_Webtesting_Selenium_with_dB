package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BasePage;
import utils.Constants;
import reports.Report;

import java.time.Duration;

public class BuissinessPage extends BasePage {

//    sanity flow function
    private void clickBuissiness(String buissiness) {clickelementJS(By.linkText(buissiness));}

//    Page elements
    private void clickSubmit(){
        clickElement(By.cssSelector("button[type=submit]"));
    }

    private void enterAmount(String amount){sendKeysToElement(By.cssSelector("input[inputmode=decimal]"),amount);}

    public void pickABuissiness(WebDriver driver){
//             Wait for URL to update - there is a lag on website
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlContains(Constants.GIFTSEARCHURL));

        Assert.assertEquals(driver.getCurrentUrl(), Constants.GIFTSEARCHURL);
        BuissinessPage buissinessSearch = new BuissinessPage();
        Report.passedTest("Assert website URL");

        buissinessSearch.clickBuissiness("אופטיקנה");
        Report.passedTest("Pick buissiness - אופטיקנה");

        buissinessSearch.enterAmount("1000");
        Report.passedTest("Choose a price");

        buissinessSearch.clickSubmit();
        Report.passedTest("Press  לבחירה״");

    }
}