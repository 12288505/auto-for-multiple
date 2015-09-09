package testcase.UP_China.Android.P1.GuPiaoZongHePing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_17_dropList {

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
	 * 测试名称：从股票综合屏跌幅榜进入股票品种分析页
	 * 测试步骤:
	 * 1、点击跌幅榜列表任一只股票
	 * 期望结果：
	 * 1、进入所点击股票所在品种分析页
	 */
	@Test
	public void testDefaultSort() {

		up.log("开始测试：从股票综合屏跌幅榜进入股票品种分析页");
		up.goHomePage();
		up.verifyIsShown("跳转行情");
		up.clickOn("跳转行情");
		up.verifyIsShown("行情");
		up.swipeUpToElement("跌股1");
		up.verifyIsShown("跌股1");
		up.clickOn("跌股1");
		up.clickOn("操作提示");
		up.verifyIsShown("标题");
	}
}
