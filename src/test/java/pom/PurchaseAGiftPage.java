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

public class PurchaseAGiftPage extends BasePage {
    public void purchaseAGift(WebDriver driver){

        PurchaseAGiftPage purchaseAGift= new PurchaseAGiftPage();

        purchaseAGift.toSomeoneElse();
        Report.passedTest("Press button  למישהו אחר״");

        purchaseAGift.enterRecieverName("John Smith");
        Report.passedTest("Enter Receiver name");

        Assert.assertEquals(purchaseAGift.verifyReceiverName(), "John Smith");
        Report.passedTest("Assert Receiver name in field");

        purchaseAGift.chooseAnEvent();
        Report.passedTest("Pick an event");

        purchaseAGift.reasonForEvent();
        Report.passedTest("Pick reason an event");

        purchaseAGift.enterABlessing("❤❤❤ מזל טוב לחתונתכם ❤❤❤");
        Report.passedTest("Enter blessing");

        purchaseAGift.scrollToContinueButton();

        purchaseAGift.uploadAnImage(Constants.SAMPLE_FILE);
        Report.passedTest("upload an image");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("thumbnail")));
        purchaseAGift.clickContinueButton();
        Report.passedTest("Press המשך button");


        purchaseAGift.pressNow();
        Report.passedTest("Press עכשיו button");


        purchaseAGift.chooseEmail();
        Report.passedTest("Pick email/SMS");


        purchaseAGift.enterEmail("Test@a.com");
        Report.passedTest("Enter an email address/phone numebr");


        purchaseAGift.clearSenderName();
        purchaseAGift.enterSenderName("קטי סמיט׳");
        Report.passedTest("Enter sender name");


        Assert.assertEquals(purchaseAGift.verifySenderName(), "קטי סמיט׳");
        Report.passedTest("Assert sander name");

        purchaseAGift.clickPay();
        Report.passedTest("Press תשלום״");
    }

    private  void toSomeoneElse(){clickelementJS(By.xpath("//*[text()='למישהו אחר']"));}

    private void enterRecieverName(String name){
        sendKeysToElement(By.cssSelector("input[type=text]"),name );}

    private void chooseAnEvent(){clickelementJS(By.className("selected-name"));}

    private  void reasonForEvent(){clickelementJS(By.cssSelector("li[value='14']"));}

    private void enterABlessing(String blessing){
        sendKeysToElement(By.cssSelector("textarea[rows='4']"), blessing);}

    private void uploadAnImage(String pathToFile){
        sendKeysToElement(By.cssSelector("input[type=file]"), pathToFile);}

    private String verifyReceiverName(){return getTextFromElement(By.cssSelector("input[data-parsley-required-message=\"מי הזוכה המאושר? יש להשלים את שם המקבל/ת\"]"));}

    private void scrollToContinueButton(){scrollToElement(By.cssSelector("button[gtm='המשך']"));}

    private void clickContinueButton(){clickelementJS(By.cssSelector("button[gtm='המשך']"));}

    private void pressNow(){clickElement(By.cssSelector("svg[viewBox='0 0 20 20']"));}

    private void chooseEmail() {clickElement(By.cssSelector("svg[gtm=method-email]"));}

    private void enterEmail(String email){
        sendKeysToElement(By.cssSelector("input[type=email]"), email);}

    private void clearSenderName(){clearElement(By.cssSelector("input[placeholder='שם שולח המתנה']"));}

    private void enterSenderName(String name){
        sendKeysToElement(By.cssSelector("input[placeholder='שם שולח המתנה']"), name);}

    private String verifySenderName(){return getTextFromElement(By.cssSelector("input[placeholder='שם שולח המתנה']"));}

    private void clickPay() {clickElement(By.cssSelector("svg[gtm=method-email]"));}

    }

