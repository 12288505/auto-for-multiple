package testcase.UP_China.Android.P2.bohaijiaoyi.weituo.weituoxuanze.weituoshuliang;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_03_kedingmaishuliangxiao {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：可订买可订卖数量变小-价格加");
		up.openApp();

	}

	/**
	 * 测试名称：03 可订买可订卖数量变小-价格加
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、多次点击价格编辑框右侧的加号；
	 * 2、查看可订买可订卖数据变化；
	 * [预期结果]：
	 * 1、可订买和可订卖的值变为一致；
	 * 2、可订买和可订卖的数值统一变小；
	 */
	@Test
	public void testKedingmaishuliangxiao() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
