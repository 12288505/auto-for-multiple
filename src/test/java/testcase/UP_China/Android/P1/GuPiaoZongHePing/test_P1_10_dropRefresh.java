package testcase.UP_China.Android.P1.GuPiaoZongHePing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_10_dropRefresh {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：股票综合屏跌幅榜数据刷新");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：股票综合屏跌幅榜数据刷新
	 * 测试步骤:
	 * 1、查看跌幅榜数据刷新频率
	 * 期望结果：
	 * 1、跌幅榜刷新频率与所设置的行情刷新频率一致
	 */
	@Test(dependsOnGroups = "stock time")
	public void testDefaultSort() {

		up.goHomePage();
		up.clickOn("跳转行情");
		up.verifyIsShown("上证指数");
		up.swipeUpToElement("跌幅榜");

		up.checkDataRefresh("跌股1现价", "跌股2现价");
	}
}
