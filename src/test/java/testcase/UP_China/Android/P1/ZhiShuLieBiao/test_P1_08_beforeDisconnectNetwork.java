package testcase.UP_China.Android.P1.ZhiShuLieBiao;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_08_beforeDisconnectNetwork {

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
	 * 测试名称：进入指数行情列表后断网
	 * 测试步骤:
	 * 1、进入指数行情列表
	 * 2、断网
	 * 期望结果：
	 * 1、数据和界面依然保持为断网前的数据
	 * 2、顶部中国移动处提示：无法连接服务器
	 */
	@Test
	public void testBeforeDisconnectNetwork() {

		up.log("开始测试：进入指数行情列表后断网");
		up.goHomePage();

		up.verifyIsShown("跳转行情");
		up.clickOn("跳转行情");

		up.verifyIsShown("更多");
		up.clickOn("更多");

		up.verifyIsShown("指数");
		up.clickOn("指数");
		up.clickOn("操作提示");

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

		up.disconnectWifi();

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

		up.connectWifi();

	}
}
