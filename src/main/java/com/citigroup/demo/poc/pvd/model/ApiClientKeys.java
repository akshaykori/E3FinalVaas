package com.citigroup.demo.poc.pvd.model;

/**
 * ApiClinet Table Key Enumeration
 * 
 */
public enum ApiClientKeys {
	TABLE("ApiClinet"), API_KEY("ApiKey"), CLIENT_NAME("ClientName"), AUTHAURITIES("Authorities");

	private String key;

	ApiClientKeys(String key) {
		this.key = key;
	}

	public String key() {
		return key;
	}
}