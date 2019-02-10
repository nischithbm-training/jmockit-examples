package jmockit.examples.basicwithoutmocking;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CommonUtilTest {

	@Test(dataProvider = "dpIsNull")
	public void testIsNull(Object input, boolean expectedResult) {
		boolean result = CommonUtil.isNull(input);
		Assert.assertEquals(result, expectedResult);
	}

	@DataProvider
	public Object[][] dpIsNull() {
		return new Object[][]{
			new Object[] {null, true},
			new Object[] {"", false},
			new Object[] {"someRandomString", false},
			new Object[] {new Long(10), false}
		};
	}

	@Test(dataProvider = "dpIsStringEmptyOrNull_AssertTrue")
	public void testIsStringEmptyOrNull_AssertTrue(String str) {
		Assert.assertTrue(CommonUtil.isStringEmptyOrNull(str));
	}
	
	@Test(dataProvider = "dpIsStringEmptyOrNull_AssertFalse")
	public void testIsStringEmptyOrNull_AssertFalse(String str) {
		Assert.assertFalse(CommonUtil.isNull(str));
	}

	/*
	 * Data Providers
	 */
	@DataProvider
	public Object[][] dpIsStringEmptyOrNull_AssertTrue() {
		return new Object[][] {
			new Object[]{ null },
			new Object[]{ "" },
			new Object[]{ " " },
			new Object[]{ new String() },
			new Object[]{ new String("") },
			new Object[]{ new String(" ") }
		};
	}
	
	@DataProvider
	public Object[][] dpIsStringEmptyOrNull_AssertFalse() {
		return new Object[][] {
			new Object[]{ "someRandomString" },
			new Object[]{ new String("someRandomString") }
		};
	}
	
}
