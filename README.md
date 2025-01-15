
[![SonarQube Cloud](https://sonarcloud.io/images/project_badges/sonarcloud-light.svg)](https://sonarcloud.io/summary/new_code?id=furkanyy_incubyte-assignment)

# Magento Web Testing Project

This project demonstrates automated testing of the Magento e-commerce platform's authentication flows using Selenium WebDriver with Java, implementing both BDD (Behavior-Driven Development) and POM (Page Object Model) patterns.

## Project Overview

The project automates testing of:
- User account creation (Sign Up)
- User authentication (Sign In)
- Account verification

Test site: https://magento.softwaretestingboard.com/


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

FurkanYY

## License

This project is licensed under the MIT License - see the LICENSE file for details


