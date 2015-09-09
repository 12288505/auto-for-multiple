package testcase.UP_China.Android.P1.XuanGU;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_01_YeMianJiaoHu {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：页面交互");
		up.openApp();
	}

	/**
	 * 测试名称：01 页面交互
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、｛选股｝页面点击左上返回图标，观察页面跳转
	 * 2、点击基金重仓
	 * 3、点击社保重仓
	 * 4、点击QFII重仓
	 * [预期结果]：
	 * 1、返回至首页
	 * 2、页面跳转到基金重仓详情页面
	 * 3、页面跳转到社保重仓详情页面
	 * 4、页面跳转到QFII重仓详情页面
	 */
	@Test
	public void testYeMianJiaoHu() {

		up.goHomePage();
		up.verifyIsShown("选股");
		up.clickOn("选股");
		up.verifyIsShown("返回");
		up.clickOn("返回");
		up.verifyIsShown("自选");
		
		up.verifyIsShown("选股");
		up.clickOn("选股");
		up.swipeUpToElement("QFII重仓");
		
		up.verifyIsShown("基金重仓");
		up.clickOn("基金重仓");
		up.log(up.getValueOf("标题"));
		up.clickOn("返回");
		
		up.verifyIsShown("社保重仓");
		up.clickOn("社保重仓");
		up.log(up.getValueOf("标题"));
		up.clickOn("返回");
		
		up.verifyIsShown("QFII重仓");
		up.clickOn("QFII重仓");
		up.log(up.getValueOf("标题"));
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
