import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    final WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, 15, 50);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "q")
    WebElement searchInput;

    @FindBy(linkText = "Google Cloud Platform Pricing Calculator")
    WebElement clickCalcLink;

    public void searchCloudCalc(){
        searchInput.sendKeys("Google Cloud Platform Pricing Calculator");
        searchInput.sendKeys(Keys.ENTER);
    }

    public void calcClick(){
        wait.until(ExpectedConditions.elementToBeClickable(clickCalcLink)).click();
    }

}
