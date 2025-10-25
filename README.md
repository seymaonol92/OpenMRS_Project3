# 🏥 OpenMRS Test Automation Project

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)
![Selenium](https://img.shields.io/badge/Selenium-4.36.0-green?style=for-the-badge&logo=selenium)
![TestNG](https://img.shields.io/badge/TestNG-7.11.0-red?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-3.2.5+-blue?style=for-the-badge&logo=apache-maven)

**Automated GUI Testing Framework for OpenMRS Medical Record System**

[Demo Site](https://demo.openmrs.org/) • [Report an Issue](https://github.com/seymaonol92/OpenMRS_Project3/issues)

## 📋 About The Project

This project is a comprehensive GUI test automation framework developed for the [OpenMRS](https://demo.openmrs.org/) (Open Medical Record System) platform. Built with **Selenium WebDriver** and **TestNG**, it follows industry best practices and implements the Page Object Model design pattern.

### ✨ Key Features

- ✅ User-Story driven test structure (BDD-like approach)
- ✅ Page Object Model (POM) design pattern
- ✅ Comprehensive logging with Log4j
- ✅ Detailed test reporting with Allure
- ✅ Configurable test environment
- ✅ Cross-browser support ready


## 🛠️ Tech Stack

| Technology | Version | Purpose |
|:-----------|:--------|:--------|
| **Java** | 21 | Programming Language |
| **Selenium WebDriver** | 4.36.0 | Browser Automation |
| **TestNG** | 7.11.0 | Test Framework & Management |
| **Maven** | 3.2.5+ | Build & Dependency Management |
| **Allure** | 2.30.0 | Test Reporting |
| **Log4j** | 3.0 | Logging Framework |
| **Jackson** | 2.20.0 | JSON Data Binding |


## 📝 Test Scenarios (User Stories)

The project covers 10 comprehensive user stories:

| ID | User Story | Description |
|:---|:-----------|:------------|
| 🚫 **US_401** | Login Error Validation | System login error handling and validation |
| 🔑 **US_402** | User Login | User authentication process |
| 🚪 **US_403** | User Logout | User logout functionality |
| 📋 **US_404** | Patient Registration | New patient registration workflow |
| 👤 **US_405** | My Account Management | User account management features |
| 🔍 **US_406** | Patient Search | Patient search in patient list |
| 🗑️ **US_407** | Patient Deletion | Patient record deletion process |
| 📊 **US_408** | Patient Listing | Patient list display and verification |
| 🔄 **US_409** | Patient Record Merge | Merging patient records functionality |
| ⚙️ **US_410** | Additional Features | Additional system features (To be implemented) |


## 📁 Project Structure

```
OpenMRS_Project3/
│
├── 📄 pom.xml                          # Maven configuration
├── 📄 README.md                        # Project documentation
│
└── src/
    ├── main/java/
    │   └── pages/                      # Page Object Model classes
    │       ├── BasePage.java           # Base page with common methods
    │       ├── HomePage.java           # Home page objects
    │       ├── LoginPage.java          # Login page objects
    │       ├── DashboardPage.java      # Dashboard page objects
    │       ├── PatientRegistrationPage.java
    │       ├── FindPatientPage.java
    │       ├── PatientDetailsPage.java
    │       ├── MergePatientsPage.java
    │       ├── ManagePatientsPage.java
    │       ├── SystemAdministrationPage.java
    │       ├── LegacyAdminPage.java
    │       ├── AppointmentSchedulingPage.java
    │       └── DataRepo.java           # Test data repository
    │
    └── test/
        ├── java/
        │   ├── US401_CheckingLoginErrorsInTheSystem/
        │   ├── US402_PerformLoginInTheSystem/
        │   ├── US403_PerformLogoutFromTheSystem/
        │   ├── US404_PatientRegistration/
        │   ├── US405_MyAccount/
        │   ├── US406_PatientSearchInPatientList/
        │   ├── US407_PatientDeletion/
        │   ├── US408_PatientListing/
        │   ├── US409_PatientRecordMerge/
        │   ├── US410/
        │   │
        │   └── utility/                # Utility classes
        │       ├── BaseDriver.java     # WebDriver initialization
        │       └── BaseGUITest.java    # Base test class
        │
        └── resources/
            ├── log.xml                 # Logging configuration
            └── allTestsRun.xml         # TestNG suite configuration
```

## ⚙️ Configuration

Test environment settings are managed in TestNG XML files and utility classes, including application URL, user credentials, and timeout configurations.


## 🏗️ Design Pattern

This project implements the **Page Object Model (POM)** design pattern, which provides:

- 🎯 **Better code organization** - Separation of test logic and page elements
- 🔄 **Reusability** - Common methods in BasePage class
- 🛡️ **Maintainability** - Easy to update when UI changes
- 📖 **Readability** - Clear and structured test code


## 📊 Test Reporting

The project uses **Allure Framework** for generating beautiful, interactive test reports:

- 📈 Test execution statistics
- 📋 Detailed test steps
- 🖼️ Screenshots on failure
- ⏱️ Execution time tracking
- 📝 Comprehensive logs