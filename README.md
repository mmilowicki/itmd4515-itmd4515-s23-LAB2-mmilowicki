# itmd4515-itmd4515-s23-LAB2-mmilowicki

mmilowicki-Lab 2 README file

1a. What database did you select?
Discuss in your README.

	I chose the Microsoft “Northwind” MySQL database. I’m not so experienced with MySQL or doing much with databases, outside of a few examples in an IIT course or two. 
	I followed along with the video demonstration so that I could have a reference to double-check my work for this lab. This is obviously not the best way for me to actually learn and develop the skills that I need for the upcoming labs. I figure, start small and get it right, and then I can start to venture out on my own and have some knowledge and examples with which to double-check my work in future labs/exercises.
	Overall, it was a very good start, and I came out with a lot of wisdom that really made things click around the time I got to the end of Lab 3. 
	The first crack at Lab 2 was a very good learning experience for me because I spent about 9 days this first time I took a crack at Lab 2, and I used the “City” table from the “world” database (as was suggested in the lecture). I didn’t realize this until I got close to the end of working lab 3 and made a judgement call that it would be best to start from scratch.
	When I started over I used the “Employee” table from the “Northwind” database. I did this because honestly, I was VERY pinched for time, but I didn’t want to cop out and use the “Customer” table from the “Northwind” database. I used Employee because it was similar enough to the “Customer” table from Sakila, but also had more fields and data types I hadn’t worked with the first time around. Essentially, I needed to be very wise with the limited amount of time I had, but I didn’t want to cheat myself out of a chance to learn something; ESPECIALLY learn something about the value of paying close attention to details.

1b. Which table are you going to represent as a Java POJO? 

	The table I chose to map is the “Employee” table. Again, Lab 2 is the beginning of really digging into MySQL tools and working with databases so, I wanted to have a reference point to make sure I was getting things right. That reference point was, of course, the Week 2 lecture and Lab 2 demo.
	I could have gone the cop-out route and used the “Employee” table in that database, but I didn’t. I chose something similar that matched my knowledge and skill level, but contained more fields and allowed me a chance to play around with some different constraint types, (I’m not ready for “@Pattern”!), and some data types that I’ve not yet worked with.

1c. What fields did you select to map from table to Java class? 

	The fields I selected, as instructed, were all the non-NULL fields in the Employee table from the Northwind database.
		In other words,
-	id
-	lastname
-	firstname
-	title
-	titleOfCourtesy
-	birthdate
-	hireDate
-	address
-	city
-	postalCode
-	country
-	phone

2.	What scope(s) did you select and why?  Discuss in your README.

Scope Selection:

I chose the <test> scope for Lab 2 dependencies.

	The Maven build lifecycle is divided up into a few different phases. Two of these phases are test-phase and runtime-phase. These two phases each have their own classpath. The classpath is the parameter that points to user-defined classes and packages.
	The test-phase classpath is only used when the developer is running tests on the application. The ‘runtime phase” is not used to test code or dependencies. It’s used after all the code has been written, tested, packaged, and deployed. The runtime-phase classpath is the one used when the application is executed.
	So, I used <test> scope to make sure that the dependencies in Lab 2 were only there when I needed them to be, which is during testing. I would never want to include test scope when it’s time to run the final application.

3. Document Lab 2 execution in your README by taking a screenshot of your IDE Test Results window.

![image](https://github.com/mmilowicki/itmd4515-itmd4515-s23-LAB2-mmilowicki/assets/108433680/ec3a7415-4c5d-4ecc-a212-4835f6b2a647)

	I got this error several times and so I changed the updateTest() property First_name from “BigTimeUpdate” to “fNewName”, and the Last_name property from “OhSoUpdate” to “lNewName”, after going through the troubleshooting of naming it “NextUpdate” and seeing that it didn’t work. I tried various different names, and it turned out the problem was that whatever name I was trying to assign to the property could not be longer than how it appears in the table, which is “lastname” and “firstname.”
![image](https://github.com/mmilowicki/itmd4515-itmd4515-s23-LAB2-mmilowicki/assets/108433680/3eebf9f7-bbe4-456b-9f48-ec13548f69ec)

Here are the corrected property names that passed the test:
![image](https://github.com/mmilowicki/itmd4515-itmd4515-s23-LAB2-mmilowicki/assets/108433680/2ddfcc66-d91b-4771-89e7-1897ec683058)


Discuss any other issues or insights you had with Lab 2.

Issues/Insights:
	I followed carefully along with the video demonstration, as well as the examples from the Hibernate Validator and JUnit reading, I didn’t understand too well at first just reading through and then going back to the drawing board in NetBeans. I had to dig around a bit more and find some definitions and examples of the annotations that made sense.
	I did have a great deal of trouble setting everything up on the command line in Windows. I’m thinking it’ll be a lot easier to set up on macOS and, if it is, I will have to switch over and do all of the up-coming lab assignments using a macOS…
…Fear not! I’ve received a big-time leg up and was finally able to put all the pieces together and get MySQL working on cmd.
![image](https://github.com/mmilowicki/itmd4515-itmd4515-s23-LAB2-mmilowicki/assets/108433680/01bc4dd4-4fe9-4784-ae0b-ac6371acaf53)
  

And then when I re-worked Lab 2:
![image](https://github.com/mmilowicki/itmd4515-itmd4515-s23-LAB2-mmilowicki/assets/108433680/3a250917-e703-41d8-8de9-c58a82c88c56)
 
Graduate/Undergraduate

1a. Test your Java SE project on the command line using maven. 
Document your experience (with code block output) on your README. 

My mvn -test output:
![image](https://github.com/mmilowicki/itmd4515-itmd4515-s23-LAB2-mmilowicki/assets/108433680/ea43fb1e-3c3a-461e-b5a0-8b3f4c70e959)


And then when I re-worked Lab 2:
![image](https://github.com/mmilowicki/itmd4515-itmd4515-s23-LAB2-mmilowicki/assets/108433680/d818f88d-99a2-45b4-9b41-21ed86748be4)

 
Microsoft Windows [Version 10.0.22631.3085]
(c) Microsoft Corporation. All rights reserved.
C:\Windows\System32>cd \
C:\>cd C:\Program Files
C:\Program Files>cd \
C:\>cd Users
C:\Users>cd macie
C:\Users\macie>cd NetBeansProjects
C:\Users\macie\NetBeansProjects>cd mmilowicki-lab2
C:\Users\macie\NetBeansProjects\mmilowicki-lab2>mvn test
[INFO] Scanning for projects...
[INFO]
[INFO] ----------< edu.iit.sat.itmd4515.mmilowicki:mmilowicki-lab2 >-----------
[INFO] Building mmilowicki-lab2 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ mmilowicki-lab2 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\macie\NetBeansProjects\mmilowicki-lab2\src\main\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ mmilowicki-lab2 ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ mmilowicki-lab2 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\macie\NetBeansProjects\mmilowicki-lab2\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ mmilowicki-lab2 ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ mmilowicki-lab2 ---
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running EmployeeJDBCTest
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.698 s - in EmployeeJDBCTest
[INFO] Running EmployeeValidationTest
Feb 10, 2024 3:13:09 PM org.hibernate.validator.internal.util.Version <clinit>
INFO: HV000001: Hibernate Validator 6.2.4.Final
ConstraintViolationImpl{interpolatedMessage='must not be blank', propertyPath=phone, rootBeanClass=class edu.iit.sat.itmd4515.mmilowicki.Employee, messageTemplate='{javax.validation.constraints.NotBlank.message}'}
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.349 s - in EmployeeValidationTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.632 s
[INFO] Finished at: 2024-02-10T15:13:10-06:00
[INFO] ------------------------------------------------------------------------
C:\Users\macie\NetBeansProjects\mmilowicki-lab2>

	I navigated to my project directory, specifically, to where my pom.xml file was located and ran the command “mvn -test”.
All of my unit tests were run; they all passed. 

The following shows the ‘Successful Build” summary I got back from Maven:

[INFO] Results:
[INFO]
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.632 s
[INFO] Finished at: 2024-02-10T15:13:10-06:00
[INFO] ------------------------------------------------------------------------
C:\Users\macie\NetBeansProjects\mmilowicki-lab2>


1b. Discuss how command line Java relates to Maven (hint - think classpath and dependencies).
		Maven makes it incredibly easier and less headache-ey to test Java applications. Without Maven, you’d have to manually declare your project’s classpath and dependencies. Maven handles the classpath automatically and collects all necessary dependency information from the pom.xml file. 
The need to manage dependencies manually is resolved by including the Project Object Model, which not only makes application testing easier, but also gives us a lot less room to make errors.


1c. What would you need to do (step by step) in order to run your project without maven, using only the Java SE provided java and javac binaries? 

Setup:
First, install the JDK.
Second, set the JAVA_HOME environment variable.
Next, add the JDK’s bin directory to the system’s PATH environment variable.

Compile Java Files:
First, get to the directory where the source files for your project are.
Second, compile the project’s .java files with the javac command.
Next, include all the project’s dependencies in the classpath during compilation with the -cp or -classpath commands.

Run the Application:
First, run the app with the java command.
Second, if there are any dependencies, or if the .class files are in a different directory, you have to include them in the classpath.

Manage Resources:
First, if the project has any configuration files,  you have to make sure they’re in the same place that the app expects them to be. What we’re talking about here is another benefit of using Maven. Maven takes care of handling project resources, like configuration files, while java compiler does not.

Rinse and Repeat:
Here is where Maven really comes to the rescue, without Maven, you’ll have to go through and repeat all the “Compile Java Files” steps any time there are changes made to the source code. In the case of writing or testing an enterprise application, not using Maven would be outright insanity. There’s just too large an error of margin with the amount of people you’ll have on different teams that all need to work with the project and the source code.


