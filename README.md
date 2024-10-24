# Cucumber Automation Framework
![Maven Central](https://img.shields.io/maven-central/v/org.seleniumhq.selenium/selenium-java?versionSuffix=4.25.0&label=Selenium)
![Maven Central](https://img.shields.io/maven-central/v/io.cucumber/cucumber-java?versionSuffix=7.20.1&label=Cucumber)
![Maven Central](https://img.shields.io/maven-central/v/org.testng/testng?versionSuffix=7.10.2&label=TestNG)
![Maven Central](https://img.shields.io/maven-central/v/org.slf4j/slf4j-api?versionSuffix=2.0.16&label=Slf4j)
![Maven Central](https://img.shields.io/maven-central/v/org.apache.commons/commons-lang3?versionSuffix=3.17.0&label=Apache%20Commons)
![Maven Central](https://img.shields.io/maven-central/v/tech.grasshopper/extentreports-cucumber7-adapter?versionSuffix=1.14.0&label=Grashopper)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

Cucumber BDD Automation Framework for your automation projects. It provides you with a ready folder and library structure to quickly get started on your test automation projects.

Getting Started
---------------

The easiest way to get started is to clone the repository:

```bash
# File > New > Project From Version Control 
# Copy to URL
git@github.com:emrtnm/cucumber-automation-framework.git

# open project at Intellij
# select project JDK
jdk21

# Load Pom
Click to pom.xml > Maven > Reload Project

# Run All Test
Click to runners > TestRunnerAll and Run

# Run Smoke Test
Click to Runner > TestRunnerSmoke and Run

```

List of Dependencies
----------------

| Package      | Description                            |
|--------------|----------------------------------------|
| TestNG       | Next Generation Testing Tool.          |
| Selenium     | Browser Automation Framework.          |
| slf4j        | The Simple Logging Facade for Java.    |
| commons.io   | The Apache Commons IO library.         |
| cucumber     | Cucumber is a tool that supports BDD.  |
| grasshopper  | HTML & PDF Report plugin for cucumber. |

## File Structure
```bash
|-- src
|   |-- main
|       |-- java
|       |-- resources
|
|   |-- test
|       |-- java
|           |-- featurefiles
|               |-- Cucumber Feature Files
|           |-- pageobjectmodels
|               |-- Locators, Page Object Model Files
|           |-- runners
|               |-- AllTest
|               |-- AuthTest
|               |-- RegressionTest
|               |-- SmokeTest
|           |-- stepdefinitions
|               |-- Hooks
|               |-- * Test Class Files
|           |-- utilities
|               |-- DriverManager
|               |-- Events
|               |-- ExcelUtility
|       |-- resources
|       |-- results
|           |-- .gitkeep
|           |-- .gitignore
|
|-- .gitignore
|-- LICENSE
|-- pom.xml
|-- README.md

```

## License

This project is open-sourced software licensed under the [GPL-3.0 license](https://www.gnu.org/licenses/gpl-3.0).


### Make A Contribution!
If you think that anything here could be improved, please don't hesitate to contribute. Anyone who wants to, regardless of their ability, skill, or background, can contribute to this project. All contributions are made for the benefit of the community. Thanks very much for helping this repository become much more suitable for its purpose and more useful to a larger number of people.

**#cucumber** **#bdd** **#framework** **#boilerplate** **#testing** **#sdet** **#automation**
**#test** **#selenium** **#java** **#testng** **#gherkin**
