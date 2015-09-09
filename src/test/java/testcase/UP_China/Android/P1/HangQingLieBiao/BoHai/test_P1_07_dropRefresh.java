package testcase.UP_China.Android.P1.HangQingLieBiao.BoHai;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_07_dropRefresh {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：渤海商品综合屏跌幅榜数据刷新");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：渤海商品综合屏跌幅榜数据刷新
	 * 测试步骤:
	 * 1、查看跌幅榜数据刷新频率
	 * 期望结果：
	 * 1、跌幅榜刷新频率与所设置的行情刷新频率一致
	 */
	@Test(dependsOnGroups = "Bohai time")
	public void testDataRefresh() {

		up.goHomePage();
		up.verifyIsShown("渤海商品");
		up.clickOn("渤海商品");

		up.verifyIsShown("渤海1");
		up.swipeUpToElement("跌幅2现价");

		up.checkDataRefresh("跌幅1现价", "跌幅2现价");

	}
}
