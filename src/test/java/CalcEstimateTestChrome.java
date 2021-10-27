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
    MainPage mainPg;
    CalcPage calcPg;
    TempMailPage tempPg;
    
    @Test(groups = "parallel")
    public void estimateTest() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://cloud.google.com/");
        driver.manage().window().maximize();

        mainPg = new MainPage(driver);
        calcPg = new CalcPage(driver);
        tempPg = new TempMailPage(driver);

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

        // Open site 10minutemail.com
        tempPg.openNewTab();
        driver.get("https://temp-mail.org/ru/10minutemail");
        Thread.sleep(2500);
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

        Assert.assertEquals(tempPg.getMailEstimate(), calcPg.getCalcEstimate(), "Estimate not match!");
    }

}
