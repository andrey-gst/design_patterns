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
    @Given("I opened Google Cloud site")
    public void iOpenedGoogleCloudSite() {
        new MainPage().open();
    }

    @When("I search Google Cloud Platform Pricing Calculator")
    public void iSearchGoogleCloudPlatformPricingCalculator() {
        new MainPage().searchCloudCalc();
    }

    @And("I open Google Cloud Pricing Calculator page")
    public void iOpenGoogleCloudPricingCalculatorPage() {
        new MainPage().calcClick();
    }

    @And("I enter Compute Engine parameters")
    public void iEnterComputeEngineParameters() {
        new CalcPage().cloudSite();
        new CalcPage().switchToFrame();
        new CalcPage().setNumberOfInstances();
        new CalcPage().setOperationSystem();
        new CalcPage().setMachineClass();
        new CalcPage().setSeries();
        new CalcPage().setMachineType();
        new CalcPage().setAddGPU();
        new CalcPage().setNumberOfGPU();
        new CalcPage().setGPUType();
        new CalcPage().setLocalSSD();
        new CalcPage().setDatacenterLocation();
        new CalcPage().setCommitedUsage();
        new CalcPage().setAddToEstimate();
    }

    @And("I send Email Estimete")
    public void iSendEmailEstimete() {
        new CalcPage().setEmailEstimateButton();
    }

    @And("I opened Email letter")
    public void iOpenedEmailLetter() {
        new TempMailPage().openNewTab();
        new TempMailPage().open();
        new TempMailPage().copyEmailButton();
        new TempMailPage().backToCalcTab();
        new CalcPage().switchToFrame();
        new CalcPage().setEmailForm();
        new CalcPage().setEmailField();
        new CalcPage().clickSendEmailButton();
        new TempMailPage().backToMailTab();
        new TempMailPage().searchEmail();
    }

    @Then("Calculator Estimate equals to Email Estimate")
    public void calculatorEstimateEqualsToEmailEstimate() {
        String mailEstimate = new TempMailPage().getMailEstimate();
        String calcEstimate = new CalcPage().getCalcEstimate();
        Assert.assertEquals(mailEstimate,calcEstimate, "Estimate not match!");
    }
}
