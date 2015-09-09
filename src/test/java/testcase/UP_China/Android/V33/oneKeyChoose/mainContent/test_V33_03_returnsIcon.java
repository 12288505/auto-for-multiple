package testcase.UP_China.Android.V33.oneKeyChoose.mainContent;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_V33_03_returnsIcon {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：返回图标");
		up.openApp();
	}

	/**
	 * 测试名称：03 返回图标
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、点击左上角返回图标
	 * [预期结果]：
	 * 1、返回至｛一键选股｝
	 */
	@Test
	public void test010returnsIcon() {

		up.goHomePage();

		up.verifyIsShown("选股");
		up.clickOn("选股");

		up.verifyIsShown("一键选股");
		up.clickOn("一键选股");

		up.verifyIsShown("MACD金叉");
		up.clickOn("MACD金叉");

		up.verifyIsShown("形态名称");

		up.clickOn("返回");
		up.verifyIsShown("一键选股标题");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
