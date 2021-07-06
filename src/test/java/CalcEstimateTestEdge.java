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

    @Test(groups = "parallel")
    public static void main() {
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

        String Element1 = driver.findElement(By.xpath("//*[@id='resultBlock']//h2/b")).getText().
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
        String Element2 = driver.findElement(By.xpath("//*[@id='tm-body']//td[2]/h3")).getText();

        //Try to assert findElement2 and findElement1 - now isn't work
//        Assert.assertTrue(tempPg.findElement2().equals(calcPg.findElement1()));
        Assert.assertTrue(Element2.equals(Element1), "Estimate not match!");

        driver.quit();
    }

}
