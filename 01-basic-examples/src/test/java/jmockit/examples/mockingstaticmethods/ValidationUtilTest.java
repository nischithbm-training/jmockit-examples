package jmockit.examples.mockingstaticmethods;

import jmockit.examples.basicwithoutmocking.CommonUtil;
import mockit.Mock;
import mockit.MockUp;

import org.testng.annotations.Test;

public class ValidationUtilTest {

	@Test(expectedExceptions = { IllegalArgumentException.class })
	public void testValidateShouldNotBeEmpty_ExpectIllegalArgumentException_WhenIsNullReturnsTrue() {
		/*
		 * Mocking Static method CommonUtil.isNull(Object o); to return true for this test case
		 */
		new MockUp<CommonUtil>() {
			// Optional "invocations = 1" parameter to @Mock: Specifies the number of invocations expected
			@Mock(invocations = 1)
			boolean isNull(Object o) {
				return true;
			}
		};

		/*
		 * Actual method under test
		 */
		ValidationUtil.validateShouldNotBeEmpty(null, "TestString");
	}

	@Test
	public void testValidateShouldNotBeEmpty_NoException_WhenIsNullReturnsFalse() {
		/*
		 * Mocking Static method CommonUtil.isNull(Object o); to return false for this test case
		 */
		new MockUp<CommonUtil>() {
			// Optional "invocations = 1" parameter to @Mock: Specifies the number of invocations expected
			@Mock(invocations = 1)
			boolean isNull(Object o) {
				return false;
			}
		};

		/*
		 * Actual method under test
		 */
		ValidationUtil.validateShouldNotBeEmpty("test string", "TestString");
	}

	@Test(expectedExceptions = { IllegalArgumentException.class })
	public void testValidateStringShouldNotBeEmpty_ExpectIllegalArgumentException_WhenIsStringEmptyOrNullReturnsTrue() {
		/*
		 * Mocking Static method CommonUtil.isStringEmptyOrNull(String str); to return true for this test case
		 */
		new MockUp<CommonUtil>() {
			// Optional "invocations = 1" parameter to @Mock: Specifies the number of invocations expected
			@Mock(invocations = 1)
			boolean isStringEmptyOrNull(String str) {
				return true;
			}
		};

		/*
		 * Actual method under test
		 */
		ValidationUtil.validateStringShouldNotBeEmpty(null, "TestString");
	}

	@Test
	public void testValidateStringShouldNotBeEmpty_NoException_WhenIsStringEmptyOrNullReturnsFalse() {
		/*
		 * Mocking Static method CommonUtil.isStringEmptyOrNull(String str); to return false for this test case
		 */
		new MockUp<CommonUtil>() {
			// Optional "invocations = 1" parameter to @Mock: Specifies the number of invocations expected
			@Mock(invocations = 1)
			boolean isStringEmptyOrNull(String str) {
				return false;
			}
		};

		/*
		 * Actual method under test
		 */
		ValidationUtil.validateStringShouldNotBeEmpty("test string", "TestString");
	}
}
