import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TempMailPage {
    final WebDriver driver;
    private WebDriverWait wait;

    public TempMailPage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, 15, 50);
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "copy_address")
    WebElement searchCopyEmailButton;

    @FindBy(xpath = "//*[text()='Google Cloud Platform Price Estimate']")
    WebElement searchEmail;

    public void CopyEmailButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mail_address")));
        searchCopyEmailButton.click();
    }

    public void SearchEmail(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Google Cloud Platform Price Estimate']")));
        searchEmail.click();
    }

}
