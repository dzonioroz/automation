package webApi.automation.rest;

import static io.restassured.RestAssured.expect;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import io.restassured.response.Response;
import webApi.automation.handlers.PropertiesLoader;

public class BaseRestTest {

	// Headers
	public static final String HEADER_ORIGIN = "Origin";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String APPLICATION_JSON = "application/json";
	public static final String AUTHORIZATION = "authorization";
	public static String BASE_URL;
	public static String ALL_COUNTRIES_URL;
	public static String ISO2CODE_URL;
	public static String ISO3CODE_URL;
	public static String SEARCH_URL;
	public String alpha2code = "IN";
	public String alpha3code = "IND";
	public String countryName = "India";
	public static final String COUNTRY_AFGANISTAN = "Afghanistan";
	public static final int STATUS_OK = 200;

	@BeforeMethod
	public void init() {
		PropertiesLoader prop = new PropertiesLoader();
		BASE_URL = prop.getRestProperty("api.base");
		ALL_COUNTRIES_URL = prop.getRestProperty("get.all.countries.endpoint");
		ISO2CODE_URL = prop.getRestProperty("get.iso2code");
		ISO3CODE_URL = prop.getRestProperty("get.iso3code");
		SEARCH_URL = prop.getRestProperty("search.isocode");
	}

	public static Response getRequestJson(Integer statusCode, String path) {
		Response restResponse = expect().given().headers(CONTENT_TYPE, APPLICATION_JSON).when().get(path);

		Integer responseStatusCode = Integer.valueOf(restResponse.statusCode());
		Assert.assertEquals(responseStatusCode, statusCode);

		return restResponse;
	}

	public JSONObject getResponseObject(Response response) {
		JSONObject responseObject = new JSONObject(response.getBody().asString());
		JSONObject restResponseObject = responseObject.getJSONObject("RestResponse");
		return restResponseObject;
	}

	public JSONObject getResponseResultObject(Response response) {
		JSONObject restResponseObject = getResponseObject(response);
		JSONObject result = restResponseObject.getJSONObject("result");
		return result;
	}

	public void validateResponseIso3Code(Response response, String alpha3code) {
		JSONObject resultObject = getResponseResultObject(response);
		String alpha3codeResponse = resultObject.getString("alpha3_code").toString();
		Assert.assertEquals(alpha3codeResponse, alpha3code,
				"Country codes are not matching Expected: " + alpha3code + " ,But found: " + alpha3codeResponse);
	}

	public void validateResponseIso2Code(Response response, String alpha2code) {
		JSONObject resultObject = getResponseResultObject(response);
		String alpha2codeResponse = resultObject.getString("alpha2_code").toString();
		Assert.assertEquals(alpha2codeResponse, alpha2code,
				"Country codes are not matching Expected: " + alpha3code + " ,But found: " + alpha2codeResponse);
	}

	public void validateResponseName(Response response, String countryName) {
		JSONObject resultObject = getResponseResultObject(response);
		String nameResponse = resultObject.getString("name").toString();
		Assert.assertEquals(nameResponse, countryName,
				"Country names are not matching Expected: " + countryName + " ,But found: " + nameResponse);
	}

	public JSONArray getMessagesFromResponse(Response response) {
		JSONObject restResponseObject = getResponseObject(response);
		JSONArray messages = restResponseObject.getJSONArray("messages");
		return messages;
	}

	public void validateResponseMessageSuccess(Response response, String countryCode) {
		JSONArray messages = getMessagesFromResponse(response);
		Assert.assertEquals(messages.get(0), "Country found matching code [" + countryCode + "].");
	}

	public void validateResponseMessageFail(Response response, String countryCode) {
		JSONArray messages = getMessagesFromResponse(response);
		Assert.assertEquals(messages.get(0), "No matching country found for requested code [" + countryCode + "].");
	}
	
	public void validateResponseMessageTotalRecords(Response response, String count) {
		JSONArray messages = getMessagesFromResponse(response);
		Assert.assertEquals(messages.get(0), "Total [" + count + "] records found.");
	}

	public void validateFirstCountry(Response response, String country) {
		JSONObject resultObject = getResponseObject(response);
		JSONArray result = resultObject.getJSONArray("result");
		String firstCountry = result.get(0).toString();
		JSONObject countryName = new JSONObject(firstCountry);
		
		Assert.assertEquals(countryName.getString("name").toString(), country);
	}
}
