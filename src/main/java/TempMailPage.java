import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class TempMailPage {
    final WebDriver driver;
    private WebDriverWait wait;
    JavascriptExecutor js;

    public TempMailPage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, 15, 50);
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }


    @FindBy(css = "div.input-box-col.hidden-xs-sm > button")
    WebElement searchCopyEmailButton;

    @FindBy(linkText = "Google Cloud Platform Price Estimate")
    WebElement searchEmail;

    public void copyEmailButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mail")));
        searchCopyEmailButton.click();
    }

    public void searchEmail(){
        js.executeScript("window.scrollTo(0,76)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Google Cloud Platform Price Estimate")));
        searchEmail.click();
    }

    public String findElement2(){
        return driver.findElement(By.xpath("//*[@id='tm-body']//td[2]/h3")).getText();
    }

    public void openNewTab(){
        ((JavascriptExecutor)driver).executeScript("window.open('about:blank', '-blank')");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void backToCalcTab(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public void backToMailTab(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

}
