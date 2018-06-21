package webApi.automation.frontend.login;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
/**
 * Description: User should be able to login with correct credentials
 * 
 * Steps:
 * 1. Maximaze browser window
 * 2. Navigate to http://phptravels.net/admin
 * 3. Enter incorrect credentials
 * 4. Click sign in
 * 5. Validate user is not logged in
 * 
 * 
 * @author n.orozovic
 *
 */
public class ShouldNotLogInWithInccorectCredentialsTest extends LoginBaseTest {

	@Test
	public void shouldNotLogInWithIncorrectCredentials() throws InterruptedException {
		maximazeWindow();
		loginPageIsOpened(true);
		enterCredentials(RandomStringUtils.randomAlphanumeric(5) + "@" + RandomStringUtils.randomAlphanumeric(5) + ".com", RandomStringUtils.randomAlphanumeric(5));
		clickSignIn();
		userIsSignedIn(false);
		validateErrorMessage(propertiesLoader.getDataProperty("msg.invalid.credentials"));
	}

}
