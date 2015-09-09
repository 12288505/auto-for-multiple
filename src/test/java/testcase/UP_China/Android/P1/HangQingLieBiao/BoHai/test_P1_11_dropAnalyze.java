package testcase.UP_China.Android.P1.HangQingLieBiao.BoHai;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_11_dropAnalyze {

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
	 * 测试名称：从渤海商品综合屏跌幅榜进入商品品种分析页
	 * 测试步骤:
	 * 1、点击跌幅榜列表任一只品种
	 * 期望结果：
	 * 1、进入所点击商品所在品种分析页
	 */
	@Test
	public void testDataRefresh() {

		up.log("开始测试：从渤海商品综合屏跌幅榜进入商品品种分析页");
		up.goHomePage();

		up.verifyIsShown("渤海商品");
		up.clickOn("渤海商品");

		up.verifyIsShown("渤海1");
		up.swipeUpToElement("跌幅榜");
		up.clickOn("跌幅1名称");

		up.clickOn("操作提示");
		up.verifyIsShown("标题");
		up.verifyIsShown("代码");
		up.verifyIsShown("返回");

	}
}
