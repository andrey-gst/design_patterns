package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
//    JavascriptExecutor js;

    protected abstract AbstractPage openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15, 50);
//        PageFactory.initElements(driver, this);
//        js = (JavascriptExecutor) driver;
    }


}
