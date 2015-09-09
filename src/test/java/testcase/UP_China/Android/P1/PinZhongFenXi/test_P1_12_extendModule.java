package testcase.UP_China.Android.P1.PinZhongFenXi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_12_extendModule {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：04 各模块的展开、收起操作");
		up.openApp();
	}

	/**
	 * 测试名称：04 各模块的展开、收起操作
	 * [测试步骤]：
	 * 路径：底部的行情-更多-沪深A股-任一股票-F10
	 * 1、点击任意品种进入品种分析页；
	 * 2、切换至F10页面；
	 * 
	 * [预期结果]：
	 * 1、点击向下的三角图标，收起模块；
	 * 2、点击向右的三角图标，展开模块；
	 */
	@Test
	public void testExtendModule() {

		up.goHomePage();

		up.goToStock();

		up.clickOn("搜索");
		up.clickOn("搜索框");
		up.clickOn("0");

		up.verifyIsShown("名称");
		up.clickOn("名称");
		up.clickOn("操作提示");

		up.verifyIsShown("F10");
		up.clickOn("F10");
		up.swipeUpToElement("F10");
		up.verifyIsShown("F10");

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
