import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CalcPage;
import page.MainPage;
import page.TempMailPage;

import java.util.concurrent.TimeUnit;


public class CalcEstimateTestEdge {
    static WebDriver driver;
    MainPage mainPg;
    CalcPage calcPg;
    TempMailPage tempPg;

    @Test(groups = "parallel")
    public void estimateTest() {
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

        driver.quit();
    }

}
