package testcase.UP_China.Android.P1.ZhiShuLieBiao;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_12_manualRefreshAfterDisconnect {

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
	 * 测试名称：恢复网络手动刷新指数列表数据
	 * 测试步骤:
	 * 前提条件：进入行情列表后断网
	 * 1、恢复网络
	 * 2、下拉刷新行情列表查看列表数据变化；
	 * 期望结果：
	 * 1、下拉刷新完成后，列表恢复数据；
	 */
	@Test
	public void testManualRefreshAfterDisconnect() {

		up.log("开始测试：恢复网络手动刷新指数列表数据");
		up.goHomePage();

		up.verifyIsShown("跳转行情");
		up.clickOn("跳转行情");

		up.verifyIsShown("更多");
		up.clickOn("更多");

		up.disconnectWifi();
		up.verifyIsShown("指数");
		up.clickOn("指数");
		up.clickOn("操作提示");

		up.connectWifi();
		up.swipe(5, 2, 5, 9, 5000);

		up.verifyIsShown("名称(代码)");
		up.verifyIsShown("现价");
		up.verifyIsShown("涨幅");

		up.verifyIsShown("指数名称1");
		up.verifyIsShown("指数代码1");
		up.verifyIsShown("现价1");
		up.verifyIsShown("涨幅1");

		up.verifyIsShown("指数名称2");
		up.verifyIsShown("指数代码2");
		up.verifyIsShown("现价2");
		up.verifyIsShown("涨幅2");

		up.verifyIsShown("指数名称3");
		up.verifyIsShown("指数代码3");
		up.verifyIsShown("现价3");
		up.verifyIsShown("涨幅3");
	}
}
