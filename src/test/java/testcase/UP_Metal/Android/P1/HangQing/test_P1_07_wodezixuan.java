package testcase.UP_Metal.Android.P1.HangQing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UPMetal_Android;

public class test_P1_07_wodezixuan {

	private UPMetal_Android up;

	@BeforeClass
	public void setUP() {

		up = new UPMetal_Android();
		up.log("开始测试：添加我的自选");
		up.openApp();
	}

	/**
	 * 测试名称：07 添加我的自选
	 * [测试步骤]：
	 * 1、打开app默认进入【行情】页
	 * 2、在页面中部自选行情区域，点击+按钮进入我的自选页面
	 * 3、点击添加自选区域点击切换不同市场，选择任意品种点击
	 * 
	 * [预期结果]：
	 * 1、该品种出现在已选品种区域，排列在最后端
	 */
	@Test
	public void testQuanburuko() {

		up.goHomePage();

		up.verifyIsShown("自加选",4);
		up.clickOn("自加选",4);
		
		up.verifyIsShown("添加品种");
		up.clickOn("添加品种");
		up.clickOn("自选返回");
		
		up.waitByTimeout(3000);
		up.verifyIsShown("标题");
		up.clickOn("自加选",5);
		up.verifyIsShown("添加品种");
		up.clickOn("添加品种");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
