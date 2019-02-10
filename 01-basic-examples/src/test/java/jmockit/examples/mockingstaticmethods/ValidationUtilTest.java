package jmockit.examples.mockingstaticmethods;

import jmockit.examples.basicwithoutmocking.CommonUtil;
import mockit.Mock;
import mockit.MockUp;
import mockit.NonStrictExpectations;

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
		 * 
		 * Note: We are mocking it using a different approach
		 * 			using new NonStrictExpectations(CommonUtil.class) {{ }} instead of 
		 * 			instead of new MockUp<CommonUtil>(){ }
		 */
		new NonStrictExpectations(CommonUtil.class) {{
			// Optional "times = 1": Specifies the number of invocations expected
			CommonUtil.isNull(any); result = false; times = 1;
		}};

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
		final String inputStr = "test string";
		/*
		 * Mocking Static method CommonUtil.isStringEmptyOrNull(String str); to return false for this test case
		 */
		new NonStrictExpectations(CommonUtil.class) {{
			CommonUtil.isStringEmptyOrNull(inputStr); result = false; times = 1;
		}};

		/*
		 * Actual method under test
		 */
		ValidationUtil.validateStringShouldNotBeEmpty(inputStr, "TestString");
	}
}
