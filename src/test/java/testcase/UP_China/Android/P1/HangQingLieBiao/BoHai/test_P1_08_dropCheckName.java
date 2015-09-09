package testcase.UP_China.Android.P1.HangQingLieBiao.BoHai;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_08_dropCheckName {

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
	 * 测试名称：渤海商品综合屏跌幅榜列表字段展示
	 * 测试步骤:
	 * 1、查看跌幅榜列表所展示的字段
	 * 期望结果：
	 * 1、每行数据均展示：品种名称，品种代码，现价，涨幅
	 */
	@Test
	public void testDataRefresh() {

		up.log("开始测试：渤海商品综合屏跌幅榜列表字段展示");
		up.goHomePage();

		up.verifyIsShown("渤海商品");
		up.clickOn("渤海商品");

		up.swipeUpToElement("跌幅1名称");
		up.verifyIsShown("跌幅1名称");
		up.verifyIsShown("跌幅1现价");
		up.verifyIsShown("跌幅1跌幅");
	}
}
