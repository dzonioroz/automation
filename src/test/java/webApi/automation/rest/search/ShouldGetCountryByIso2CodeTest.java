package webApi.automation.rest.search;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import webApi.automation.rest.BaseRestTest;

public class ShouldGetCountryByIso2CodeTest extends BaseRestTest {
	
	@Test
	public void shouldGetCountryByIso2Code() {
		String iso2CodePath = BASE_URL + ISO2CODE_URL + alpha2code;
		Response response = getRequestJson(STATUS_OK,iso2CodePath);
		Long time = response.time();
		System.out.println("Response time in milliseconds is: " + time);
		System.out.println(response.asString());

		validateResponseIso2Code(response, alpha2code);
		validateResponseName(response, countryName);
		validateResponseMessageSuccess(response, alpha2code);
	}

}
