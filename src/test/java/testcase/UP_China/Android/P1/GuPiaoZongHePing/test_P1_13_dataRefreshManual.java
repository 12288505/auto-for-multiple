package testcase.UP_China.Android.P1.GuPiaoZongHePing;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_13_dataRefreshManual {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：股票综合屏下拉刷新数据");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：股票综合屏下拉刷新数据
	 * 测试步骤:
	 * 1、在股票综合屏进行整体下拉操作
	 * 期望结果：
	 * 1、股票综合屏数据有刷新
	 */
	@Test(dependsOnGroups = "stock time")
	public void testDataRefreshManual() {

		up.goHomePage();
		up.verifyIsShown("跳转行情");
		up.clickOn("跳转行情");
		up.verifyIsShown("行情");
		String sh = up.getValueOf("上证指数值");
		String sz = up.getValueOf("深证成指值");
		String hs = up.getValueOf("沪深300值");
		up.swipeToText("上证指数");
		up.verifyIsNotShown("正在载入");

		boolean validate = (sh.equals(up.getValueOf("上证指数值")) && sz.equals(up.getValueOf("深证成指值")) && hs.equals(up
				.getValueOf("沪深300值")));
		if (validate)
			up.log("大盘指数没有刷新!");
		Assert.assertFalse(validate);
	}
}
