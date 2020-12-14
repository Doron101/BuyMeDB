//import com.aventstack.extentreports.ExtentReports;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//
//public class LoadingPage {
//    private static WebDriver driver;
//    private static WebDriverWait wait;
//    private static ExtentReports extent;
//    private static String a;
//    @BeforeClass
//    public static void openBuyme() throws InterruptedException {
//
////        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
////        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////
////        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        //ChromeOptions options = new ChromeOptions();
//        //options.addArguments("-kShortMergeSessionTimeoutForTest");
//        //options.addArguments("-kStartStackProfilerBrowserTest");
//        System.setProperty("webdriver.chrome.driver","D:\\Java\\chrome driver\\chromedriver.exe");
//        driver = new ChromeDriver();
//        //driver = GetDriver.getDriverInstance();
//        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.ESCAPE);
//        //driver.get("https://buyme.co.il/");
//        //driver.findElement(By.id("check-dot")).sendKeys(Keys.ESCAPE);
//        //driver.close();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        ((JavascriptExecutor)driver).executeScript("window.location = 'https://buyme.co.il/'");
//        //Thread.sleep(500);
//        js.executeScript("return window.stop");
//
//        //driver.get("https://buyme.co.il/");
//
////        //System.out.println(" AAAAAA " +driver.getCurrentUrl());
////        //driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MILLISECONDS);
////        kShortMergeSessionTimeoutForTest
////        ChromeOptions chromeOpt = new ChromeOptions();
////        chromeOpt.addArguments("--disable-extensions");
////        ChromeDriverService service = ChromeDriverService.createDefaultService(binLocation);
////        //service.Port = 9515;
//        System.out.println("AAAAAAAAAAAA");
//    }
//
//    @Test
//    public void test01_temp() throws IOException {
//        System.out.println("AAAAAAAAAAAA");
//
//    }
//}
