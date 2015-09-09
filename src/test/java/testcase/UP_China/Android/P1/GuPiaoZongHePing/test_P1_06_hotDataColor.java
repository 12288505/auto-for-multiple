package testcase.UP_China.Android.P1.GuPiaoZongHePing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

@Test(groups="in process")
public class test_P1_06_hotDataColor {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.openApp();
		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：股票综合屏热门板块字段颜色
	 * 测试步骤:
	 * 1、查看热门板块字段的颜色
	 * 期望结果：
	 * 1、板块名称和领涨股名称颜色黑色显示，板块涨幅和领涨股涨幅颜色遵守红涨绿跌灰平
	 */
	@Test
	public void testDefaultSort() {

	}
}
