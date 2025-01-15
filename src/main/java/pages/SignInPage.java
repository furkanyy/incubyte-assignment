package pages;

import toolset.Actions;
import toolset.WebDriverTool;
import toolset.UserCredentials;

public class SignInPage {

    /**
     * UI components.
     */
    private static final String SIGN_IN_PAGE_URL = "/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2NyZWF0ZS8%2C/";
    private static final String EMAIL_FIELD = "email";
    private static final String PASSWORD_FIELD = "pass";
    private static final String SIGN_IN_BUTTON = "//button[@type='submit' and @class='action login primary']";


    /**
     * go to the sign-in page
     */
    public void goToSignInPage() {
        WebDriverTool.setDriver(SIGN_IN_PAGE_URL);
    }

    /**
     * fills the email field
     */
    public void fillEmailField() {
        Actions.fillField(EMAIL_FIELD, UserCredentials.getEmail());
    }

    /**
     * fills the password field
     */
    public void fillPasswordField() {
        Actions.fillField(PASSWORD_FIELD, UserCredentials.getPassword());
    }

    /**
     * click on the Sign-In button
     */
    public void clickSignInButton() {
        Actions.clickField(SIGN_IN_BUTTON);
    }
}
