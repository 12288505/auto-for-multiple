package testcase.UP_China.Android.P2.bohaijiaoyi.denglu;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_03_dengluchenggong {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：登录成功进入委托界面");
		up.openApp();

	}

	/**
	 * 测试名称：02 登录成功进入委托界面
	 * [前提条件]：
	 * 1.成功进入交易所承诺界面
	 * [测试步骤]：
	 * 1、点击交易所承诺下方确定按钮
	 * 2、
	 * [预期结果]：
	 * 1、登录成功进入委托界面
	 */
	@Test
	public void testDengluchenggong() {

		up.goHomePage();
		up.verifyIsShown("自选");
		up.goToHeader("渤海交易");
		up.login_BH();
		up.verifyIsShown("标题");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
