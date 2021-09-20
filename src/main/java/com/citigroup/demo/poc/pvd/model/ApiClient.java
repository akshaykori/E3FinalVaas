package com.citigroup.demo.poc.pvd.model;

import java.util.List;

//import lombok.Data;

//@Data
public class ApiClient {
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}
	private String apiKey;
	private String name;
	private List<String> authorities;
}
