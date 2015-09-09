package testcase.UP_China.Android.P1.Wode;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_01_loginPage {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：登录界面");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：登录界面
	 * [前提条件]：
	 * [测试步骤]：
	 * 我的-点击登录
	 * [预期结果]：
	 * 登录界面显示正常
	 */
	@Test
	public void testLoginPage() {

		up.goHomePage();
		up.login();

	}
}
