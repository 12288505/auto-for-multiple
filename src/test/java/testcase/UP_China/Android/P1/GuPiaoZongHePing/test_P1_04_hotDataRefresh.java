package testcase.UP_China.Android.P1.GuPiaoZongHePing;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_04_hotDataRefresh {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：股票综合屏热门板块数据刷新");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：股票综合屏热门板块数据刷新
	 * 测试步骤:
	 * 1、查看热门板块数据刷新频率
	 * 期望结果：
	 * 1、热门板块数据刷新频率与所设置的行情刷新频率一致
	 */
	@Test(dependsOnGroups = "stock time")
	public void testHotDataRefresh() {

		up.goHomePage();
		up.verifyIsShown("跳转行情");
		up.clickOn("跳转行情");

		up.verifyIsShown("行情");
		String result1 = up.getValueOf("热门1涨幅");
		String result2 = up.getValueOf("热门2涨幅");
		String result3 = up.getValueOf("热门3涨幅");
		String result4 = up.getValueOf("热门4涨幅");
		String result5 = up.getValueOf("热门5涨幅");
		String result6 = up.getValueOf("热门6涨幅");
		up.waitByTimeout(6000);
		boolean validate = (result1.equals(up.getValueOf("热门1涨幅")) && result2.equals(up.getValueOf("热门2涨幅"))
				&& result3.equals(up.getValueOf("热门3涨幅")) && result4.equals(up.getValueOf("热门4涨幅"))
				&& result5.equals(up.getValueOf("热门5涨幅")) && result6.equals(up.getValueOf("热门6涨幅")));
		if (validate)
			up.log("股票综合屏指数在5秒内没有刷新！");
		Assert.assertFalse(validate);
	}
}
