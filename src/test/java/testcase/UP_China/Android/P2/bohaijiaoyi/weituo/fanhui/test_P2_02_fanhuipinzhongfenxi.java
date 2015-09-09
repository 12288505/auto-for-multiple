package testcase.UP_China.Android.P2.bohaijiaoyi.weituo.fanhui;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_02_fanhuipinzhongfenxi {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：返回品种分析页");
		up.openApp();

	}

	/**
	 * 测试名称：02 返回品种分析页
	 * [前提条件]：
	 * 1、从品种分析页进入渤海交易
	 * [测试步骤]：
	 * 1、点击委托界面标题栏左侧的返回图标；
	 * [预期结果]：
	 * 1、返回到进入渤海交易时的品种分析页；
	 */
	@Test
	public void testFanhuipinzhongfenxi() {

		up.goHomePage();
		up.verifyIsShown("渤海商品");
		up.clickOn("渤海商品");
		up.verifyIsShown("渤海3名称");
		up.clickOn("渤海3名称");
		up.clickOn("操作提示");
		up.verifyIsShown("交易");
		up.clickOn("交易");
		up.login_BH();
		up.verifyIsShown("返回");
		up.clickOn("返回");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
