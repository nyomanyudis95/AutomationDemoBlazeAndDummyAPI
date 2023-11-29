# AutomationDemoBlazeAndDummyAPI


## Overview
This is project java for final project in JayJay. This is project java for automation Website And API Testing using Selenium, JUnit, RestAssured , and Cucumber. Also using gradle 
for build tool. API url we used for automation testing is https://dummyapi.io/docs/user and demoblaze.com for automation website. 

## Getting Started 
These instructions will guide you on how to set up the project on your local machine for development and testing purposes.

### Prerequites 
Before getting started, ensure that you have the following software installed on your machine:

1. Java JDK: download and install the latest version of Java JDK from the official Oracle website (https://www.oracle.com/id/java/technologies/downloads/).
2. Gradle: Install Gradle by following the official Gradle installation guide (https://gradle.org/install/), but in this case, we are using 'gradlew'.

### Installing 
To set up the development environment, follow these steps:

1. Clone this repository to your local machine using Git or download the ZIP file and extract it.
2. Open the project in your preferred Java IDE (e.g., IntelliJ or Eclipse).
3. Build the project and download dependencies using Gradle by running the following command in the terminal: ./gradlew clean build


## Point of View about DemoBlaze 
These are several point that i think it can be improved in DemoBlaze : 
1. There is no active page in header navigation. So for new user doesn't know which page they are now. 
2. Contact Modal doesn't have validation from every input.
3. Place Order Modal only has restriction name and credit card. 
4. Place Order Modal and Success Order Modal is show at same time, it should be show one by one.  

These are several point that i have hard time to make this automation : 
1. In header navigation between Cart Page and Home Page, button Cart navigation has different id. It's a prove that each page dont use reusable component. 

These are several point that i can't automate test in demoblaze: 
1. Can't test sign up success. It's because demoblaze dont give priviledge to delete account that used for sign up.
2. Can't test category product. Because there are no information to know which category from one product 
3. Can't test url video about us. Because url video always change every time. 


## How to run this project 
To run automation demolaze you can run "./gradlew web" in your terminal. And to run automation dummyapi you can run "./gradlew api" in your terimanl. You can add paramater tags in terminal to run only specific feature. For example './gradlew web -Ptags="@[tagName]"'. These are several tags that you can see in file features that locate in src/test/resources/features/. 


## Github Action 
In this project, there is apply workflow that will trigger every pull and push event. In workflow automation website and api will be run automaticly, Then will generated reports. These report can be see in : 

Report automation demoblaze: https://nyomanyudis95.github.io/automationdemoblazeanddummyapi/reports/automation-demoblaze-report.html

Report automation dummyapi : https://nyomanyudis95.github.io/automationdemoblazeanddummyapi/reports/automation-dummyapi-report.html

## Result 
<img width="1440" alt="image" src="https://github.com/nyomanyudis95/automationdemoblazeanddummyapi/assets/44666702/39a7f25f-c085-42e2-87ad-444fff9df209">














