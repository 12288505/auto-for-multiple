package testcase.UP_China.Android.P1.GuPiaoZongHePing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_08_riseDisplay {

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
	 * 测试名称：股票综合屏涨幅榜列表字段展示
	 * 测试步骤:
	 * 1、查看涨幅榜列表所展示的字段
	 * 期望结果：
	 * 1、每行数据均展示：股票名称，股票代码，现价，涨幅
	 */
	@Test
	public void testDefaultSort() {

		up.log("开始测试：股票综合屏涨幅榜列表字段展示");
		up.goHomePage();
		up.clickOn("跳转行情");
		up.waitByTimeout(1000);
		up.swipe("up");

		up.verifyIsShown("涨股1");
		up.verifyIsShown("涨股1现价");
		up.verifyIsShown("涨股1涨幅");

		up.verifyIsShown("涨股2");
		up.verifyIsShown("涨股2现价");
		up.verifyIsShown("涨股2涨幅");

		up.verifyIsShown("涨股3");
		up.verifyIsShown("涨股3现价");
		up.verifyIsShown("涨股3涨幅");

	}
}
