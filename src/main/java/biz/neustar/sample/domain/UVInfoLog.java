package biz.neustar.sample.domain;

import java.io.Serializable;



/**
 * @author Seena K.
 * Sample POJO representing a Resource - i.e. UltraViolet Info Log/Record
 *
 */
public class UVInfoLog implements Serializable {

	private static final long serialVersionUID = 1L;

	private String pageviews;

	private Integer userCount;

	private String release;

	public UVInfoLog() {
	}

	public UVInfoLog(String release, String pageviews, Integer userCount) {
		this.release = release;
		this.pageviews = pageviews;
		this.userCount = userCount;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public String getPageviews() {
		return pageviews;
	}

	public void setPageviews(String pageviews) {
		this.pageviews = pageviews;
	}

	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}
    
    
 

}
