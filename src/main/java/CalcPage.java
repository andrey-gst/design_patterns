import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalcPage extends AbstractPage{
    private final String BASE_URL = "https://cloud.google.com/";
    private WebDriverWait wait;

    public CalcPage(WebDriver driver){
        super(driver);
        wait = new WebDriverWait(this.driver, 10,50);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "input_65")
    WebElement searchNumberOfInstances;

    @FindBy(css = "#select_value_label_58 .md-text")
    WebElement searchOperationSystem;
    @FindBy(css = "#select_option_67 > .md-text")
    WebElement selectOperationSystem;

    @FindBy(css = "#select_value_label_59 > span:nth-child(1)")
    WebElement searchMachineClass;
    @FindBy(css = "#select_option_79 > .md-text")
    WebElement selectMachineClass;

    @FindBy(xpath = "//*[@id='select_value_label_61']/span[1]/div")
    WebElement searchSeries;
    @FindBy(id = "select_option_194")
    WebElement selectSeries;

    @FindBy(css = "#select_value_label_62 .md-text")
    WebElement searchMachineType;
    @FindBy(css = "#select_option_378 > .md-text")
    WebElement selectMachineType;

    @FindBy(css = ".ng-scope:nth-child(11) .md-container")
    WebElement addGPU;

    @FindBy(css = "#select_value_label_410 > span:nth-child(1)")
    WebElement searchNumberOfGPU;
    @FindBy(id = "select_option_417")
    WebElement selectNumberOfGPU;

    @FindBy(css = "#select_value_label_411 .md-text")
    WebElement searchGPUType;
    @FindBy(css = "#select_option_424 > .md-text")
    WebElement selectGPUType;

    @FindBy(css = "#select_value_label_372 > span:nth-child(1)")
    WebElement searchLocalSSD;
    @FindBy(css = "#select_option_399 > .md-text")
    WebElement selectLocalSSD;

    @FindBy(css = "#select_value_label_63 .md-text")
    WebElement searchDatacenterLocation;
    @FindBy(css = "#select_option_211 > .md-text")
    WebElement selectDatacenterLocation;

    @FindBy(css = "#select_value_label_64 > span:nth-child(1)")
    WebElement searchCommitedUsage;
    @FindBy(css = "#select_option_98 > .md-text")
    WebElement selectCommitedUsage;

    @FindBy(css = ".layout-align-end-start:nth-child(18) > .md-raised")
    WebElement clickAddToEstimate;

    @FindBy(id = "email_quote")
    WebElement searchEmailEstimateButton;

    @FindBy(name = "emailForm")
    WebElement element;

    @FindBy(id = "input_495")
    WebElement searchEmailField;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    WebElement searchSendEmailButton;

    public void cloudSite(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cloud-site")));
    }

    public void setNumberOfInstances(){
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
        wait.until(ExpectedConditions.elementToBeClickable(selectCommitedUsage)).click();
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

    public String findElement1(){
        return driver.findElement(By.xpath("//*[@id='resultBlock']//h2/b")).getText()
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
