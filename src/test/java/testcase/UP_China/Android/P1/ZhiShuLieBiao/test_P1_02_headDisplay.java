package testcase.UP_China.Android.P1.ZhiShuLieBiao;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_02_headDisplay {

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
	 * 测试名称：指数行情列表表头字段展示
	 * 测试步骤:
	 * 1、查看指数行情列表表头
	 * 期望结果：
	 * 1、表头字段显示:名称、现价，涨幅
	 */
	@Test
	public void testHeadDisplay() {

		up.log("开始测试：指数行情列表表头字段展示");
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
	}
}
