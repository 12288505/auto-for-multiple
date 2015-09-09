package testcase.UP_China.Android.P2.bohaijiaoyi.weituo.weituoxuanze.weituojiage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_02_weituojiagejian {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：委托价格-减");
		up.openApp();

	}

	/**
	 * 测试名称：02 委托价格-减
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、点击价格编辑框左侧的减号按钮
	 * [预期结果]：
	 * 1、编辑框的价格在行情报价区域的卖一价的基础上减去最小变价单位；
	 * 2、买入按钮和卖处按钮的价格均变为价格编辑框的价格；
	 */
	@Test
	public void testWeituojiagejian() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
