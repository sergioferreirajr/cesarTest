# cesarTest
Instituto Cesar test for a job opportunity

Description:
This test is related a job opportunity in Instituto Cesar (Manaus - AM), Software Engineer Senior.
This test has 7 questions.
Language = Java 11.

To execute:
java -jar sergioTest.jar

To compile:
$ cd CesarsTest/src
$ javac -d ../bin main/CesarsTest.java

To run (after compilation):
$ cd CesarsTest/src
$ java -cp ../bin main.CesarsTest

To compile JUnitTests
$ cd CesarsTest/src
$ javac -d ../bin -cp ../bin:../lib/junit-platform-console-standalone-1.6.2.jar test/CesarsTest_Test.java

To run JUnitTests(after compilation):
$ cd CesarsTest/src
$ java -jar ../lib/junit-platform-console-standalone-1.6.2.jar --class-path ../bin --scan-class-path
