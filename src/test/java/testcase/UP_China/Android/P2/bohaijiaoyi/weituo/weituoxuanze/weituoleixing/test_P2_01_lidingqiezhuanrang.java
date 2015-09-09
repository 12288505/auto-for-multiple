package testcase.UP_China.Android.P2.bohaijiaoyi.weituo.weituoxuanze.weituoleixing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_01_lidingqiezhuanrang {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：切换委托类型-订立切转让");
		up.openApp();

	}

	/**
	 * 测试名称：01 切换委托类型-订立切转让
	 * [前提条件]：
	 * 1、当前委托类型为订立
	 * [测试步骤]：
	 * 1、点击委托类型标签按钮转让
	 * [预期结果]：
	 * 1、委托类型切换为转让
	 * 2、委托数量下方的文字由可订买，可订卖转换为买可转，卖可转；
	 * 3、买可转的数值对应持仓中相应品种买入订立仓单的数量；
	 * 4、卖可转的数值对应持仓中相应品种卖出订立仓单的数量；
	 */
	@Test
	public void testLidingqiezhuanrang() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
