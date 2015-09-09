package testcase.UP_China.Android.P1.GuPiaoZongHePing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

@Test(groups="in process")
public class test_P1_03_dataColor {

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
	 * 测试名称：股票综合屏指数字段颜色
	 * 测试步骤:
	 * 1、查看指数区域所字段的颜色
	 * 期望结果：
	 * 1、指数名称颜色黑色，现价，涨跌，涨幅颜色遵守红涨绿跌灰平
	 */
	@Test
	public void testDataColor() {

		up.goHomePage();
		up.log("开始测试：股票综合屏指数字段颜色");

	}
}
