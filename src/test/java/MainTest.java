import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/*****************************************************************\

\*****************************************************************/
public class MainTest {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static ExtentReports extent ;
    private static ExtentTest test ;


    @BeforeClass
    public static void openBuymeSite() {
        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\logFile.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name your test and add description
        test = extent.createTest("MyFirstTest", "Sample description");
        // add custom system info
        extent.setSystemInfo("Environment", "Production");
        extent.setSystemInfo("Tester", "Doron");
        // log results
        test.log(Status.INFO, "@Before class");
        boolean driverSW = false;
        try {
              driver = GetDriver.getDriverInstance();
              driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
              driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

              wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driverSW=true;
        }  catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Driver wasn't allocated because " +e.getMessage());
        } finally {
            if (driverSW) {
                test.log(Status.PASS, "Driver was allocated O.K.");
            }
        }

        boolean webSite = false;
        try {
            driver.get("https://buyme.co.il/");
             webSite=true;
        }  catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "WebSite wasn't connected because " +e.getMessage());
        } finally {
            if (webSite) {
                test.log(Status.PASS, "Driver was connected O.K.");
            }
        }


        System.out.println("AAAAAAAAAAAA");
        // log results
        test.log(Status.INFO, "@Before class");
    }

    @Test
    public void test01_register() { // throws IOException {
       boolean register = false;
        try {
             Register.registration(driver);
             register=true;
        }  catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Registration failed because " +e.getMessage());
        } finally {
            if (register) {
                test.log(Status.PASS, "Registration successed");
            }
        }
    }

    @Test
    public void test02_homescreen() {//throws InterruptedException {
        boolean homeScreen = false;
        try {
             HomeScreen.homeScreenGoThrough(driver);
             homeScreen=true;
        }  catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "HomeScreen failed because " +e.getMessage());
        } finally {
            if (homeScreen) {
                test.log(Status.PASS, "HomeScreen successed");
            }
        }
    }

    @Test
    public void test03_pickbusiness() { //throws InterruptedException {
        boolean pickbusiness = false;
        try {
             //Pickbusiness.assretURL(driver);
              Pickbusiness.pickbus(driver, wait);
              pickbusiness=true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Business wasn't found because " +e.getMessage());
        } finally{
        if (pickbusiness) {
            test.log(Status.PASS, "Business picked up O.K.");
        }
     }
    }

    @Test
    public void test04_informationscreen() throws IOException, InterruptedException {
        boolean InformationscreenSW = false;
        try {
              Informationscreen.fillInfo(driver);
              InformationscreenSW=true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Informationscreen failed because " +e.getMessage());
        } finally{
            if (InformationscreenSW) {
                test.log(Status.PASS, "Informationscreen worked O.K.");
            }
        }
    }

    @Test
    public void test05_screenshot() throws InterruptedException {
        boolean screenshotSW = false;
        try {
              ScreenShot.TakeaScreenShot(driver,test);
              screenshotSW=true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "ScreenShot wasn't taken because " +e.getMessage());
        } finally{
            if (screenshotSW) {
                test.log(Status.PASS, "ScreenShot was taken O.K.");
            }
        }
    }

    @AfterClass
    public static void tearDown() {
        test.log(Status.INFO, "@After test at last....");
        extent.flush();
        // driver.quit();
    }
}
