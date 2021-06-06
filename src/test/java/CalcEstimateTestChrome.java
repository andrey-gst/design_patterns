import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@Test
public class CalcEstimateTestChrome {
    static WebDriver driver;

    @Test(groups = "parallel")
    public static void main(String[] args) throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();

        //Add new code for Selenium Grid
        ChromeOptions options = new ChromeOptions();
        try {
            driver = new RemoteWebDriver(new 	URL("http://localhost:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://cloud.google.com/");
        driver.manage().window().maximize();

        MainPage MainPg = PageFactory.initElements(driver, MainPage.class);
        CalcPage CalcPg = PageFactory.initElements(driver, CalcPage.class);
        TempMailPage TempPg = PageFactory.initElements(driver, TempMailPage.class);

        MainPg.searchCloudCalc();
        MainPg.calcClick();

        CalcPg.CloudSite();
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        CalcPg.NumberOfInstances();
        CalcPg.OperationSystem();
        CalcPg.MachineClass();
        CalcPg.Series();
        CalcPg.MachineType();
        CalcPg.AddGPU();
        CalcPg.NumberOfGPU();
        CalcPg.GPUType();
        CalcPg.LocalSSD();
        CalcPg.DatacenterLocation();
        CalcPg.CommitedUsage();
        CalcPg.AddToEstimate();
        CalcPg.EmailEstimateButton();

        // Open site 10minutemail.com
        ((JavascriptExecutor)driver).executeScript("window.open('about:blank', '-blank')");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://temp-mail.org/ru/10minutemail");
        Thread.sleep(5000);

        TempPg.CopyEmailButton();

        // Back to Google Cloud Calculator
        driver.switchTo().window(tabs.get(0));

        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");

        CalcPg.EmailForm();
        CalcPg.EmailField();
        CalcPg.SendEmailButton();

        // Switch to 10minutemail.com
        driver.switchTo().window(tabs.get(1));

        TempPg.SearchEmail();

        Assert.assertEquals(driver.getPageSource().contains("USD 1,082.77"), true, "Estimation is not match!" );

        driver.quit();
    }

}
