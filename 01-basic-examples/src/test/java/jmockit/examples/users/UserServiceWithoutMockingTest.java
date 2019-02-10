package jmockit.examples.users;

import jmockit.examples.users.storage.UserInMemoryStoreImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserServiceWithoutMockingTest {
	private UserService userService;

	@BeforeTest
	public void beforeTest() {
		userService = new UserService(new UserInMemoryStoreImpl());
	}

	@Test(dataProvider = "dpCreateUserValidationFailure", expectedExceptions = {IllegalArgumentException.class})
	public void testCreateUser_ExpectException_WhenValidationFails(User userInput)
	throws Exception {
		userService.save(userInput);
	}

	@Test(dataProvider = "dpCreateUser")
	public void testCreateUser_AssertValues(User inputUser)
	throws Exception {
		User savedUser = userService.save(inputUser);
		String savedUserId = savedUser.getId();
		Assert.assertNotNull(savedUserId);

		Assert.assertEquals(savedUser.getUserName(), inputUser.getUserName());
		Assert.assertEquals(savedUser.getPassword(), inputUser.getPassword());
		Assert.assertEquals(savedUser.getDisplayName(), inputUser.getDisplayName());

		User searchResult = userService.findById(savedUserId);
		Assert.assertEquals(searchResult.getUserName(), inputUser.getUserName());
		Assert.assertEquals(searchResult.getPassword(), inputUser.getPassword());
		Assert.assertEquals(searchResult.getDisplayName(), inputUser.getDisplayName());
	}


	/*
	 * Data providers
	 */

	@DataProvider
	public Object[][] dpCreateUserValidationFailure() {
		return new Object[][] {
				new Object[] {null},
				new Object[] {new User()}
		};
	}


	@DataProvider
	public Object[][] dpCreateUser() {
		User user1 = new User();
		user1.setUserName("spider_man");
		user1.setPassword("marryjane@123");
		user1.setDisplayName("Peter Parker");

		return new Object[][] {
				new Object[] {user1}
		};
	}
}
