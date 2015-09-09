package testcase.UP_China.Android.P2.bohaijiaoyi.weituo.fanhui;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_01_fanhuishouye {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：返回首页");
		up.openApp();

	}

	/**
	 * 测试名称：01 返回首页
	 * [前提条件]：
	 * 1、从首页渤海交易图标处进入渤海交易功能
	 * [测试步骤]：
	 * 1、点击委托界面标题栏左侧返回图标；
	 * [预期结果]：
	 * 1、返回到首页
	 */
	@Test
	public void testFanhuishouye() {

		up.goHomePage();
		up.verifyIsShown("自选");
		up.goToHeader("渤海交易");
		up.login_BH();
		up.verifyIsShown("返回");
		up.clickOn("返回");
		up.verifyIsShown("渤海交易");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
