package biz.neustar.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import biz.neustar.sample.data.SampleDataRepo;
import biz.neustar.sample.domain.UVInfoLog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/root-context.xml", "classpath*:META-INF/spring/mvc/mvc-context.xml" })
public class TestRestController {

	static final String InfoYear = "2013";
	static final String baseUrl = "http://localhost:8080/SampleRestApp/rest/uvinfolog";

	@Resource
	SampleDataRepo db;

	RestTemplate restTemplate = new RestTemplate();

	/**
	 * Tests accessing an existing record
	 */
	@Test
	public void getUVInfoLog() {
		String uri = buildUri("/{InfoYear}");

		UVInfoLog record = restTemplate.getForObject(uri, UVInfoLog.class, InfoYear);
		assertNotNull(record);
		assertEquals("1.2", record.getRelease());
	}

	/**
	 * Tests updating a record
	 */
	@Test
	public void updateUVInfoLog() {

		String postUri = buildUri("/" + InfoYear + "/update");

		UVInfoLog record = db.sampleData.get(InfoYear);

		record.setPageviews("updateByTest");

		restTemplate.put(postUri, record);

		// get the updated record
		UVInfoLog updatedRecord = restTemplate.getForObject(buildUri("/{InfoYear}"), UVInfoLog.class, InfoYear);

		assertEquals(updatedRecord.getPageviews(), "updateByTest");
	}

	private String buildUri(String stub) {

		return baseUrl + stub;

	}

}
