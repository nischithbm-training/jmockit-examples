package jmockit.examples.users;

import jmockit.examples.basicwithoutmocking.CommonUtil;
import jmockit.examples.mockingstaticmethods.ValidationUtil;
import jmockit.examples.users.storage.UserStore;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserServiceUsingJMockitTest {
	private UserService userService;

	@Mocked
	private UserStore mockedUserStore;

	@BeforeMethod
	public void beforeMethod() {
		userService = new UserService(mockedUserStore);
	}

	@Test(expectedExceptions = {IllegalArgumentException.class})
	public void testCreateUser_ExpectException_WhenValidationFails(@Mocked final User mockedUser)
	throws Exception {
		new NonStrictExpectations(ValidationUtil.class){{
			ValidationUtil.validateShouldNotBeEmpty(mockedUser, anyString);
				result = new IllegalArgumentException("Test exception");
				times = 1;

			ValidationUtil.validateStringShouldNotBeEmpty(anyString, anyString); times = 0; // this should never be called
		}};

		new NonStrictExpectations(CommonUtil.class) {{
			CommonUtil.isStringEmptyOrNull(anyString); times = 0; // this should never be called
		}};

		new NonStrictExpectations() {{
			mockedUserStore.create(mockedUser); times = 0; // this should never be called
			mockedUserStore.update(mockedUser); times = 0; // this should never be called
		}};


		// Method under test
		userService.save(mockedUser);
	}

	@Test
	public void testCreateUser_AssertValues(@Mocked final User mockedUser, @Mocked final User mockedCreatedUser)
	throws Exception {
		new NonStrictExpectations(ValidationUtil.class){{
			ValidationUtil.validateShouldNotBeEmpty(mockedUser, anyString);
				times = 1; // should be called exactly once

			ValidationUtil.validateStringShouldNotBeEmpty(anyString, anyString);
				times = 2; // should be called exactly once
		}};

		new NonStrictExpectations(CommonUtil.class) {{
			CommonUtil.isStringEmptyOrNull(anyString);
				result = true; times = 1; // should be called exactly once
		}};


		new NonStrictExpectations() {{
			mockedUser.getId(); result = null;
			mockedUserStore.create(mockedUser);
				result = mockedCreatedUser; times = 1; // should be called exactly once

			mockedUserStore.update(mockedUser); times = 0; // this should never be called
		}};

		// Method under test
		User savedUser = userService.save(mockedUser);

		// Check if savedUser which u got it is exactly same as it is returned by userStore.create() method
		Assert.assertEquals(savedUser, mockedCreatedUser);
	}

}
