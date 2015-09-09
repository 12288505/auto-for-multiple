package testcase.UP_China.Android.P1.PinZhongFenXi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_08_dataRefreshMK {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：数据刷新规则");
		up.openApp();
	}

	/**
	 * 测试名称：数据刷新规则
	 * [测试步骤]：
	 * 路径：底部的行情-更多-沪深A股-任一股票-月K
	 * 1、在品种分析页停留5秒；
	 * 2、在品种分析页停留15秒；
	 * 3、在品种分析页停留30秒；
	 * 4、在品种分析页停留60秒；
	 * 
	 * [预期结果]：
	 * 1、步骤一执行完后，MA5、MA10、MA20、MA60、DIFF、DEA、MACD7个字段数据5秒刷新一次；
	 * 2、步骤二执行完后，7个字段数据15秒刷新一次；
	 * 3、步骤三执行完后，7个字段数据30秒刷新一次；
	 * 4、步骤四执行完后，7个字段数据60秒刷新一次；
	 */
	@Test(dependsOnGroups = "stock time")
	public void testDataRefreshMK() {

		up.goHomePage();
		up.goToStock();

		up.verifyIsShown("品种名称");
		up.clickOn("品种名称");
		up.clickOn("操作提示");

		up.verifyIsShown("月K");
		up.clickOn("月K");
		up.clickOn("操作提示");
		up.verifyIsShown("分析图");

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
