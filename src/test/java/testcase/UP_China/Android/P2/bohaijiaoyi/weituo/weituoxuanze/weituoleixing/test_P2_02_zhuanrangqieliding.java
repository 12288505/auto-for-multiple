package testcase.UP_China.Android.P2.bohaijiaoyi.weituo.weituoxuanze.weituoleixing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_02_zhuanrangqieliding {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：切换委托类型-转让切订立");
		up.openApp();

	}

	/**
	 * 测试名称：04 切换委托类型-转让切订立
	 * [前提条件]：
	 * 1、当前委托类型为转让
	 * [测试步骤]：
	 * 1、点击委托类型标签订立
	 * 2、
	 * [预期结果]：
	 * 1、委托类型切换为订立
	 * 2、委托数量下方的文字买可转，买可转变为可订买，可订卖；
	 * 3、可订买，可订卖的数值和官方软件一致；
	 */
	@Test
	public void testZhuanrangqieliding() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
