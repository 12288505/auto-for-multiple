package testcase.UP_Metal.Android.P1.YanJiuSuo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UPMetal_Android;

public class test_P1_09_jishuruko {

	private UPMetal_Android up;

	@BeforeClass
	public void setUP() {

		up = new UPMetal_Android();
		up.log("开始测试：入口");
		up.openApp();
	}

	/**
	 * 测试名称：09 入口
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、底部导航－研究所－技术学堂
	 * [预期结果]：
	 * 1、进入｛研究所｝－｛技术学堂｝
	 */
	@Test
	public void testJishuruko() {

		up.goHomePage();
		up.verifyIsShown("跳转研究所");
		up.clickOn("跳转研究所");
		up.waitByTimeout(3000);
		up.swipe(9,1.8,5,1.8,3000);
		up.verifyIsShown("技术学堂");
		up.clickOn("技术学堂");
		up.verifyIsShown("技术学堂");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
