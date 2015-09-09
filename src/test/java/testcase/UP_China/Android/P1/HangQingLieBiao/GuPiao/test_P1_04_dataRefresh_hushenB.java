package testcase.UP_China.Android.P1.HangQingLieBiao.GuPiao;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_04_dataRefresh_hushenB {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：数据定时刷新");
		up.openApp();
	}

	/**
	 * 测试名称：数据定时刷新
	 * [测试步骤]：
	 * 路径：底部的行情-更多-沪深B股
	 * 1、查看沪深B股行情列表数据（现价、涨幅）变化频率
	 * [预期结果]：
	 * 1、行情数据（现价、涨幅）刷新频率与所设置的行情刷新频率一致
	 */
	@Test(dependsOnGroups = "stock time")
	public void test010Demo() {

		up.goHomePage();
		up.clickOn("跳转行情");
		up.clickOn("更多");
		up.clickOn("沪深B股");

		up.clickOn("操作提示");
		up.verifyIsShown("品种名称");
		up.checkDataRefresh("品种现价", "品种涨幅");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
