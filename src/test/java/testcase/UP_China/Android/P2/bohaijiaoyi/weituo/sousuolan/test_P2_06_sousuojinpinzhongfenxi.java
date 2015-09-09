package testcase.UP_China.Android.P2.bohaijiaoyi.weituo.sousuolan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_06_sousuojinpinzhongfenxi {

	private UP_Android up;

	@BeforeClass
	public void setUP() {

		up = new UP_Android();
		up.log("开始测试：从搜索结果进入品种分析页");
		up.openApp();

	}

	/**
	 * 测试名称:06 从搜索结果进入品种分析页
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、点击搜索结果中的某一条
	 * 2、
	 * [预期结果]：
	 * 1、界面跳转到委托界面；
	 * 2、搜索栏显示品种为搜索结果中点击选中的品种；
	 * 3、委托界面行情报价区域显示该品种的行情数据；
	 * 4、涨停跌停价格变为该品种的涨停跌停价格；
	 * 5、可订买和可订卖数量变为该品种的可订买数量，可订卖数量
	 * 6、买入按钮显示该品种的卖档价格；
	 * 7、卖出按钮显示该品种的买档价格；
	 */
	@Test
	public void testSousuojinpinzhongfenxi() {

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
