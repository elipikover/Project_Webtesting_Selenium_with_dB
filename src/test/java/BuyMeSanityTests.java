import config.XMLConfig;
import pom.BuissinessPage;
import pom.HomePage;
import pom.LoginOrRegisterPopup;
import pom.PurchaseAGiftPage;
import reports.Report;
import server_utils.DatabaseConnection;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import utils.*;
import java.sql.Connection;
import java.time.Duration;


/**
 * This is a suite of sanity tests for the BUYME website
 */

public class BuyMeSanityTests {


    private final WebDriver driver= DriverSingelton.getdriverInstance();
    private final Connection con =  DatabaseConnection.ConnectionInstance();
    /**
     * Set up tests, waits, browser window and reporting system
     */

    @BeforeClass
    public void runBeforeTests(){
//        fgsdgsd

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent.html");
        Report.extent.attachReporter(htmlReporter);
        Report.extent.setSystemInfo("OS", "Mac Menterey");
        Report.extent.setSystemInfo("Environment", "QA");
//        try {
//            Databases.createTable(con,"Chipopo");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * Test of intro & registration flow
     */

    @Test(priority = 1)
    public void introAndRegistration() {

// Getconfiguratiuon from XML
        try {
            driver.get(XMLConfig.getURL());
        } catch (Exception e) {
            e.printStackTrace();
        }

        new LoginOrRegisterPopup().registerToBuyMe(driver);

    }
    /**
     * Test of Home screen flow
     */
    @Test(priority = 2)
    public void Home() {
    new LoginOrRegisterPopup().loginToBuyMe(driver);
    new HomePage().homePageSanity(driver);

    }
    /**
     * Test of pick a buissiness flow
     */
    @Test(priority = 3)
    public void PickABusiness() {
        new BuissinessPage().pickABuissiness(driver);
    }
    /**
     * Test of Sender And Reciever Information flow
     */
    @Test(priority = 4)
    public void SenderAndRecieverInformation() {

            new PurchaseAGiftPage().purchaseAGift(driver);


    }

    @AfterClass
    public void runAfterTests() {
        driver.quit();
        Report.extent.flush();
    }

}
