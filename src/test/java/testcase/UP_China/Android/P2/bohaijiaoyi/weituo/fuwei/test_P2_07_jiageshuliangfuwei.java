package testcase.UP_China.Android.P2.bohaijiaoyi.weituo.fuwei;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_07_jiageshuliangfuwei {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：价格数量复位");
		up.openApp();

	}

	/**
	 * 测试名称：07 价格数量复位
	 * [前提条件]：
	 * 1、委托类型为默认类型
	 * [测试步骤]：
	 * 1、在价格编辑框输入位于涨停跌停价之间的任意数值；
	 * 2、在数量编辑框输入任意数值；
	 * 3、点击复位按钮
	 * [预期结果]：
	 * 1、step1执行完：价格编辑框的数值变为所输入的数值，下方买入按钮和卖出按钮上显示的价格和编辑框中一致；
	 * 2、step2执行完：数量编辑框的数值变为所输入的数值；
	 * 3、step3执行完：数量编辑框数值恢复为1，价格编辑框的值重新变为文字对手价，下方买入按钮和卖出按钮上显示的价格分别为行情卖档价格和买档价格；
	 */
	@Test
	public void testJiageshuliangfuwei() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
