package testcase.UP_China.Android.P1.GuPiaoZongHePing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_02_dataDisplay {

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
	 * 测试名称：股票综合屏指数字段展示
	 * 测试步骤:
	 * 1、查看指数区域所展示的字段
	 * 期望结果：
	 * 1、每个指数分别显示：指数名称，指数现价，涨跌，涨幅
	 */
	@Test
	public void testDataDisplay() {

		up.log("开始测试：股票综合屏指数字段展示");
		up.goHomePage();
		up.verifyIsShown("跳转行情");
		up.clickOn("跳转行情");

		up.verifyIsShown("上证指数");
		up.verifyIsShown("上证指数值");
		up.verifyIsShown("上证指数涨跌");
		up.verifyIsShown("上证指数涨幅");

		up.verifyIsShown("深证成指");
		up.verifyIsShown("深证成指值");
		up.verifyIsShown("深证成指涨跌");
		up.verifyIsShown("深证成指涨幅");

		up.verifyIsShown("沪深300");
		up.verifyIsShown("沪深300值");
		up.verifyIsShown("沪深300涨跌");
		up.verifyIsShown("沪深300涨幅");

	}
}
