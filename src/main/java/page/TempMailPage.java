package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class TempMailPage extends AbstractPage{
    JavascriptExecutor js;
    private final String BASE_URL = "https://temp-mail.org/ru/10minutemail";

    public TempMailPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    @FindBy(css = "div.input-box-col.hidden-xs-sm > button")
    WebElement searchCopyEmailButton;

    @FindBy(linkText = "Google Cloud Platform Price Estimate")
    WebElement searchEmail;

    @FindBy(xpath = "//*[@id='tm-body']//td[2]/h3")
    WebElement searchMailEstimate;

    public void copyEmailButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mail")));
        searchCopyEmailButton.click();
    }

    public void searchEmail(){
        js.executeScript("arguments[0].scrollIntoView();", searchEmail);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Google Cloud Platform Price Estimate")));
        searchEmail.click();
    }

    public String getMailEstimate(){
        return searchMailEstimate.getText();
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

    @Override
    protected TempMailPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

}
