import driver.DriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import model.CommitedUsage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CalcPage;
import page.MainPage;
import page.TempMailPage;
import service.CommitedUsageCreator;


import java.util.concurrent.TimeUnit;


public class CalcEstimateTestChrome extends CommonConditions {
//    static WebDriver driver;

    @Test(groups = "parallel")
    public void estimateTest() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver = DriverSingleton.getDriver();

        //Add new code for Selenium Grid
//        ChromeOptions options = new ChromeOptions();
//        try {
//            driver = new RemoteWebDriver(new 	URL("http://localhost:4444/wd/hub"), options);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://cloud.google.com/");
        driver.manage().window().maximize();

        MainPage mainPg = PageFactory.initElements(driver, MainPage.class); //replace with constrator
        CalcPage calcPg = PageFactory.initElements(driver, CalcPage.class);
        TempMailPage tempPg = PageFactory.initElements(driver, TempMailPage.class);

        mainPg.searchCloudCalc();
        mainPg.calcClick();

        calcPg.cloudSite();
        calcPg.switchToFrame();
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
        //Try to move find element to page.CalcPage - now isn't work
//        calcPg.findElement1();

        String calcEstimateCost = driver.findElement(By.xpath("//*[@id='resultBlock']//h2/b")).getText().
                replace("Total Estimated Cost: ", "").
                replace(" per 1 month", "");

        // Open site 10minutemail.com
        tempPg.openNewTab();
        driver.get("https://temp-mail.org/ru/10minutemail");

        tempPg.copyEmailButton();

        // Back to Google Cloud Calculator
        tempPg.backToCalcTab();

        calcPg.switchToFrame();

        calcPg.setEmailForm();
        calcPg.setEmailField();
        calcPg.clickSendEmailButton();

        // Switch to 10minutemail.com
        tempPg.backToMailTab();

        tempPg.searchEmail();
        //Try to move find element 2 to TempPage - now isn't work
//        tempPg.findElement2();
        String mailEstimateCost = driver.findElement(By.xpath("//*[@id='tm-body']//td[2]/h3")).getText();

        //Try to assert findElement2 and findElement1 - now isn't work
//        Assert.assertTrue(tempPg.findElement2().equals(calcPg.findElement1()));
        Assert.assertTrue(mailEstimateCost.equals(calcEstimateCost), "Estimate not match!");

//        driver.quit();
    }

}
