package testcase.UP_China.Android.P1.ZhiShuLieBiao;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_07_afterDisconnectNetwork {

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
	 * 测试名称： 断网后进入指数行情列表
	 * 测试步骤:
	 * 1、断开网络
	 * 2、进入指数行情列表
	 * 期望结果：
	 * 1、界面正文部分仅显示表头：名称，现价，涨幅三个字段
	 */
	@Test
	public void testAfterDisconnectNetwork() {

		up.log("开始测试:断网后进入指数行情列表");
		up.goHomePage();

		up.verifyIsShown("跳转行情");
		up.clickOn("跳转行情");

		up.verifyIsShown("更多");
		up.clickOn("更多");

		up.verifyIsShown("指数");
		up.disconnectWifi();
		up.clickOn("指数");
		up.clickOn("操作提示");

		up.verifyIsShown("名称(代码)");
		up.verifyIsShown("现价");
		up.verifyIsShown("涨幅");
		up.connectWifi();

	}
}
