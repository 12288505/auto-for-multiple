package testcase.UP_China.Android.P1.GuPiaoZongHePing;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_15_hotList {

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
	 * 测试名称：从股票综合屏进入板块成分股列表
	 * 测试步骤:
	 * 1、点击股票综合屏上热门板区域
	 * 期望结果：
	 * 1、进入所点击板块的成分股列表
	 */
	@Test
	public void testHotList() {

		up.log("开始测试：从股票综合屏进入指数品种分析页");
		up.goHomePage();
		up.verifyIsShown("跳转行情");
		up.clickOn("跳转行情");
		up.verifyIsShown("行情");
		String stock = up.getValueOf("热门1名称");
		up.clickOn("热门1");
		up.clickOn("操作提示");
		up.verifyIsShown("标题");
		Assert.assertEquals(stock, up.getValueOf("标题"));
	}
}
