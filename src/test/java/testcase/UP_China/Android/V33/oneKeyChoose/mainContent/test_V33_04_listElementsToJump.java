package testcase.UP_China.Android.V33.oneKeyChoose.mainContent;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_V33_04_listElementsToJump {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：列表元素跳转");
		up.openApp();
	}

	/**
	 * 测试名称：04 列表元素跳转
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、点击列表中的项
	 * [预期结果]：
	 * 1、跳转至股票分析页
	 */
	@Test
	public void test010listElementsToJump() {

		up.goHomePage();

		up.verifyIsShown("选股");
		up.clickOn("选股");

		up.verifyIsShown("一键选股");
		up.clickOn("一键选股");

		up.verifyIsShown("MACD金叉");
		up.clickOn("MACD金叉");

		up.verifyIsShown("股票");
		up.clickOn("股票");

		up.clickOn("操作提示");
		up.verifyIsShown("标题");
		up.verifyIsShown("代码");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
