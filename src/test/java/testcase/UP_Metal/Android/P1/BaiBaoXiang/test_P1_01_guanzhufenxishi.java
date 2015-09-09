package testcase.UP_Metal.Android.P1.BaiBaoXiang;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UPMetal_Android;

public class test_P1_01_guanzhufenxishi {

	private UPMetal_Android up;

	@BeforeClass
	public void setUP() {

		up = new UPMetal_Android();
		up.log("开始测试：关注分析师");
		up.openApp();
	}

	/**
	 * 测试名称：01 关注分析师
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、进入【百宝箱】->【银管家】->【分析师】
	 * 2、挑选一只未关注的分析师，点击+关注按钮
	 * [预期结果]：
	 * 1、+关注按钮变为灰色的取消关注
	 */
	@Test
	public void testGuanzhufenxishi() {

		up.goHomePage();
		up.verifyIsShown("跳转百宝箱");
		up.clickOn("跳转百宝箱");
		up.verifyIsShown("银管家");
		up.clickOn("银管家");
		up.Jinmudan();
		up.verifyIsShown("分析师");
		up.clickOn("分析师");
		up.verifyIsShown("关注");
		up.clickOn("关注");
		up.verifyIsShown("取消关注");
		
		up.clickOn("取消关注");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
