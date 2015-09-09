package testcase.UP_China.Android.P1.ZiXuanGu;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_05_analyseStock {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.openApp();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：从自选股列表进入品种分析页
	 * 测试步骤:
	 * 前提：
	 * 1、自选股列表有多只自选股
	 * 步骤：
	 * 1、点击任一自选股票所在行；
	 * 期望结果：
	 * 1、进入所点击的品种的分析页面；
	 */

	@Test
	public void testAnalyseStock() {

		up.log("开始测试：从自选股列表进入品种分析页");
		up.goHomePage();
		up.verifyIsShown("跳转自选");
		up.clickOn("跳转自选");

		up.clickOn("自选提示");
		up.clickOn("搜索");
		up.clickOn("0");
		up.verifyIsShown("加自选");
		up.clickOn("加自选");
		up.verifyIsShown("已添加");
		String result = up.getValueOf("搜索1");
		up.clickOn("返回");

		up.verifyIsShown("名称1");
		up.clickOn("名称1");

		up.clickOn("个股提示");
		up.compareText("个股名称", result);

	}
}
