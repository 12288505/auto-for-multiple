package testcase.UP_China.Android.P1.Wode;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_04_yiJianFanKui {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：意见反馈");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：意见反馈
	 * [前提条件]：
	 * [测试步骤]：
	 * 我的-登录系统-意见反馈
	 * [预期结果]：
	 * 意见反馈界面显示正常
	 */
	@Test
	public void testyiJianFanKui() {

		up.goHomePage();
		up.login();

		up.verifyIsShown("意见反馈");
		up.clickOn("意见反馈");

		up.verifyIsShown("标题");
		up.setValueTo("意见内容", "UP China is good!");
		up.back();
		up.clickOn("提交");
		up.clickOn("是");
		up.verifyIsShown("脸1");
		up.verifyIsShown("脸2");
		up.verifyIsShown("脸3");

	}
}
