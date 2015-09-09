package testcase.UP_Metal.Android.P1.YanJiuSuo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UPMetal_Android;

public class test_P1_07_meiriruko {

	private UPMetal_Android up;

	@BeforeClass
	public void setUP() {

		up = new UPMetal_Android();
		up.log("开始测试：入口");
		up.openApp();
	}

	/**
	 * 测试名称：07 入口
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、底部导航－研究所－焦点透视
	 * [预期结果]：
	 * 1、进入｛研究所｝－｛焦点透视｝
	 */
	@Test
	public void testMeiriruko() {

		up.goHomePage();
		up.verifyIsShown("跳转研究所");
		up.clickOn("跳转研究所");
		up.verifyIsShown("焦点透视");
		up.clickOn("焦点透视");
		up.verifyIsShown("焦点透视");

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
