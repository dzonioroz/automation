package webApi.automation.rest.search;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import webApi.automation.rest.BaseRestTest;

public class ShouldGetAllCountriesTest extends BaseRestTest {

	@Test
	public void shouldGetAllCountries() {
		String allCountriesPath = BASE_URL + ALL_COUNTRIES_URL;
		Response response = getRequestJson(STATUS_OK, allCountriesPath);
		Long time = response.time();
		System.out.println("Response time in milliseconds is: " + time);

		validateResponseMessageTotalRecords(response, "249");
		validateFirstCountry(response, COUNTRY_AFGANISTAN);
	}
}
