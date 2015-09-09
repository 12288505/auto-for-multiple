package testcase.UP_China.Android.P2.bohaijiaoyi.weituo.hangqingbaojia;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_01_hangqingbaojiazhanshi {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：行情报价数据初始展示");
		up.openApp();

	}

	/**
	 * 测试名称：01 行情报价数据初始展示
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、查看搜索栏下方的行情报价区域
	 * [预期结果]：
	 * 1、行情报价区域分两栏，左侧显示现价，涨幅和涨跌，右侧显示买入卖出数量一档行情；
	 * 2、行情报价区域底色遵守红涨绿跌灰平规则；
	 * 3、现价，涨幅，涨跌，买入价格，卖出价格的价格精度和最小变价单位一致；
	 * 4、现价、涨幅、涨跌、买入价格、卖出价格、买入数量、卖出数量的数值与PC端一致；
	 * 5、现价、涨幅、涨跌、买入价格、卖出价格无数据时--显示
	 * 6、买入卖出一档行情，第一档显示卖出档，第二档显示买入档；
	 */
	@Test
	public void testHangqingbaojiazhanshi() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
