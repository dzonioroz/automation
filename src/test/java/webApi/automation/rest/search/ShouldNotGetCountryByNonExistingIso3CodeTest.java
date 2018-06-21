package webApi.automation.rest.search;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import webApi.automation.rest.BaseRestTest;

public class ShouldNotGetCountryByNonExistingIso3CodeTest extends BaseRestTest {

	@Test
	public void shouldNotGetCountryByNonExistingIso3Code() {
		String nonExistingIso3Code = "QQQ";
		String iso3CodePath = BASE_URL + ISO3CODE_URL + nonExistingIso3Code;
		Response response = getRequestJson(STATUS_OK,iso3CodePath);
		Long time = response.time();
		System.out.println("Response time in milliseconds is: " + time);
		System.out.println(response.asString());

		validateResponseMessageFail(response, nonExistingIso3Code);
	}

}
