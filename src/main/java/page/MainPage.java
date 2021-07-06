package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {

    private WebDriverWait wait;

    public MainPage(WebDriver driver){
        super(driver);
        wait = new WebDriverWait(this.driver, 15, 50);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(name = "q")
    WebElement searchInput;

    @FindBy(linkText = "Google Cloud Platform Pricing Calculator")
    WebElement clickCalcLink;

    public void searchCloudCalc(){
        //Add JS Executor - Highlighting for Search field
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", searchInput);
        searchInput.sendKeys("Google Cloud Platform Pricing Calculator");
        searchInput.sendKeys(Keys.ENTER);
    }

    public void calcClick(){
        wait.until(ExpectedConditions.elementToBeClickable(clickCalcLink));
        //Add JS Executor - click element
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", clickCalcLink);
    }

    @Override
    protected MainPage openPage() {
        return this;
    }

}
