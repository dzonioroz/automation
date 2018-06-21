package webApi.automation.rest.search;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import webApi.automation.rest.BaseRestTest;

public class ShouldNotGetCountryByNonExistingIso2CodeTest extends BaseRestTest {

	@Test
	public void shouldNotGetCountryByNonExistingIso2Code() {
		String nonExistingIso2Code = "QQ";
		String iso2CodePath = BASE_URL + ISO2CODE_URL + nonExistingIso2Code;
		Response response = getRequestJson(STATUS_OK, iso2CodePath);
		Long time = response.time();
		System.out.println("Response time in milliseconds is: " + time);
		System.out.println(response.asString());

		validateResponseMessageFail(response, nonExistingIso2Code);
	}

}
