package testcase.UP_China.Android.P2.bohaijiaoyi.weituo.fuwei;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_01_weituoleixingzhuanrang {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：委托类型复位-转让");
		up.openApp();

	}

	/**
	 * 测试名称：01 委托类型复位-转让
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、点击委托类型为转让
	 * 2、点击复位按钮
	 * [预期结果]：
	 * 1、委托类型复位为订立
	 */
	@Test
	public void testWeituoleixingzhuanrang() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
