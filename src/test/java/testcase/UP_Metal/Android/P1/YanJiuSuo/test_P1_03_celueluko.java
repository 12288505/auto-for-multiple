package testcase.UP_Metal.Android.P1.YanJiuSuo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UPMetal_Android;

public class test_P1_03_celueluko {

	private UPMetal_Android up;

	@BeforeClass
	public void setUP() {

		up = new UPMetal_Android();
		up.log("开始测试：入口");
		up.openApp();
	}

	/**
	 * 测试名称：03 入口
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、底部导航－研究所－策略速递
	 * [预期结果]：
	 * 1、进入｛研究所｝－｛策略速递｝
	 */
	@Test
	public void testCelueluko() {

		up.goHomePage();
		up.verifyIsShown("跳转研究所");
		up.clickOn("跳转研究所");
		up.verifyIsShown("策略速递");
		up.clickOn("策略速递");
		up.verifyIsShown("策略速递");

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
