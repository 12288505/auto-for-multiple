package testcase.UP_China.Android.P1.GuPiaoZongHePing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_11_dropDisplay {

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
	 * 测试名称：股票综合屏跌幅榜列表字段展示
	 * 测试步骤:
	 * 1、查看跌幅榜列表所展示的字段
	 * 期望结果：
	 * 1、每行数据均展示：股票名称，股票代码，现价，涨幅
	 */
	@Test
	public void testDefaultSort() {

		up.log("开始测试：股票综合屏跌幅榜列表字段展示");
		up.goHomePage();
		up.clickOn("跳转行情");
		up.verifyIsShown("上证指数");
		up.swipeUpToElement("跌股1");

		up.verifyIsShown("跌股1");
		up.verifyIsShown("跌股1现价");
		up.verifyIsShown("跌股1跌幅");

		up.verifyIsShown("跌股2");
		up.verifyIsShown("跌股2现价");
		up.verifyIsShown("跌股2跌幅");
	}
}
