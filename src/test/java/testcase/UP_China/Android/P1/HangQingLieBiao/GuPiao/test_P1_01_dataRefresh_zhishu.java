package testcase.UP_China.Android.P1.HangQingLieBiao.GuPiao;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_01_dataRefresh_zhishu {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：数据定时刷新");
		up.openApp();
	}

	/**
	 * 测试名称：数据定时刷新
	 * 
	 * 
	 * [测试步骤]：
	 * 路径：底部的行情-更多-指数
	 * 1、查看指数行情列表数据（现价、涨幅）变化频率
	 * 2、
	 * 
	 * [预期结果]：
	 * 1、行情数据（现价、涨幅）刷新频率与所设置的行情刷新频率一致
	 * 2、
	 */
	@Test(dependsOnGroups = "stock time")
	public void test010Demo() {

		up.goHomePage();
		up.clickOn("跳转行情");
		up.clickOn("更多");
		up.clickOn("指数");
		up.clickOn("操作提示");

		up.verifyIsShown("标题");

		up.checkDataRefresh("现价1", "现价2");

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
