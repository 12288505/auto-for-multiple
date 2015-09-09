package testcase.UP_China.Android.P1.Wode;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_05_setZhi {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：设置界面");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：设置界面
	 * [前提条件]：
	 * [测试步骤]：
	 * 我的-登录系统-设置
	 * [预期结果]：
	 * 设置界面显示正常
	 */
	@Test
	public void testyiJianFanKui() {

		up.goHomePage();
		up.login();

		up.verifyIsShown("设置");
		up.clickOn("设置");

		up.verifyIsShown("服务器");
		up.verifyIsShown("刷新频率");
		up.verifyIsShown("清除缓存");
		up.verifyIsShown("使用帮助");
		up.verifyIsShown("软件升级");
		up.verifyIsShown("关于");

	}
}
