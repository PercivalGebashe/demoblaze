# Demoblaze Test Automation  

## Overview  
This repository contains automated test scripts for the [Demoblaze](https://www.demoblaze.com/) web application. The tests are designed using **Java, Selenium WebDriver, TestNG, and Maven**, ensuring reliable and efficient test execution for UI automation.  

## Features  
- Automated UI testing with **Selenium WebDriver**  
- Test execution managed by **TestNG**  
- Build and dependency management with **Maven**  
- Page Object Model (POM) for better maintainability  
- Validations for key functionalities of the Demoblaze website  

## Prerequisites  
Ensure you have the following installed before running the tests:  
- **Java** (JDK 8 or later)  
- **Maven** (Latest version)  
- **TestNG** (Configured in `pom.xml`)  
- **WebDriver** (Ensure the correct version is set up for your browser)  

## Installation & Setup  
1. Clone the repository:  
   ```sh  
   git clone https://github.com/PercivalGebashe/demoblaze.git  
   cd demoblaze  
   ```  
2. Ensure all dependencies are installed:  
   ```sh  
   mvn clean install  
   ```  

## Running the Tests  
To execute the test suite, use:  
```sh  
mvn test  
```  
For specific test execution, modify the **TestNG** XML configuration file as needed.  

## Project Structure  
- `src/main/java/` → Page Object Model classes  
- `src/test/java/` → Test scripts  
- `pom.xml` → Maven dependencies and configurations  

## Contributing  
Feel free to fork the repository and submit pull requests for improvements. Ensure that all changes are properly tested before submitting.  

## License  
This project is open-source under the **MIT License**.  
