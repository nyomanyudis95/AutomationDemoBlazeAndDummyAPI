# AutomationDemoBlazeAndDummyAPI

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
To run automation demolaze you can run "./gradlew web" in your terminal. And to run automation dummyapi you can run "./gradlew api" in your terimanl. You can add paramater tags in terminal to run only specific feature. For example './gradlew web -Ptags="@[tagName1]"'. These are several tags that you can use
Attempt | #1 | #2 | #3 | #4 | #5 | #6 | #7 | #8 | #9 | #10 | #11
--- | --- | --- | --- |--- |--- |--- |--- |--- |--- |--- |---
Seconds | 301 | 283 | 290 | 286 | 289 | 285 | 287 | 287 | 272 | 276 | 269 





## Github Action 
In this project, there is apply workflow that will trigger every pull and push event. In workflow automation website and api will be run automaticly, Then will generated reports. These report can be see in : 
Report automation demoblaze: https://nyomanyudis95.github.io/automationdemoblazeanddummyapi/reports/automation-demoblaze-report.html
Report automation dummyapi : https://nyomanyudis95.github.io/automationdemoblazeanddummyapi/reports/automation-dummyapi-report.html











