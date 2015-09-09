package testcase.UP_China.Android.P1.GuPiaoZongHePing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

@Test(groups="in process")
public class test_P1_09_riseColor {

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
	 * 测试名称：股票综合屏涨幅榜列表字段颜色
	 * 测试步骤:
	 * 1、查看涨幅榜列表字段的颜色
	 * 期望结果：
	 * 1、涨幅榜列表股票名称黑色，股票代码灰色，现价和涨幅遵守红涨绿跌灰平
	 */
	@Test
	public void testDefaultSort() {

	}
}
