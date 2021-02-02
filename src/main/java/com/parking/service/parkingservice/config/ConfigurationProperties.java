package com.parking.service.parkingservice.config;

import org.springframework.context.annotation.Configuration;

/**
 * The Class ConfigurationProperties.
 */
@Configuration
@org.springframework.boot.context.properties.ConfigurationProperties(prefix = "parking.props")
public class ConfigurationProperties {
	
	/** The limit. */
	private Long limit;

	/**
	 * Gets the limit.
	 *
	 * @return the limit
	 */
	public Long getLimit() {
		return limit;
	}

	/**
	 * Sets the limit.
	 *
	 * @param limit the new limit
	 */
	public void setLimit(Long limit) {
		this.limit = limit;
	}
	
	
}
