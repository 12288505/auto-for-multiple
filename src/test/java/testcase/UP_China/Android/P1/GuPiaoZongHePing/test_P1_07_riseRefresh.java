package testcase.UP_China.Android.P1.GuPiaoZongHePing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_07_riseRefresh {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：股票综合屏涨幅榜数据刷新");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：股票综合屏涨幅榜数据刷新
	 * 测试步骤:
	 * 1、查看涨幅榜数据刷新频率
	 * 期望结果：
	 * 1、涨幅榜刷新频率与所设置的行情刷新频率一致
	 */
	@Test(dependsOnGroups = "stock time")
	public void testDefaultSort() {

		up.goHomePage();
		up.clickOn("跳转行情");
		up.waitByTimeout(1000);
		up.swipeUpToElement("涨幅榜");

		up.checkDataRefresh("涨股1现价", "涨股2现价");

	}
}
