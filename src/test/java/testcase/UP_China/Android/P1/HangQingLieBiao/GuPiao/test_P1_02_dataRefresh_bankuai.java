package testcase.UP_China.Android.P1.HangQingLieBiao.GuPiao;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_02_dataRefresh_bankuai {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：列表数据刷新");
		up.openApp();
	}

	/**
	 * 测试名称：列表数据刷新
	 * [前提条件]：
	 * [测试步骤]：
	 * 路径：底部的行情-更多-板块
	 * 1、查看名称、涨跌幅、领涨个股数据刷新频率
	 * 2、与PC端比较名称、涨跌幅、领涨个股字段
	 * [预期结果]：
	 * 1、刷新频率与所设置的行情频率一致
	 * 2、名称、涨跌幅、领涨个股数据与PC端一致；
	 * 
	 * 注释：自动化跟PC端比较无法实现
	 */
	@Test(dependsOnGroups = "stock time")
	public void test010Demo() {

		up.goHomePage();
		up.clickOn("跳转行情");
		up.clickOn("更多");
		up.clickOn("板块");

		up.verifyIsShown("标题");
		up.checkDataRefresh("涨幅1","涨幅2");

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
