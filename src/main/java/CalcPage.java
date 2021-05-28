import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalcPage {
    final WebDriver driver;
    private WebDriverWait wait;

    public CalcPage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, 15,50);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input_66")
    WebElement searchNumberOfInstances;

    @FindBy(css = "#select_value_label_59 .md-text")
    WebElement searchOperationSystem;
    @FindBy(css = "#select_option_68 > .md-text")
    WebElement selectOperationSystem;

    @FindBy(css = "#select_value_label_60 > span:nth-child(1)")
    WebElement searchMachineClass;
    @FindBy(css = "#select_option_81 > .md-text")
    WebElement selectMachineClass;

    @FindBy(xpath = "//*[@id='select_value_label_62']/span[1]/div")
    WebElement searchSeries;
    @FindBy(id = "select_option_195")
    WebElement selectSeries;

    @FindBy(css = "#select_value_label_63 .md-text")
    WebElement searchMachineType;
    @FindBy(css = "#select_option_376 > .md-text")
    WebElement selectMachineType;

    @FindBy(css = ".ng-scope:nth-child(10) .md-container")
    WebElement addGPU;

    @FindBy(css = "#select_value_label_408 > span:nth-child(1)")
    WebElement searchNumberOfGPU;
    @FindBy(id = "select_option_415")
    WebElement selectNumberOfGPU;

    @FindBy(css = "#select_value_label_409 .md-text")
    WebElement searchGPUType;
    @FindBy(css = "#select_option_422 > .md-text")
    WebElement selectGPUType;

    @FindBy(css = "#select_value_label_370 > span:nth-child(1)")
    WebElement searchLocalSSD;
    @FindBy(css = "#select_option_397 > .md-text")
    WebElement selectLocalSSD;

    @FindBy(css = "#select_value_label_64 .md-text")
    WebElement searchDatacenterLocation;
    @FindBy(css = "#select_option_212 > .md-text")
    WebElement selectDatacenterLocation;

    @FindBy(css = "#select_value_label_65 > span:nth-child(1)")
    WebElement searchCommitedUsage;
    @FindBy(css = "#select_option_100 > .md-text")
    WebElement selectCommitedUsage;

    @FindBy(css = ".layout-align-end-start:nth-child(17) > .md-raised")
    WebElement clickAddToEstimate;

    @FindBy(id = "email_quote")
    WebElement searchEmailEstimateButton;

    @FindBy(name = "emailForm")
    WebElement element;

    @FindBy(id = "input_493")
    WebElement searchEmailField;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    WebElement searchSendEmailButton;

    public void NumberOfInstances(){
        searchNumberOfInstances.click();
        searchNumberOfInstances.sendKeys(Keys.ENTER, "4");
    }

    public void OperationSystem(){
        wait.until(ExpectedConditions.elementToBeClickable(searchOperationSystem)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectOperationSystem)).click();
    }

    public void MachineClass(){
        wait.until(ExpectedConditions.elementToBeClickable(searchMachineClass)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectMachineClass)).click();
    }

    public void Series(){
        wait.until(ExpectedConditions.elementToBeClickable(searchSeries)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectSeries)).click();
    }

    public void MachineType(){
        wait.until(ExpectedConditions.elementToBeClickable(searchMachineType)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectMachineType)).click();
    }

    public void AddGPU(){
        wait.until(ExpectedConditions.elementToBeClickable(addGPU)).click();
    }

    public void NumberOfGPU(){
        wait.until(ExpectedConditions.elementToBeClickable(searchNumberOfGPU)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectNumberOfGPU)).click();
    }

    public void GPUType(){
        wait.until(ExpectedConditions.elementToBeClickable(searchGPUType)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectGPUType)).click();
    }

    public void LocalSSD(){
        wait.until(ExpectedConditions.elementToBeClickable(searchLocalSSD)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectLocalSSD)).click();
    }

    public void DatacenterLocation(){
        wait.until(ExpectedConditions.elementToBeClickable(searchDatacenterLocation)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectDatacenterLocation)).click();
    }

    public void CommitedUsage(){
        wait.until(ExpectedConditions.elementToBeClickable(searchCommitedUsage)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectCommitedUsage)).click();
    }

    public void AddToEstimate(){
        wait.until(ExpectedConditions.elementToBeClickable(clickAddToEstimate)).click();
    }

    public void EmailEstimateButton(){
        wait.until(ExpectedConditions.elementToBeClickable(searchEmailEstimateButton)).click();
    }

    public void EmailForm(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void EmailField(){
        searchEmailField.sendKeys(Keys.chord(Keys.CONTROL, "v"));
    }

    public void SendEmailButton(){
        searchSendEmailButton.click();
    }

}
