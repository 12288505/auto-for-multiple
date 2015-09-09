package testcase.UP_China.Android.P1.ZhiShuLieBiao;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_13_returnPreviousPage {

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
	 * 测试名称：从指数列表返回前一页面
	 * 测试步骤:
	 * 1、点击标题栏左侧的返回图标
	 * 期望结果：
	 * 1、返回到进入指数行情列表的上一个页面
	 */
	@Test
	public void testReturnPreviousPage() {

		up.log("开始测试：从指数列表返回前一页面");
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

		up.verifyIsShown("指数名称1");
		up.verifyIsShown("指数代码1");
		up.verifyIsShown("现价1");
		up.verifyIsShown("涨幅1");

		up.clickOn("返回");

		up.verifyIsShown("股票");
		up.verifyIsShown("指数");
		up.verifyIsShown("板块");

	}
}
