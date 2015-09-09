package testcase.UP_China.Android.P1.GuPiaoZongHePing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_05_hotDataDisplay {

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
	 * 测试名称：股票综合屏热门板块字段展示
	 * 测试步骤:
	 * 1、查看热门板块所展示的字段
	 * 期望结果：
	 * 1、每个指数分别显示：板块名称，板块涨幅，领涨股，领涨股涨幅
	 */
	@Test
	public void testHotDataDisplay() {

		up.log("开始测试：股票综合屏热门板块数据刷新");
		up.goHomePage();
		up.verifyIsShown("跳转行情");
		up.clickOn("跳转行情");
		up.verifyIsShown("行情");

		up.verifyIsShown("热门1名称");
		up.verifyIsShown("热门1涨幅");
		up.verifyIsShown("领涨1");
		up.verifyIsShown("领涨幅1");

		up.verifyIsShown("热门2名称");
		up.verifyIsShown("热门2涨幅");
		up.verifyIsShown("领涨2");
		up.verifyIsShown("领涨幅2");

		up.verifyIsShown("热门3名称");
		up.verifyIsShown("热门3涨幅");
		up.verifyIsShown("领涨3");
		up.verifyIsShown("领涨幅3");

		up.verifyIsShown("热门4名称");
		up.verifyIsShown("热门4涨幅");
		up.verifyIsShown("领涨4");
		up.verifyIsShown("领涨幅4");

		up.verifyIsShown("热门5名称");
		up.verifyIsShown("热门5涨幅");
		up.verifyIsShown("领涨5");
		up.verifyIsShown("领涨幅5");

		up.verifyIsShown("热门6名称");
		up.verifyIsShown("热门6涨幅");
		up.verifyIsShown("领涨6");
		up.verifyIsShown("领涨幅6");

	}
}
