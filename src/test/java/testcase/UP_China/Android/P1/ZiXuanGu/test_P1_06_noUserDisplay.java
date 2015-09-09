package testcase.UP_China.Android.P1.ZiXuanGu;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_06_noUserDisplay {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.openApp();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：初始列表显示
	 * [前提条件]：
	 * 1、用户未登录，本地有自选股；
	 * [测试步骤]：
	 * 1、进入自选股界面；
	 * [预期结果]：
	 * 1、名称（代码）列：显示名称，名称下面显示代码；
	 * 2、现价列显示现价；
	 * 3、涨跌幅列显示涨跌幅；
	 * 4、初始排序按照添加自选股的先后顺序排序；
	 */

	@Test
	public void testAnalyseStock() {

		up.log("开始测试：从自选股列表进入品种分析页");
		up.goHomePage();
		up.verifyIsShown("跳转自选");
		up.clickOn("跳转自选");

		up.clickOn("自选提示");
		up.clickOn("搜索");
		up.clickOn("0");
		up.verifyIsShown("加自选");
		up.clickOn("加自选");
		up.verifyIsShown("已添加");
		String result = up.getValueOf("搜索1");
		up.clickOn("返回");

		up.verifyIsShown("名称1");
		up.clickOn("名称1");

		up.clickOn("个股提示");
		up.compareText("个股名称", result);

	}
}
