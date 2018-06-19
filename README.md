# Appium-On-AWS-Device-Farm
## Appium Tests on AWS Device Farm.

Android Application used in this test can be built using the code from <a href="http://dl.bintray.com/robotium/generic/ExampleTestProject_AndroidStudio.zip">here</a>

Application .apk file can be found at

        ~\App_Name\app\build\outputs\apk\app-debug.apk

Use below command to create zip-with-dependencies.zip file

        mvn clean package -DskipTests=true
      
Setting up the project for execution on AWS Device Farm can be found <a href="https://docs.aws.amazon.com/devicefarm/latest/developerguide/test-types-android-appium-java-testng.html"> here</a>. 
