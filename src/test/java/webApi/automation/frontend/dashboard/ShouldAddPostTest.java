package webApi.automation.frontend.dashboard;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * Description: On the Dashboard page all required buttons should be present
 * 
 * 1. Go to Dashboard page
 * 2. Validate all buttons are present
 * 3. Click on Blog button and Posts button
 * 4. Validate user is on Blog Management page
 * 5. Fill post form
 * 6. Validate permalink field is populated and add post
 * 7. Edit added post
 * 8. Delete post
 * 
 * @author n.orozovic
 *
 */
public class ShouldAddPostTest extends DashboardBaseTest{
		
	@BeforeMethod
	public void prepare() {
		login();
	}
	
	@Test
	public void shouldAddPost() {
		userIsOnDashboardPage(true);
		validateAllButtonsArePresent();
		clickBlogAndPostsButton();
		userIsOnBlogManagementPage(true);
		
		clickAddButton();
		userIsOnAddBlogPage(true);
		
		addNewPost();
		
		permalinkFieldIsPopulated();
	}
	
	@BeforeMethod
	public void clean() {
		deletePost();
	}

}
