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
	
###To deploy the app:

1. git glone https://github.com/seenaka/SampleRestApp.git
2. cd SampleRestApp
3. mvn install

This would give you a .war file to deploy (target/SampleRestApp-1.0.0-BUILD-SNAPSHOT.war)




