# Web Automation

## Overview
This project is a web automation framework built using Java, Selenium WebDriver, and Cucumber. It enables automated testing of web applications by simulating user interactions, validating UI elements, and ensuring application stability. The framework follows a structured approach to organizing test cases, managing test data, and generating reports.

## Features
- Automated UI testing using Selenium WebDriver.
- Integration with Maven for dependency management.
- Behavior-Driven Development (BDD) using Cucumber.
- Data-driven testing using parameterized test data.
- Structured test data management.
- Detailed test execution reports.
- Modular and scalable design for easy maintenance.

## Technologies Used
- **Java** - Primary programming language.
- **Selenium WebDriver** - For browser automation.
- **Cucumber** - For BDD-style test execution.
- **Maven** - Build and dependency management tool.
- **TestNG/JUnit** - For test execution and assertions (if applicable).
- **Extent Reports** - For generating detailed test execution reports.

## Project Structure
```
Web_Automation/
│-- .settings/              # IDE-specific settings
│-- data/                   # Test data files
│-- report/                 # Test execution reports
│-- scenarios_data_files/   # Scenario-specific data files
│-- src/test/               # Test scripts and related resources
│   ├── java/               # Java test classes
│   ├── resources/          # Feature files for Cucumber
│-- .classpath              # Java classpath configuration
│-- .gitignore              # Git ignored files
│-- .project                # Eclipse project metadata
│-- debug.log               # Debugging log file
│-- pom.xml                 # Maven configuration file
```

## Setup Instructions
### Prerequisites
Ensure you have the following installed:
- Java (JDK 8 or later)
- Maven
- A web browser (Chrome, Firefox, etc.)
- WebDriver for the chosen browser

### Steps to Run the Tests
1. **Clone the Repository**
   ```bash
   git clone https://github.com/geethub17/Web_Automation.git
   ```
2. **Navigate to the Project Directory**
   ```bash
   cd Web_Automation
   ```
3. **Install Dependencies**
   ```bash
   mvn clean install
   ```
4. **Run the Test Cases**
   ```bash
   mvn test
   ```
5. **Run Cucumber Feature Files**
   ```bash
   mvn test -Dcucumber.options="src/test/resources/features"
   ```

## Contributing
- Fork the repository.
- Create a new branch for your feature or bug fix.
- Submit a pull request with a clear description of the changes.

## References
- Please refer https://stackoverflow.com/search?q=user%3A7731623+cucumber for any cucumber related questions.


