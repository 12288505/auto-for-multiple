package testcase.UP_China.Android.P1.Wode;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_07_shouCang {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：我的收藏");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：我的收藏
	 * [前提条件]：
	 * [测试步骤]：
	 * 我的-登录系统-我的收藏
	 * [预期结果]：
	 * 我的收藏界面显示正常
	 */
	@Test
	public void testshouCang() {

		up.goHomePage();
		up.login();

		up.verifyIsShown("我的收藏");
		up.clickOn("我的收藏");

		up.verifyIsShown("编辑");
		up.verifyIsShown("收藏内容");

	}
}
