package testcase.UP_China.Android.P1.PinZhongFenXi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_13_swipeCapital {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：05 资金可以上下滑屏");
		up.openApp();
	}

	/**
	 * 测试名称：05 资金可以上下滑屏
	 * [测试步骤]：
	 * 路径：底部的行情-更多-沪深A股-任一股票-资金
	 * 1、点击任意品种进入品种分析页；
	 * 2、切换至资金页面；
	 * 3、上下滑动屏幕；
	 * 
	 * [预期结果]：
	 * 1、查看被隐藏的内容；
	 */
	@Test
	public void testSwipeCapital() {

		up.goHomePage();

		up.goToStock();

		up.clickOn("搜索");
		up.clickOn("搜索框");
		up.clickOn("0");

		up.verifyIsShown("名称");
		up.clickOn("名称");
		up.clickOn("操作提示");

		up.verifyIsShown("资金");
		up.clickOn("资金");
		up.swipeUpToElement("资金");
		up.verifyIsShown("资金");

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
