package webApi.automation.frontend.login;

import org.testng.annotations.Test;
/**
 * Description: User should be able to login with correct credentials
 * 
 * Steps:
 * 1. Maximaze browser window
 * 2. Navigate to http://phptravels.net/admin
 * 3. Enter correct credentials
 * 4. Click sign in
 * 5. Validate user is logged in
 * 
 * 
 * @author n.orozovic
 *
 */
public class ShouldLoginWithCorrectCredentialsTest extends LoginBaseTest {

	@Test
	public void shouldLoginWithCorrectCredentials() throws InterruptedException {
		maximazeWindow();
		loginPageIsOpened(true);
		enterCredentials(propertiesLoader.getDataProperty("email"), propertiesLoader.getDataProperty("password"));
		clickSignIn();
		userIsSignedIn(true);
	}
	
}
