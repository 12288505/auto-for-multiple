package testcase.UP_China.Android.V33.oneKeyChoose.mainContent;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_V33_10_refreshStock {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：股票列表数据每15秒刷新一次");
		up.openApp();
	}

	/**
	 * 测试名称：16 股票列表数据每15秒刷新一次
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、在一键选股界面选中任意一个指标，进入选股的股票列表
	 * 2、查看股票列表数据刷新
	 * [预期结果]：
	 * 1、股票列表数据每隔15秒刷新一次
	 */
	@Test(dependsOnGroups = "stock time")
	public void testRefreshStock() {

		up.goHomePage();

		up.verifyIsShown("选股");
		up.clickOn("选股");

		up.verifyIsShown("一键选股");
		up.clickOn("一键选股");

		up.verifyIsShown("MACD金叉");
		up.clickOn("MACD金叉");

		up.verifyIsShown("股票");
		up.selectValidStock("股票", "股票现价");

		up.clickOn("操作提示");
		up.verifyIsShown("标题");
		up.verifyIsShown("代码");

		up.checkDataRefresh("现价", 15);

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
