package testcase.UP_China.Android.P2.bohaijiaoyi.weituo.hangqingbaojia;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_02_hangqingbaojiashuaxin {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：行情报价数据刷新-10秒刷新");
		up.openApp();

	}

	/**
	 * 测试名称：02 行情报价数据刷新-10秒刷新
	 * [前提条件]：
	 * 1、行情数据本身在10秒内有变化
	 * [测试步骤]：
	 * 1、查看行情报价区域超过20秒
	 * 
	 * [预期结果]：
	 * 1、行情报价数据每10秒刷新一次；
	 */
	@Test
	public void testHangqingbaojiashuaxin() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
