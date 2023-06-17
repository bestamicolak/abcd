package abcd.step_definitions;

import abcd.utilities.CommonSteps;
import abcd.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ExeterUniversityTask extends CommonSteps {

    //Image Base Approach
    //I used "Sikuli" image base approach for automation of the test
    //I added a method to the utilities. I interact with the web Element by using their images
    //Because there is a "Canvas" in the "DOM" structure which does not let me interact with the Web Element

    @Given("user types the web link as {string}")
    public void user_types_the_web_link_as(String WebAddress) {
        driver.get(WebAddress);
    }

    @When("the user clicks on privacy policy")
    public void the_user_clicks_on_privacy_policy() {
        clickOnImage("privacyPolicyLink");
    }

    @Then("user comes back to previous tab and clicks on accept button and clicks on accept terms and conditions")
    public void user_comes_back_to_previous_tab_and_clicks_on_accept_button_and_clicks_on_accept_terms_and_conditions() {
        switchToWindow("University of Exeter App");
        clickOnImage("acceptButton");
        clickOnImage("termsAndContinueButton");
    }

    @Then("user clicks on data Data Protection and Privacy Policy")
    public void user_clicks_on_data_data_protection_and_privacy_policy() {
        clickOnImage("dataProtectionLink");
    }

    @Then("user clicks the back button")
    public void user_clicks_the_back_button() {
        switchToWindow("Terms and Conditions: University of Exeter App");
        driver.navigate().back();
    }

    @Then("user clicks on accept terms and continue check box and clicks on University of Exeter email button")
    public void user_clicks_on_accept_terms_and_continue_check_box_and_clicks_on_university_of_exeter_email_button() {
        clickOnImage("acceptTermsAndContinueCheckbox");
        clickOnImage("universityOfExeterEmailButton");
    }
    @Then("user clicks on AzureAD button")
    public void user_clicks_on_azure_ad_button() {
        driver.findElement(By.xpath("(//input[@value=\"AzureAD\"])[2]")).click();
    }
    @Then("user verifies the {string} title")
    public void user_verifies_the_title(String singIn) {
       WebElement signInTitle=driver.findElement(By.cssSelector("[id=\"bannerLogo\"]"));
       waitForVisibility(signInTitle,5);
       Assert.assertTrue(signInTitle.isDisplayed());
    }



}







