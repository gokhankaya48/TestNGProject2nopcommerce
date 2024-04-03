Test Automation Project Nopcommerce
Overview
This project aims to automate the testing of an e-commerce website using Java, Selenium WebDriver, and TestNG. It encompasses a suite of test cases covering various functionalities such as user registration, login/logout, product search, menu navigation, and shopping cart operations.

Features
User Registration: Validates the user registration process by filling out the required details.
Successful Login: Confirms successful login with valid credentials.
Invalid Login Attempt: Checks the system response to invalid login attempts.
Menu Verification: Verifies the functionality of menu items and submenus for seamless navigation.
Search Functionality: Tests the search box functionality and verifies search results.
Gift Card Shopping: Ensures the smooth operation of purchasing gift cards.
Build Your Own Computer: Validates the customization and purchase process of a custom-built computer.
Technologies Used
Java: Core programming language for test implementation.
Selenium WebDriver: Automation tool for web application testing.
TestNG: Testing framework for organizing and executing test cases.
Apache POI: Library for reading data from Excel files.
JavaScriptExecutor: Facilitates interaction with web elements using JavaScript.
Project Structure
src/main/java: Contains the main Java code.
pages: Page object classes with methods to interact with web elements.
utilities: Helper classes for common functionalities.
src/test/java: Contains the test cases.
tests: Classes with individual test scenarios.
testData: Data files used for test scenarios.
drivers: WebDriver executables for different browsers.
test-output: TestNG reports for test results.
Setup Instructions
Clone the project repository.
Install required dependencies using Maven: mvn clean install.
Place WebDriver executable files in the drivers/ directory.
Execute the test scenarios using Maven: mvn test.
Test Scenarios
The project includes several test scenarios covering different aspects of the e-commerce website, ensuring thorough testing and validation of its functionalities.

Contributions and Feedback
Contributions, feedback, and suggestions for improvements are highly appreciated. Please feel free to submit issues or pull requests.

License
This project is licensed under the MIT License. See the LICENSE file for more details.






