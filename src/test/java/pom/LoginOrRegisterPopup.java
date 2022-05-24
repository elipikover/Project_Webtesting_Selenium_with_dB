package pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.BasePage;
import utils.Constants;
import reports.Report;

public class LoginOrRegisterPopup extends BasePage {

    //Method of full login to a default user that arrives at the home page

    public void loginToBuyMe(WebDriver driver){
        driver.get("https://buyme.co.il/?modal=login");
        LoginOrRegisterPopup registerPopup = new LoginOrRegisterPopup();
        registerPopup.enterLoginEmail(Constants.EMAIL_DEFAULT_USER);
        registerPopup.enterLoginPass1(Constants.PASSWORD_DEFAULT_USER);
        registerPopup.clickSubmitRegistration();
        Report.passedTest("Login user");
    }

    //    sanity flow function

    public void registerToBuyMe(WebDriver driver){
        Report.passedTest(" Enter BuyMe website");

        HomePage homepage = new HomePage();
        homepage.clickLoginOrRegister();

        Report.passedTest("Press כניסה והרשמה");

        LoginOrRegisterPopup registerPopup = new LoginOrRegisterPopup();
        registerPopup.clickFirstTimeRegister();

        Report.passedTest("Press הרשמה");

        registerPopup.enterLoginName(Constants.NAME_DEFAULT_USER);

        Report.passedTest("Enter First Name");

        registerPopup.enterLoginEmail(Constants.EMAIL_DEFAULT_USER);

        Report.passedTest("Enter valid email address");

        registerPopup.enterLoginPass1(Constants.PASSWORD_DEFAULT_USER);

        Report.passedTest("Enter password");

        registerPopup.enterLoginPass2(Constants.PASSWORD_DEFAULT_USER);

        Report.passedTest("Re-Enter password");


        Assert.assertEquals(registerPopup.verifyTextInLoginName(), Constants.NAME_DEFAULT_USER);

        Report.passedTest("Assert text entered in first name field");

        Assert.assertEquals(registerPopup.verifyTextInLoginEmail(), Constants.EMAIL_DEFAULT_USER);

        Report.passedTest("Assert text entered in email field");

        Assert.assertEquals(registerPopup.verifyTextInPass1(), Constants.PASSWORD_DEFAULT_USER);

        Report.passedTest("Assert text entered in first password field");

        Assert.assertEquals(registerPopup.verifyTextInPass2(), Constants.PASSWORD_DEFAULT_USER);

        Report.passedTest("Assert text entered in second password field");

        registerPopup.clickSubmitRegistration();

        Report.passedTest("Press הרשמה");
    }

        private void clickFirstTimeRegister(){clickElement(By.className("text-link"));}

        private void enterLoginName(String string){sendKeysToElement(By.cssSelector("input[type=text]"),string);}

        private String verifyTextInLoginName(){return getTextFromElement(By.cssSelector("input[type=text]"));}

        private void enterLoginEmail(String string){sendKeysToElement(By.cssSelector("input[type=email]"),string);}

        private String verifyTextInLoginEmail(){
            return getTextFromElement(By.cssSelector("input[type=email]"));
        }

        private void enterLoginPass1(String string){sendKeysToElement(By.cssSelector("input[placeholder='סיסמה']"), string);}

        private void enterLoginPass2(String string){sendKeysToElement(By.cssSelector("input[placeholder='אימות סיסמה']"), string);}

        private String verifyTextInPass1(){return getTextFromElement(By.cssSelector("input[placeholder='סיסמה']"));}

        private String verifyTextInPass2(){return getTextFromElement(By.cssSelector("input[placeholder='אימות סיסמה']"));}

        private void clickSubmitRegistration(){
                clickElement(By.cssSelector("button[type=submit]"));
            }



}
