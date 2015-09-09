package testcase.UP_China.Android.P1.Wode;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_06_loginHomePage {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：登录系统");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：登录系统
	 * [前提条件]：
	 * [测试步骤]：
	 * 我的-点击登录-输入有效帐号密码后登录
	 * [预期结果]：
	 * 登录正常
	 */
	@Test
	public void testloginHomePage() {

		up.goHomePage();
		up.login();

		up.verifyIsShown("头像");
		up.verifyIsShown("昵称");

	}
}
