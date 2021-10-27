package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static service.CommitedUsageCreator.COMMITED_USAGE;

public class CalcPage extends AbstractPage{
    private final String BASE_URL = "https://cloud.google.com/";

    private final Logger logger = LogManager.getRootLogger();

    public CalcPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(name = "quantity")
    WebElement searchNumberOfInstances;

    @FindBy(xpath = "//div[@class='md-text' and contains(text(), 'Free')]")
    WebElement searchOperationSystem;
    @FindBy(xpath = "//md-option[@value='free']")
    WebElement selectOperationSystem;

    @FindBy(xpath = "//*[contains(text(),'Regular')]")
    WebElement searchMachineClass;
    @FindBy(xpath = "(//md-option[@value='regular'])[2]")
    WebElement selectMachineClass;

    @FindBy(xpath = "//*[contains(text(),'E2')]")
    WebElement searchSeries;
    @FindBy(xpath = "//md-option[@value='n1']")
    WebElement selectSeries;

    @FindBy(xpath = "//*[contains(text(),'n1-standard-1 (vCPUs: 1, RAM: 3.75GB)')]")
    WebElement searchMachineType;
    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    WebElement selectMachineType;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    WebElement addGPU;

    @FindBy(xpath = "(//md-select[@placeholder='Number of GPUs']//div[contains(text(),'0')])[1]")
    WebElement searchNumberOfGPU;
    @FindBy(css = "md-option[value='1'][class='ng-scope md-ink-ripple'][ng-disabled]")
    WebElement selectNumberOfGPU;

    @FindBy(xpath = "//div[1]/div[1]/md-input-container[2]/md-select/md-select-value/span[1]/div")
    WebElement searchGPUType;
    @FindBy(xpath = "//*[@class='md-text ng-binding' and contains(text(),'NVIDIA Tesla T4')]")
    WebElement selectGPUType;

    @FindBy(xpath = "(//md-select[@placeholder='Local SSD']//div[contains(text(),'0')])[1]")
    WebElement searchLocalSSD;
    @FindBy(xpath = "//*[@class='md-text ng-binding' and contains(text(),'2x375 GB')]")
    WebElement selectLocalSSD;

    @FindBy(xpath = "(//md-select[@placeholder='Datacenter location'])[1]")
    WebElement searchDatacenterLocation;
    @FindBy(xpath = "(//md-option[@value='europe-west3'])[3]")
    WebElement selectDatacenterLocation;

    @FindBy(xpath = "(//md-select[@placeholder='Committed usage'])[1]")
    WebElement searchCommitedUsage;
    @FindBy(xpath = "(//*[@class='md-text' and contains(text(),'1 Year')])[2]")
    WebElement selectCommitedUsageOneYear;
    @FindBy(xpath = "(//*[@class='md-text' and contains(text(),'3 Years')])[2]")
    WebElement selectCommitedUsageThreeYears;


    @FindBy(xpath = "(//button[@aria-label='Add to Estimate'])[1]")
    WebElement clickAddToEstimate;

    @FindBy(id = "email_quote")
    WebElement searchEmailEstimateButton;

    @FindBy(name = "emailForm")
    WebElement element;

    @FindBy(xpath = "//input[@type='email']")
    WebElement searchEmailField;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    WebElement searchSendEmailButton;

    @FindBy(xpath = "//*[@id='resultBlock']//h2/b")
    WebElement searchCalcEstimate;

    public void cloudSite(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cloud-site")));
    }

    public void setNumberOfInstances(){
        logger.info("Set number of instances");
        //Add actions implementation for mouse and keyboard
        new Actions(driver).click(searchNumberOfInstances).build().perform();
        new Actions(driver).sendKeys(searchNumberOfInstances, "4").build().perform();
    }

    public void setOperationSystem(){
        wait.until(ExpectedConditions.elementToBeClickable(searchOperationSystem)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectOperationSystem)).click();
    }

    public void setMachineClass(){
        wait.until(ExpectedConditions.elementToBeClickable(searchMachineClass)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectMachineClass)).click();
    }

    public void setSeries(){
        wait.until(ExpectedConditions.elementToBeClickable(searchSeries)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectSeries)).click();
    }

    public void setMachineType(){
        wait.until(ExpectedConditions.elementToBeClickable(searchMachineType)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectMachineType)).click();
    }

    public void setAddGPU(){
        wait.until(ExpectedConditions.elementToBeClickable(addGPU)).click();
    }

    public void setNumberOfGPU(){
        wait.until(ExpectedConditions.elementToBeClickable(searchNumberOfGPU)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectNumberOfGPU)).click();
    }

    public void setGPUType(){
        wait.until(ExpectedConditions.elementToBeClickable(searchGPUType)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectGPUType)).click();
    }

    public void setLocalSSD(){
        wait.until(ExpectedConditions.elementToBeClickable(searchLocalSSD)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectLocalSSD)).click();
    }

    public void setDatacenterLocation(){
        wait.until(ExpectedConditions.elementToBeClickable(searchDatacenterLocation)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectDatacenterLocation)).click();
    }

    public void setCommitedUsage(){
        wait.until(ExpectedConditions.elementToBeClickable(searchCommitedUsage)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectCommitedUsageOneYear)).click();
    }

    public void setAddToEstimate(){
        wait.until(ExpectedConditions.elementToBeClickable(clickAddToEstimate)).click();
    }

    public void setEmailEstimateButton(){
        wait.until(ExpectedConditions.elementToBeClickable(searchEmailEstimateButton)).click();
    }

    public void setEmailForm(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void setEmailField(){
        searchEmailField.sendKeys(Keys.chord(Keys.CONTROL, "v"));
    }

    public void clickSendEmailButton(){
        searchSendEmailButton.click();
    }

    public String getCalcEstimate(){
        return searchCalcEstimate.getText()
                .replace("Total Estimated Cost: ", "")
                .replace(" per 1 month", "");
    }

    public void switchToFrame(){
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
    }

    @Override
    protected CalcPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }
}
