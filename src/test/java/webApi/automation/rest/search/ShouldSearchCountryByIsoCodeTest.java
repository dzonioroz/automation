package webApi.automation.rest.search;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import webApi.automation.rest.BaseRestTest;

public class ShouldSearchCountryByIsoCodeTest extends BaseRestTest {

	@Test
	public void shouldSearchCountryByIso2Code() {
		String searchByIso2Code = BASE_URL + SEARCH_URL + alpha2code;
		Response response = getRequestJson(STATUS_OK,searchByIso2Code);
		Long time = response.time();
		System.out.println("Response time in milliseconds is: " + time);

		validateResponseMessageTotalRecords(response, "44");
	}
	
	@Test
	public void shouldSearchCountryByIso3Code() {
		String searchByIso3Code = BASE_URL + SEARCH_URL + alpha3code;
		Response response = getRequestJson(STATUS_OK,searchByIso3Code);
		Long time = response.time();
		System.out.println("Response time in milliseconds is: " + time);

		validateResponseMessageTotalRecords(response, "3");
	}

}
