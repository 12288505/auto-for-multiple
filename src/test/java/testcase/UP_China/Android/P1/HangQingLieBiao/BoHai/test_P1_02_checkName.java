package testcase.UP_China.Android.P1.HangQingLieBiao.BoHai;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_02_checkName {

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
	 * 测试名称：渤海商品综合屏顶部三个品种字段展示
	 * 测试步骤:
	 * 1、查看渤海商品综合屏顶部三个品种展示的字段
	 * 期望结果：
	 * 1、每个品种分别显示：品种名称，现价，涨跌，涨幅
	 */
	@Test
	public void testDataRefresh() {

		up.log("开始测试：渤海商品综合屏顶部三个品种字段展示");
		up.goHomePage();

		up.verifyIsShown("渤海商品");
		up.clickOn("渤海商品");

		up.verifyIsShown("渤海1名称");
		up.verifyIsShown("渤海1现价");
		up.verifyIsShown("渤海1涨跌");
		up.verifyIsShown("渤海1涨幅");

		up.verifyIsShown("渤海2名称");
		up.verifyIsShown("渤海2现价");
		up.verifyIsShown("渤海2涨跌");
		up.verifyIsShown("渤海2涨幅");

		up.verifyIsShown("渤海3名称");
		up.verifyIsShown("渤海3现价");
		up.verifyIsShown("渤海3涨跌");
		up.verifyIsShown("渤海3涨幅");
	}
}
