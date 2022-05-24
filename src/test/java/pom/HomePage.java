package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;
import reports.Report;


public class HomePage extends BasePage {

//    sanity flow function

    public   void homePageSanity(WebDriver driver){
        HomePage homePage = new HomePage();
        homePage.clickSelectAmount();
        Report.passedTest("Pick price point");

        homePage.select500();
        Report.passedTest("Pick 500-750שח");

        homePage.clickSelectLocation();
        Report.passedTest("Pick Region");

        homePage.selectTelAviv();
        Report.passedTest("Select תל אביב והסביבה");

        homePage.clickSelectCategory();
        Report.passedTest("Pick Category");

        homePage.selectFashionGiftCard();
        Report.passedTest("Select מותגי אופנה");

        homePage.clickFindMyGift();
        Report.passedTest("Press תמצאו לי מתנה״");
    }

//    Page Elements

    void clickLoginOrRegister(){clickElement(By.className("notSigned"));}

    private void clickSelectAmount(){clickelementJS(By.cssSelector("span[alt='סכום']"));}

    private void select500(){clickelementJS(By.cssSelector("li[value='5']"));}

    private void clickSelectLocation(){clickelementJS(By.cssSelector("span[alt='אזור']"));}

    private void selectTelAviv(){clickelementJS(By.cssSelector("li[value='13']"));}

    private void clickSelectCategory(){clickelementJS(By.cssSelector("span[alt='קטגוריה']"));}

    private void selectFashionGiftCard(){clickelementJS(By.cssSelector("li[value='22']"));}

    private void clickFindMyGift(){clickelementJS(By.cssSelector("a[rel=nofollow]"));}



}
