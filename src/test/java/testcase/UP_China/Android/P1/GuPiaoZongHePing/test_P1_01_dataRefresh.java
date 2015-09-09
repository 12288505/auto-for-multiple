package testcase.UP_China.Android.P1.GuPiaoZongHePing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_01_dataRefresh {

	/**
	 * 
	 * TODO
	 */
	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：股票综合屏指数数据刷新");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：股票综合屏指数数据刷新
	 * 测试步骤:
	 * 1、查看指数区域数据刷新频率
	 * 期望结果：
	 * 1、指数区域刷新频率与所设置的行情刷新频率一致
	 */
	@Test(dependsOnGroups="stock time")
	public void testDataRefresh() {

		up.goHomePage();
		up.clickOn("跳转行情");

		up.checkDataRefresh("上证指数值", "深证成指值");

	}
}
