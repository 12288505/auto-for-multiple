package testcase.UP_China.Android.P1.GuPiaoZongHePing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_16_riseList {

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
	 * 测试名称：从股票综合屏涨幅榜进入股票品种分析页
	 * 测试步骤:
	 * 1、点击涨幅榜列表任一只股票
	 * 期望结果：
	 * 1、进入所点击股票所在品种分析页
	 */
	@Test
	public void testRiseList() {

		up.log("开始测试：从股票综合屏涨幅榜进入股票品种分析页");
		up.goHomePage();
		up.verifyIsShown("跳转行情");
		up.clickOn("跳转行情");
		up.verifyIsShown("行情");
		up.swipe("up");
		up.verifyIsShown("涨股1");
		up.clickOn("涨股1");
		up.clickOn("操作提示");
		up.verifyIsShown("标题");
	}
}
