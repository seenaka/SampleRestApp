package biz.neustar.sample.rest;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import biz.neustar.sample.data.SampleDataRepo;
import biz.neustar.sample.domain.UVInfoLog;

/**
 * Handles requests for /rest/uvinfolog/* calls to our sample UVInfoLog resource
 */
@Controller
@RequestMapping("/uvinfolog/{inputYear}")
public class RestController {

	@Resource
	SampleDataRepo db;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public UVInfoLog getUVInfoLog(@PathVariable String inputYear) {

		UVInfoLog record = db.sampleData.get(inputYear);

		return record;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateByYear(@PathVariable String    inputYear, 
							 @RequestBody  UVInfoLog inputRecord) {

		UVInfoLog record = db.sampleData.get(inputYear);

		if (record != null) {
			db.sampleData.put(inputYear, inputRecord);
		}
		//TODO:: If the objective of this code is to handle "partial updates" to the resource/object, 
		//then either a merge/delta update logic/technique needs to be implemented here or 
		//another approach via restful URL PathVariables and dynamic handling of the URI per attribute of the resource can be implemented.

	}
}
