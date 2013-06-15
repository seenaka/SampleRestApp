package biz.neustar.sample.data;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import biz.neustar.sample.domain.UVInfoLog;

@Component
public class SampleDataRepo {
	
	//TODO: externalize values to config/prop or use a real in-memory DB
	public  Map<String, UVInfoLog> sampleData;
	
		{
			sampleData = new HashMap<String, UVInfoLog>();
			sampleData.put("2011", new UVInfoLog("1.0", "1M", 50000));
			sampleData.put("2012", new UVInfoLog("1.1", "1.5M", 150000));
			sampleData.put("2013", new UVInfoLog("1.2", "2.5M", 300000));
	
		}
}

