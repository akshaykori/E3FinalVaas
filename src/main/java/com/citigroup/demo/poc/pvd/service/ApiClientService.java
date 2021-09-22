package com.citigroup.demo.poc.pvd.service;

import com.citigroup.demo.poc.pvd.exceptions.ApiClientNotFoundException;
import com.citigroup.demo.poc.pvd.model.ApiClient;

/**
 * ApiClientService provide services to register new ApiClient
 *
 */
public interface ApiClientService {

	/**
	 * Find the ApiClinet based upon the apiKey
	 * 
	 * @param apiKey
	 * @return
	 * @throws ApiClientNotFoundException
	 */
	ApiClient find(final String apiKey) throws ApiClientNotFoundException;

}
