package testcase.UP_Metal.Android.P1.YanJiuSuo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UPMetal_Android;

public class test_P1_01_quanburuko {

	private UPMetal_Android up;

	@BeforeClass
	public void setUP() {

		up = new UPMetal_Android();
		up.log("开始测试：入口");
		up.openApp();
	}

	/**
	 * 测试名称：01 入口
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、底部导航－研究所
	 * 2、
	 * [预期结果]：
	 * 1、进入｛研究所｝－｛全部｝
	 */
	@Test
	public void testQuanburuko() {

		up.goHomePage();
		up.verifyIsShown("跳转研究所");
		up.clickOn("跳转研究所");
		up.verifyIsShown("全部");

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
