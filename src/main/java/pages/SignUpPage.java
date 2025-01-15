package pages;

import toolset.Actions;
import toolset.WebDriverTool;
import toolset.UserCredentials;

public class SignUpPage {

    /**
     * UI components.
     */
    private static final String SIGN_UP_PAGE_URL = "/customer/account/create/";
    private static final String NAME_FIELD = "firstname";
    private static final String NAME_VALUE = "tim";
    private static final String LAST_NAME_FIELD = "lastname";
    private static final String LAST_NAME_VALUE = "salter";
    private static final String EMAIL_FIELD = "email_address";
    private static final String PASSWORD_FIELD = "password";
    private static final String PASSWORD_VALUE = "Loremimpusdolor1";
    private static final String PASSWORD_CONFIRMATION_FIELD = "password-confirmation";
    private static final String SUBMIT_BUTTON = "//button[@type='submit' and @class='action submit primary']";


    /**
     * go to the create account page
     */
    public void goToSignUpPage() {
        WebDriverTool.setDriver(SIGN_UP_PAGE_URL);
    }

    /**
     * fills the first name field
     */
    public void fillNameField() {
        Actions.fillField(NAME_FIELD, NAME_VALUE);
    }

    /**
     * fills the last name field
     */
    public void fillLastNameField() {
        Actions.fillField(LAST_NAME_FIELD, LAST_NAME_VALUE);
    }

    /**
     * fills the email field with dynamic email
     */
    public void fillEmailField() {
        String email = UserCredentials.generateRandomEmail();
        UserCredentials.setCredentials(email, PASSWORD_VALUE);
        Actions.fillField(EMAIL_FIELD, email);
    }

    /**
     * fills the password field
     */
    public void fillPasswordField() {
        Actions.fillField(PASSWORD_FIELD, UserCredentials.getPassword());
    }

    /**
     * fills the password confirmation field
     */
    public void fillPasswordConfirmationField() {
        Actions.fillField(PASSWORD_CONFIRMATION_FIELD, UserCredentials.getPassword());
    }

    /**
     * click on the create an account button
     */
    public void clickSubmitButton() {
        Actions.clickField(SUBMIT_BUTTON);
    }
}
