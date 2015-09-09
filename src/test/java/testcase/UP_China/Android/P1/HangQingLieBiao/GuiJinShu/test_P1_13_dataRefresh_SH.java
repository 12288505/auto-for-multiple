package testcase.UP_China.Android.P1.HangQingLieBiao.GuiJinShu;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_13_dataRefresh_SH {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：贵金属综合屏上海黄金列表数据刷新");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：贵金属综合屏上海黄金列表数据刷新
	 * 测试步骤:
	 * 1、查看贵金属综合屏上海黄金数据刷新频率
	 * 期望结果：
	 * 1、刷新频率与所设置的行情刷新频率一致
	 */
	@Test(dependsOnGroups = "Guijinshu time")
	public void testDataRefresh() {

		up.log("开始测试：贵金属综合屏上海黄金列表数据刷新");
		up.goHomePage();

		up.verifyIsShown("贵金属");
		up.clickOn("贵金属");
		up.verifyIsShown("天通银");
		up.swipeUpToElement("白银T+D现价");
		up.waitByTimeout(1000);

		up.checkDataRefresh("白银9999现价", "白银T+D现价");
	}
}
