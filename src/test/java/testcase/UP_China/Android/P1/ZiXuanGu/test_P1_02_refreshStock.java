package testcase.UP_China.Android.P1.ZiXuanGu;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_02_refreshStock {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.openApp();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：下拉列表刷新自选股
	 * 测试步骤:
	 * 1、进入自选股票界面；
	 * 2、下拉刷新列表；
	 * 期望结果：
	 * 1、显示最新自选股票列表行情；
	 * 重要提示：
	 * 刷新过程中加载元素消失很快，很难捕捉到，故暂时无法设置检查点
	 */

	@Test
	public void testRefreshStock() {

		up.log("开始测试：下拉列表刷新自选股");
		up.goHomePage();
		up.verifyIsShown("跳转自选");
		up.clickOn("跳转自选");

		up.clickOn("自选提示");
		up.clickOn("搜索");
		up.clickOn("0");
		up.verifyIsShown("加自选");
		up.clickOn("加自选");
		up.verifyIsShown("已添加");
		up.clickOn("返回");

		up.verifyIsShown("全部自选");
		up.swipe(5, 3, 5, 8, 2000);
	}
}
