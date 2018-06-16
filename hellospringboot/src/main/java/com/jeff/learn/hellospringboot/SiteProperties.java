package com.jeff.learn.hellospringboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ConfigurationProperties
@Component
//@PropertySource("application-site.properties")
public class SiteProperties {
//	@Value("${siteName}")
	private String siteName;
	
	
//	@Value("${siteId}")
	private int siteId;

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	
	
	
}
