# SAMPLE JAVA THREAD

### Introduction

This software component is a sample for Adobe.

---
### Running the application
```
$ gradle bootRun
```
---
### Api Documentation
```
https://*Deployment_url*/swagger-ui.html
```
---
### Dependencies
- ####DataBase
    - #####Backend
        - *backend* : for online mode
    
- **Messaging queue**
    - Setted up connection with a cloud based queue (e.g SQS-AWS)

### Code Quality
* Copy the `pre-push` file present in your project to .git/hooks folder.
    ```
    cp pre-push .git/hooks
    chmod 766 .git/hooks/pre-push
    ```
This will run the test and checkstyle configuration before pushing the code to repo.

In order to set up the checkstyle on intellij, go to Settings > Checkstyle > + new checkstyle and import the checkstyle.xml (found in the config folder of this repository).  
Then, go to preferences > Editor > Code Style and then add a new scheme and import the CodeStyle.xml file.


### Code Coverage

* Uses Jacaco gradle plugin to generate reports.

##### Running code coverage

```$xslt
 gradle test jacocoTestRepor
```
* You should be able to see the reports in the  build/reports/jacoco. 
* You can open the index.html file in the browser to view the reports.