package testcase.UP_China.Android.P1.ZhiShuLieBiao;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_14_goToSearchPage {

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
	 * 测试名称：从指数列表进入搜索界面
	 * 测试步骤:
	 * 1、点击指数标题栏右侧的搜索图标
	 * 期望结果：
	 * 1、进入品种搜索界面
	 */
	@Test
	public void testGoToSearchPage() {

		up.log("开始测试：从指数列表进入搜索界面");
		up.goHomePage();

		up.verifyIsShown("跳转行情");
		up.clickOn("跳转行情");

		up.verifyIsShown("更多");
		up.clickOn("更多");

		up.verifyIsShown("指数");
		up.clickOn("指数");

		up.clickOn("操作提示");
		up.verifyIsShown("标题");
		up.verifyIsShown("搜索");
		up.verifyIsShown("返回行情");
		up.verifyIsShown("名称(代码)");
		up.verifyIsShown("现价");
		up.verifyIsShown("涨幅");

		up.clickOn("搜索");
		up.verifyIsShown("隐藏");
		up.verifyIsShown("清空");
		up.verifyIsShown("返回");
	}
}
