package testcase.UP_China.Android.P1.PinZhongFenXi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_11_swipeYanBao {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：08 研报列表可以上下滑屏");
		up.openApp();
	}

	/**
	 * 测试名称：08 研报列表可以上下滑屏
	 * [测试步骤]：
	 * 路径：底部的行情-更多-沪深A股-任一股票-研报
	 * 1、点击任意品种进入品种分析页；
	 * 2、切换至研报列表；
	 * 3、上下滑动屏幕；
	 * 
	 * [预期结果]：
	 * 1、查看被隐藏的列表；
	 */
	@Test
	public void testSwipeYanBao() {

		up.goHomePage();

		up.goToStock();

		up.clickOn("搜索");
		up.clickOn("搜索框");
		up.clickOn("0");

		up.verifyIsShown("名称");
		up.clickOn("名称");
		up.clickOn("操作提示");

		up.swipeUpToElement("研报");
		up.verifyIsShown("研报");
		up.clickOn("研报");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
