package testcase.UP_Metal.Android.P1.PinZhongFenXi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UPMetal_Android;


public class test_P1_02_guanzhufenxishi {
	private UPMetal_Android up;

	@BeforeClass
	public void setUP() {

		up = new UPMetal_Android();
		up.log("开始测试：广贵品种底部工具栏显示交易选项");
		up.openApp();
	}

	/**
	 * 测试名称：02 广贵品种底部工具栏显示交易选项
	 * [测试步骤]：
	 * 1、打开app默认进入【行情】页
	 * 2、在页面中部自选行情区域，点击任意自选报价
	 * 
	 * [预期结果]：
	 * 1、页面跳转到关联品种分析页面
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
