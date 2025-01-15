package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MyAccountPage;
import pages.SignInPage;
import pages.SignUpPage;
import toolset.WebDriverTool;

public class StepsDefinitions {

    SignUpPage signUpPage = new SignUpPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    SignInPage  signInPage = new SignInPage();

    @Given("^the user is on the sign-up page$")
    public void theUserIsOnTheSignUpPage() {
        signUpPage.goToSignUpPage();
    }

    @When("the user fills the required fields")
    public void theUserFillsTheRequiredFields() {
        signUpPage.fillNameField();
        signUpPage.fillLastNameField();
        signUpPage.fillEmailField();
        signUpPage.fillPasswordField();
        signUpPage.fillPasswordConfirmationField();
    }

    @And("the user clicks on the create an account button")
    public void theUserClicksOnTheCreateAnAccountButton() {
        signUpPage.clickSubmitButton();
    }

    @Then("the user should be redirected to the my account page")
    public void theUserShouldBeRedirectedToTheMyAccountPage() {
        myAccountPage.checkMyAccountPage();
        WebDriverTool.closeDriver();
    }

    @Given("the user is on the sign-in page")
    public void theUserIsOnTheSignInPage() {
        signInPage.goToSignInPage();
    }

    @When("the user enters a valid credentials")
    public void theUserEntersAValidCredentials() {
        signInPage.fillEmailField();
        signInPage.fillPasswordField();
    }

    @And("the user clicks on the sign in button")
    public void theUserClicksOnTheSignInButton() {
        signInPage.clickSignInButton();
    }
}
