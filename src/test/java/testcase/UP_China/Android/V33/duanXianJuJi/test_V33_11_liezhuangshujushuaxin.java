package testcase.UP_China.Android.V33.duanXianJuJi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;


public class test_V33_11_liezhuangshujushuaxin {
	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：数据自动刷新");
		up.openApp();
	}

	/**
	 * 测试名称：11 数据自动刷新
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、进入【选股】->【股票池】->【猎庄狙击】
	 * 2、查看有庄操作界面数据刷新时间
	 * [预期结果]：
	 * 1、数据每隔15秒自动刷新
	 */
	@Test(dependsOnGroups = "stock time")
	public void testLiezhuangshujushuaxin() {

		up.goHomePage();
		up.verifyIsShown("选股");
		up.clickOn("选股");
		up.verifyIsShown("短线狙击");
		up.clickOn("短线狙击");
		up.verifyIsShown("猎庄狙击");
		up.clickOn("猎庄狙击");
		up.waitByTimeout(5000);
		if (up.isElementShown("暂无相关数据")) {
			up.log("短线狙击中有庄操盘无数据，测试正常退出.");
		} else {
			Double temp = 50.0;
			double price = 0;
			double newPrice = 0;
			for (int i = 0; i < up.getElementsSize("股票名称"); i++) {
				String value = up.getValueOf("股票当日涨幅1", i);
				if (value.contains("."))
					temp = Double.valueOf(value.split("%")[0]);
				if (temp < 9.9) {
					price = temp;
					up.log("等待15秒");
					up.waitByTimeout(16000);

					newPrice = Double.valueOf(up.getValueOf("股票当日涨幅1", i).split("%")[0]);
					if (price == newPrice)
						throw new RuntimeException("蓄能界面数据在15秒后没有自动刷新.");
				}
			}
		}
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
