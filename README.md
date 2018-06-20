# Appium-On-AWS-Device-Farm
## Appium Tests on AWS Device Farm.

Android Application used in this test can be built using the code from <a href="http://dl.bintray.com/robotium/generic/ExampleTestProject_AndroidStudio.zip">here</a>

Application .apk file can be found at

        ~\App_Name\app\build\outputs\apk\app-debug.apk

Add the following plugins to the pom.xml file. 

                <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-dependency-plugin</artifactId>
                        <version>2.10</version>
                        <executions>
                                <execution>
                                        <id>copy-dependencies</id>
                                        <phase>package</phase>
                                        <goals>
                                                <goal>copy-dependencies</goal>
                                        </goals>
                                        <configuration>
                                                <outputDirectory>${project.build.directory}/dependency-jars/</outputDirectory>
                                        </configuration>
                                </execution>
                        </executions>
                </plugin>
                <plugin>
                        <artifactId>maven-assembly-plugin</artifactId>
                        <version>2.5.4</version>
                        <executions>
                                <execution>
                                        <phase>package</phase>
                                        <goals>
                                                <goal>single</goal>
                                        </goals>
                                        <configuration>
                                                <finalName>zip-with-dependencies</finalName>
                                                <appendAssemblyId>false</appendAssemblyId>
                                                <descriptors>
                                                        <descriptor>src/main/assembly/zip.xml</descriptor>
                                                </descriptors>
                                        </configuration>
                                </execution>
                        </executions>
                </plugin>
        </plugins>

Use below command to create zip-with-dependencies.zip file

        mvn clean package -DskipTests=true
      
Setting up the project for execution on AWS Device Farm can be found <a href="https://docs.aws.amazon.com/devicefarm/latest/developerguide/test-types-android-appium-java-testng.html"> here</a>. 
