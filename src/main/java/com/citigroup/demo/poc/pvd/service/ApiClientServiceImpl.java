package com.citigroup.demo.poc.pvd.service;

import static com.citigroup.demo.poc.pvd.model.ApiClientKeys.API_KEY;
import static com.citigroup.demo.poc.pvd.model.ApiClientKeys.AUTHAURITIES;
import static com.citigroup.demo.poc.pvd.model.ApiClientKeys.CLIENT_NAME;
import static com.citigroup.demo.poc.pvd.model.ApiClientKeys.TABLE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.citigroup.demo.poc.pvd.exceptions.ApiClientNotFoundException;
import com.citigroup.demo.poc.pvd.model.ApiClient;

/**
 * ApiClientServiceImpl provides the ApiClient Services
 * 
 */
@Service
public class ApiClientServiceImpl implements ApiClientService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApiClientServiceImpl.class);

	private final DynamoDB dynamoDB;

	/**
	 * @param dynamoDB
	 */
	@Autowired
	public ApiClientServiceImpl(DynamoDB dynamoDB) {
		this.dynamoDB = dynamoDB;
	}

	@Override
	public ApiClient find(String apiKey) throws ApiClientNotFoundException {
		LOGGER.info("Finding the ApiClinet using API KEY: {}", apiKey);
		Table table = dynamoDB.getTable(TABLE.key());

		GetItemSpec spec = new GetItemSpec().withPrimaryKey(API_KEY.key(), apiKey);

		try {
			LOGGER.info("Attempting to read the item...");
			Item outcome = table.getItem(spec);
			LOGGER.info("GetItem succeeded: {}", outcome);
			ApiClient apiClient = new ApiClient();
			apiClient.setApiKey(outcome.getString(API_KEY.key()));
			apiClient.setName(outcome.getString(CLIENT_NAME.key()));
			apiClient.setAuthorities(outcome.getList(AUTHAURITIES.key()));
			return apiClient;
		} catch (Exception e) {
			LOGGER.error("Unable to find API Clinet for API KEY: {}", apiKey);
			LOGGER.error(e.getMessage());
			throw new ApiClientNotFoundException("Unable to find API Clinet for API KEY: " + apiKey);
		}
	}

}