# cesarTest
Instituto Cesar test for a job opportunity

Description:<br>
This test is related a job opportunity in Instituto Cesar (Manaus - AM), Software Engineer Senior.<br>
This test has 7 questions.<br>
Language = Java 11.<br>
<br>
To execute:<br>
java -jar sergioTest.jar<br>
<br>
To compile:<br>
$ cd CesarsTest/src<br>
$ javac -d ../bin main/CesarsTest.java<br>
<br>
To run (after compilation):<br>
$ cd CesarsTest/src<br>
$ java -cp ../bin main.CesarsTest<br>
<br>
To run runnable JAR file<br>
$ cd CesarsTest/bin<br>
$ java -jar sergioTest.jar<br>
<br>
To compile JUnitTests<br>
$ cd CesarsTest/src<br>
$ javac -d ../bin -cp ../bin:../lib/junit-platform-console-standalone-1.6.2.jar test/CesarsTest_Test.java<br>
<br>
To run JUnitTests(after compilation):<br>
$ cd CesarsTest/src<br>
$ java -jar ../lib/junit-platform-console-standalone-1.6.2.jar --class-path ../bin --scan-class-path<br>
