SampleRestApp
=============

SampleRestApp - A very simple spring mvc webapp that exposes restful api using Spring MVC 3.x Rest support; Jackson converts the sample Resource (POJO) to JSON. 
Also includes a simple integration test using spring-test and RestTemplate:

	given the URL:`http://localhost:8080/SampleRestApp/rest/uvinfolog/2013`:
	the following JSON string would output: `{"pageviews":"2.5M","userCount":300000,"release":"1.2"}`
	
And in the JUnit test code, the data can be retrieved as follow:
```
		UVInfoLog record = restTemplate.getForObject(uri, UVInfoLog.class);
		assertNotNull(record);
		assertEquals("1.2", record.getRelease());
```
	
###To download, build and deploy the app:

1. git clone https://github.com/seenaka/SampleRestApp.git
2. cd SampleRestApp
3. mvn jetty:run

Or you can run `mvn install` and get a .war file to deploy on another appserver (target/SampleRestApp-1.0.0-BUILD-SNAPSHOT.war)

Alternatively you can download the project as a zip here https://github.com/seenaka/SampleRestApp/archive/master.zip



