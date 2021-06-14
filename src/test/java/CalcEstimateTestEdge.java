import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@Test
public class CalcEstimateTestEdge {
    static WebDriver driver;

    @Test(groups = "parallel")
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();

        //Add new code for Selenium Grid
//        EdgeOptions options = new EdgeOptions();
//        try {
//            driver = new RemoteWebDriver(new 	URL("http://localhost:4444/wd/hub"), options);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://cloud.google.com/");
        driver.manage().window().maximize();

        MainPage mainPg = PageFactory.initElements(driver, MainPage.class);
        CalcPage calcPg = PageFactory.initElements(driver, CalcPage.class);
        TempMailPage tempPg = PageFactory.initElements(driver, TempMailPage.class);

        mainPg.searchCloudCalc();
        mainPg.calcClick();

        calcPg.cloudSite();
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        calcPg.setNumberOfInstances();
        calcPg.setOperationSystem();
        calcPg.setMachineClass();
        calcPg.setSeries();
        calcPg.setMachineType();
        calcPg.setAddGPU();
        calcPg.setNumberOfGPU();
        calcPg.setGPUType();
        calcPg.setLocalSSD();
        calcPg.setDatacenterLocation();
        calcPg.setCommitedUsage();
        calcPg.setAddToEstimate();
        calcPg.setEmailEstimateButton();

        // Open site 10minutemail.com
        ((JavascriptExecutor)driver).executeScript("window.open('about:blank', '-blank')");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://temp-mail.org/ru/10minutemail");
        Thread.sleep(5000);

        tempPg.copyEmailButton();

        // Back to Google Cloud Calculator
        driver.switchTo().window(tabs.get(0));

        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");

        calcPg.setEmailForm();
        calcPg.setEmailField();
        calcPg.clickSendEmailButton();

        // Switch to 10minutemail.com
        driver.switchTo().window(tabs.get(1));

        tempPg.searchEmail();

        Assert.assertEquals(driver.getPageSource().contains("USD 1,082.77"), true, "Estimation is not match!" );

        driver.quit();
    }

}
