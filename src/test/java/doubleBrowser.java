import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/*****************************************************************\

\*****************************************************************/
public class doubleBrowser {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static ExtentReports extent;


    @BeforeClass
    public static void openBuymeSite (){
        driver = GetDriver.getDriverInstance();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://buyme.co.il/");


    }

    @Test
    public void test01_register () throws IOException {
        Register.registration(driver);
    }

    @Test
    public void test02_homescreen () throws InterruptedException {
        HomeScreen.homeScreenGoThrough(driver);
    }

    @Test
    public void test03_pickbusiness () throws Exception {
        //Pickbusiness.assretURL(driver);
        Pickbusiness.pickbus(driver, wait);
    }

    @Test
    public void test04_informationscreen () throws InterruptedException, IOException {
        Informationscreen.fillInfo(driver);
    }

    @Test
    public static void test05_beforebrowser2 (){
        //driver = GetDriver.getDriverInstance();
        System.setProperty("webdriver.chrome.driver","D:\\Java\\chrome driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://buyme.co.il/");
    }

    @Test
    public void test06_register () throws IOException {
        Register.registration(driver);
    }

    @Test
    public void test07_homescreen () throws InterruptedException {
        HomeScreen.homeScreenGoThrough(driver);
    }

    @Test
    public void test08_pickbusiness () throws Exception {
        //Pickbusiness.assretURL(driver);
        Pickbusiness.pickbus(driver, wait);
    }

    @Test
    public void test09_informationscreen () throws InterruptedException, IOException {
        Informationscreen.fillInfo(driver);
    }
    @AfterClass
    public static void tearDown2 () {
        // driver.quit();
    }


}