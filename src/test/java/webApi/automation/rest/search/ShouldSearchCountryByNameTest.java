package webApi.automation.rest.search;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import webApi.automation.rest.BaseRestTest;

public class ShouldSearchCountryByNameTest extends BaseRestTest {

	@Test
	public void shouldSearchCountryByName() {
		String searchByCountryName = BASE_URL + SEARCH_URL + countryName;
		Response response = getRequestJson(STATUS_OK,searchByCountryName);
		Long time = response.time();
		System.out.println("Response time in milliseconds is: " + time);

		validateResponseMessageTotalRecords(response, "2");
	}

}
