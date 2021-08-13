package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page.CalcPage;
import page.MainPage;
import page.TempMailPage;

public class GoogleCalcStepdefs {

    private CalcPage calcPage = new CalcPage();
    private MainPage mainPage = new MainPage();
    private TempMailPage tempMailPage = new TempMailPage();

    @Given("I opened Google Cloud site")
    public void iOpenedGoogleCloudSite() {
        mainPage.open();
    }

    @When("I search Google Cloud Platform Pricing Calculator")
    public void iSearchGoogleCloudPlatformPricingCalculator() {
        mainPage.searchCloudCalc();
    }

    @And("I open Google Cloud Pricing Calculator page")
    public void iOpenGoogleCloudPricingCalculatorPage() {
        mainPage.calcClick();
    }

    @And("I enter Compute Engine parameters")
    public void iEnterComputeEngineParameters() {
        calcPage.cloudSite();
        calcPage.switchToFrame();
        calcPage.setNumberOfInstances();
        calcPage.setOperationSystem();
        calcPage.setMachineClass();
        calcPage.setSeries();
        calcPage.setMachineType();
        calcPage.setAddGPU();
        calcPage.setNumberOfGPU();
        calcPage.setGPUType();
        calcPage.setLocalSSD();
        calcPage.setDatacenterLocation();
        calcPage.setCommitedUsage();
        calcPage.setAddToEstimate();
    }

    @And("I send Email Estimete")
    public void iSendEmailEstimete() {
        calcPage.setEmailEstimateButton();
    }

    @And("I opened Email letter")
    public void iOpenedEmailLetter() {
        tempMailPage.openNewTab();
        tempMailPage.open();
        tempMailPage.copyEmailButton();
        tempMailPage.backToCalcTab();
        calcPage.switchToFrame();
        calcPage.setEmailForm();
        calcPage.setEmailField();
        calcPage.clickSendEmailButton();
        tempMailPage.backToMailTab();
        tempMailPage.searchEmail();
    }

    @Then("Calculator Estimate equals to Email Estimate")
    public void calculatorEstimateEqualsToEmailEstimate() {
        String mailEstimate = new TempMailPage().getMailEstimate();
        String calcEstimate = new CalcPage().getCalcEstimate();
        Assert.assertEquals(mailEstimate,calcEstimate, "Estimate not match!");
    }
}
