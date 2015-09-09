package testcase.UP_China.Android.P1.GuPiaoZongHePing;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_14_analyseIndex {

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
	 * 测试名称：从股票综合屏进入指数品种分析页
	 * 测试步骤:
	 * 1、点击股票综合屏上证指数区域
	 * 期望结果：
	 * 1、进入上证指数品种分析页面；
	 */
	@Test
	public void testAnalyseIndex() {

		up.log("开始测试：从股票综合屏进入指数品种分析页");
		up.goHomePage();
		up.verifyIsShown("跳转行情");
		up.clickOn("跳转行情");
		up.clickOn("上证指数");
		up.clickOn("操作提示");
		up.verifyIsShown("标题");
		Assert.assertEquals("上证指数", up.getValueOf("标题"));

	}
}
