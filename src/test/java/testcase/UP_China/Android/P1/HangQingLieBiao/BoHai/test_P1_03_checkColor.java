package testcase.UP_China.Android.P1.HangQingLieBiao.BoHai;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

@Test(groups="in process")
public class test_P1_03_checkColor {

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
	 * 测试名称：渤海商品综合屏顶部三个品种字段颜色
	 * 测试步骤:
	 * 1、渤海商品综合屏顶部三个品种字段的颜色
	 * 期望结果：
	 * 1、名称颜色黑色，现价，涨跌，涨幅颜色遵守红涨绿跌灰平
	 */
	@Test
	public void testDataRefresh() {

		up.log("开始测试：渤海商品综合屏顶部三个品种字段颜色");
		up.goHomePage();

	}
}
