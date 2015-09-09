package testcase.Demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_IOS;

public class testIOS {

	private UP_IOS up;

	@BeforeClass
	public void setUp() {

		up = new UP_IOS();
		up.log("开始测试：");
		up.openApp();
	}

	/**
	 * 测试名称：
	 * 测试步骤:
	 * 1.
	 * 2.
	 * 期望结果：
	 */
	@Test
	public void test010Demo() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
