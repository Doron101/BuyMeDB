import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class EnterNoCredentials {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static ExtentReports extent;

    @BeforeClass
    public static void openBuyme() {
            driver = GetDriver.getDriverInstance();
            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.get("https://buyme.co.il/");
            System.out.println("AAAAAAAAAAAA");
    }

    @Test
    public void test01_pressEnter(){
        driver.findElement(By.xpath("//span[.='כניסה']")).click();
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("ul[id=parsley-id-12]")).getText(),"כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה");
        System.out.println("The test resulted the right text.");
    }

}
