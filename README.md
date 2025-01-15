# Magento Web Testing Project

This project demonstrates automated testing of the Magento e-commerce platform's authentication flows using Selenium WebDriver with Java, implementing both BDD (Behavior-Driven Development) and POM (Page Object Model) patterns.

## Project Overview

The project automates testing of:
- User account creation (Sign Up)
- User authentication (Sign In)
- Account verification

Test site: https://magento.softwaretestingboard.com/

## Project Structure

src/
├── main/
│ └── java/
│ ├── pages/ # Page Object Model classes
│ │ ├── MyAccountPage.java
│ │ ├── SignInPage.java
│ │ └── SignUpPage.java
│ └── toolset/ # Utility classes
│ ├── Actions.java
│ ├── UserCredentials.java
│ └── WebDriverTool.java
└── test/
├── java/
│ ├── runners/ # Cucumber test runners
│ │ └── Runner.java
│ └── steps/ # Step definitions
│ └── StepsDefinitions.java
└── resources/
└── features/ # Cucumber feature files
└── Authentication.feature



## Technologies Used

- Java 11
- Selenium WebDriver
- Cucumber (BDD)
- JUnit
- Maven

## Design Patterns

### Page Object Model (POM)
- Each web page has a corresponding Page class
- Page classes encapsulate page elements and actions
- Promotes code reuse and maintainability

### Behavior Driven Development (BDD)
- Feature files written in Gherkin syntax
- Scenarios describe user behaviors
- Step definitions link features to code

## Key Components

### Page Objects
- `SignUpPage`: Handles account creation flow
- `SignInPage`: Manages login functionality
- `MyAccountPage`: Verifies successful authentication

### Utilities
- `Actions`: Common Selenium interactions with wait strategies
- `WebDriverTool`: Browser management
- `UserCredentials`: Manages test user data

### Test Framework
- Cucumber feature files describe test scenarios
- JUnit runner executes tests
- Step definitions implement test steps

## Running Tests

1. Clone the repository
2. Install dependencies:
   ```
   mvn clean install
   ```
3. Run tests:
   ```
   mvn test
   ```

## Test Cases

The automation covers the following scenarios:
1. Successful account creation
2. Successful login with created account
3. Verification of account features

Detailed test cases are documented in the accompanying Excel file.

## Error Handling

The framework includes:
- Explicit waits for element interactions
- Proper exception handling
- Clear error messages
- Robust element location strategies

## Best Practices

- Clean code principles
- Proper documentation
- Consistent naming conventions
- Modular design
- Reusable components
- Separation of concerns

## Project Requirements

- Java 11 or higher
- Maven
- Chrome browser
- ChromeDriver matching your Chrome version

## Author

[Your Name]

## License

This project is licensed under the MIT License - see the LICENSE file for details


There is sign out button here. 

give me its element as xpath and click method with selenium. Create a method in MyAccountsPage.java by using clickField() of Actions.java. create an element of the signout button


Looking at the HTML, I can see the sign out button has a specific structure. I'll help you add the sign out functionality to the MyAccountPage class.
}
I've added:
A constant SIGN_OUT_BUTTON with the XPath that targets the sign out link in the header panel
A method clickSignOutButton() that uses the existing Actions.clickField() method to click the sign out button
The XPath //div[@class='panel
header']//a[
contains(text(),'
Sign Out')] works by:- Finding a div with class 'panel header'- Looking for an anchor tag (a) inside that div- Finding the anchor tag that contains the text 'Sign Out'This should reliably find and click the sign out button in the header of the My Account page.
x path element did not work because it is not interatable. you should first click arrow  "action switch" and then the drop down menu displays which includes sign out button

Ah, I see. Looking at the HTML structure, we need to first click the "Change" button (action switch) to open the dropdown menu, and then click the sign-out button. Let me modify the MyAccountPage class to handle this two-step process.
The changes I made:
Added CHANGE_BUTTON XPath to locate the "Change" button with class "action switch"
Updated SIGN_OUT_BUTTON XPath to find the sign-out link within the customer menu dropdown
Modified clickSignOutButton() to first click the change button to open the dropdown, then click the sign-out button
The new XPaths:
CHANGE_BUTTON: "//button[@class='action switch']" - finds the button with class "action switch"
SIGN_OUT_BUTTON: "//div[contains(@class, 'customer-menu')]//a[contains(text(),'Sign Out')]" - finds the sign-out link within the customer menu dropdown
This should now properly handle the dropdown menu interaction before clicking the sign-out button.
1. create another page class for sign out page as MyAccountPage.java.

you can see details of the page in the latest html file addded 

2. create a method which verifies that sign out page is displayed. you can use methods in Actions

Looking at the HTML, I'll create a SignOutPage class to handle verification of the sign-out page. I'll use the page title or content to verify the sign-out was successful.
}
I've created the SignOutPage class with:
Constants for verification:
SIGN_OUT_MESSAGE: The message that appears when successfully signed out
HOME_PAGE_CONTENT: Additional content that appears on the home page after sign out
A verification method:
verifySignOut(): Uses the verifyResults() method from Actions class to check for both the sign-out message and home page content, ensuring the user is truly signed out and redirected to the home page
This will help verify that:
1. The sign-out was successful
The user was redirected to the home page
The session was properly terminated
The verification checks for multiple elements to ensure a robust test that confirms the sign-out functionality is working as expected.
add a method in webdriver tool class which removes all cookies 

I'll add a method to clear cookies in the WebDriverTool class. This is useful for sign-out functionality to ensure all session data is properly cleared.
I've added:
A new method clearCookies() that:
Checks if the driver exists
If it does, deletes all cookies from the current browser session
This helps ensure clean sign-out by removing all session data
This method can be called after sign-out to ensure all session cookies are properly cleared, which is a good practice for testing authentication flows.
I want to run sign up scenario first

I'll help you create a new feature file that combines both scenarios in the correct order and update the existing feature files.
page
You can delete the individual SignUp.feature and SignIn.feature files since we're combining them into a single flow.
This new feature file:
First executes the sign-up scenario
Then signs out to clear the session
Finally tests the sign-in with the newly created account
This ensures that:
The account is created before trying to sign in
2. The tests run in a logical order
We test the complete user authentication flow
We verify the sign-out functionality between sign-up and sign-in
Would you like me to also show the corresponding step definitions that would be needed for this new feature file?
webpage includes stability issue. this causes the flakiness. to use before before clicking buttons in page objects, create a implicit wait in actions class  

I'll add an implicit wait method to the Actions class to help handle timing issues and flakiness.
Key changes made:
Added TIMEOUT_SECONDS constant to define wait duration
Created a new private method waitForElement() that:
Takes a By locator as parameter
Creates a WebDriverWait with specified timeout
Waits for element to be clickable
Returns the WebElement when ready
Modified existing methods to use the wait:
fillField() now waits for element to be clickable before sending keys
clickField() waits for element to be clickable before clicking
pressEnter() waits for element to be clickable before sending ENTER key
This should help with:
Timing issues
Element not clickable exceptions
Stale element exceptions
General stability of the test execution
The implicit wait will ensure elements are ready for interaction before attempting to use them, reducing flakiness in the tests.
add thread wait

I'll add a thread sleep utility method to the Actions class for cases where we need an explicit wait. While implicit waits are preferred, sometimes a brief thread sleep is necessary for stability.
6 hidden lines
3 hidden lines
Changes made:
Added THREAD_SLEEP_MILLIS constant (1 second default)
Added waitForPageLoad() method that implements Thread.sleep with proper exception handling
Added the wait:
After clicking elements (in clickField())
Before verifying results (in verifyResults())
This combination of implicit waits and brief thread sleeps should help with:
Page load timing issues
AJAX updates
Dynamic content loading
General stability of the test execution
The thread sleep is particularly useful:
After clicks that trigger page loads
Before verifications to ensure content is fully loaded
When dealing with dynamic JavaScript updates
verifyResults method raises code quality issues, rewrite the method

I'll rewrite the verifyResults method to improve code quality by making it more robust and following better practices.
Key improvements in the verifyResults method:
Added proper JavaDoc documentation
Removed redundant null check
Added explicit wait for text to appear
Improved error message with specific details
Used String.format for better message formatting
Removed try-catch block and let assertions throw naturally
Renamed parameter to be more descriptive
Made the method more focused on a single responsibility
The new method:
Waits for text to appear before asserting
Provides clearer error messages
Is more reliable due to the wait
Follows better coding practices
Has improved readability and maintainability
make it without assertion. code analysis tool says "Assertions are intended to be used in test code, but not in production code. It is confusing, and might lead to ClassNotFoundException when the build tools only provide the required dependency in test scope.
In addition, assertions will throw a sub-class of Error: AssertionError, which should be avoided in production code.
This rule raises an issue when any assertion intended to be used in test is used in production code.
Supported frameworks:
JUnit
FestAssert
AssertJ
Note: this does not apply for assert from Java itself or if the source code package name is related to tests (contains: test or assert or junit)."

I'll rewrite the verifyResults method to avoid using assertions in production code and instead use standard exception handling.
Key changes:
Removed JUnit Assertions import and usage
Removed test-specific assertion
Added proper exception handling with IllegalStateException
Improved error messages with more context
Maintained the wait functionality for stability
Added better JavaDoc documentation
The new method:
Uses standard Java exceptions instead of test assertions
Provides clear error messages
Maintains the same verification functionality
Follows production code best practices
Is more appropriate for a production utility class
This version should resolve the code analysis concerns while maintaining the same functionality.
write a readme file for all project. assignment expectations

"Objective: Test the sign up flow.

Task: Automate creating an account on the website https://magento.softwaretestingboard.com/ and signing in with that account.

Deliverables:

Test Cases: Document your test cases in an Excel file.

Automation Code: Provide a link to your GitHub repository where you have committed the automation code using any available framework (e.g., Selenium, Cypress) for your test cases.

Ensure to use BDD (Behavior-Driven Development) to structure your test cases and both BDD and POM(Page Object Model) for test scripts.

Additional Tips:

Clarity: Ensure the code is clear and understandable.
Error Handling: Ensure that the code is error-free and robust.
Structuring: Ensure that the repository is well-structured and formatted. Please do not submit single-file code; submit the entire repository.
"

I'll help you create a comprehensive README.md file for your project.
src/
├── main/
│ └── java/
│ ├── pages/ # Page Object Model classes
│ │ ├── MyAccountPage.java
│ │ ├── SignInPage.java
│ │ └── SignUpPage.java
│ └── toolset/ # Utility classes
│ ├── Actions.java
│ ├── UserCredentials.java
│ └── WebDriverTool.java
└── test/
├── java/
│ ├── runners/ # Cucumber test runners
│ │ └── Runner.java
│ └── steps/ # Step definitions
│ └── StepsDefinitions.java
└── resources/
└── features/ # Cucumber feature files
└── Authentication.feature
:
bash
mvn clean install
3. Run tests:
bash
mvn test
details
This README provides:
Clear project overview
Detailed structure explanation
Technology stack
Design patterns used
Component descriptions
Setup and execution instructions
Test coverage
Best practices followed