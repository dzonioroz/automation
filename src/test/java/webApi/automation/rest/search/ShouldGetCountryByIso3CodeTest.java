package webApi.automation.rest.search;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import webApi.automation.rest.BaseRestTest;

public class ShouldGetCountryByIso3CodeTest extends BaseRestTest {

	@Test
	public void shouldGetCountryByIso3Code() {
		String iso3CodePath = BASE_URL + ISO3CODE_URL + alpha3code;
		Response response = getRequestJson(STATUS_OK, iso3CodePath);
		Long time = response.time();
		System.out.println("Response time in milliseconds is: " + time);

		validateResponseIso3Code(response, alpha3code);
		validateResponseName(response, countryName);
		validateResponseMessageSuccess(response, alpha3code);

	}

}
