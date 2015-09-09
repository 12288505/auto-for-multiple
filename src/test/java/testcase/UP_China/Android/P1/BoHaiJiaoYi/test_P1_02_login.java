package testcase.UP_China.Android.P1.BoHaiJiaoYi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_02_login {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：首页入口-未登录");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：首页入口-未登录
	 * [前提条件]：
	 * 1.未登录渤海交易
	 * [测试步骤]：
	 * 1、点击首页顶部导航区域渤海交易图标
	 * [预期结果]：
	 * 1、进入渤海交易登录界面
	 */
	@Test
	public void testLogin() {

		up.goHomePage();

		up.verifyIsShown("自选");
		up.verifyIsShown("沪深股票");
		up.verifyIsShown("渤海商品");

		up.goToHeader("渤海交易");

		up.verifyIsShown("帐号");
		up.verifyIsShown("密码");
		up.verifyIsShown("登录主站");
		up.verifyIsShown("记住帐号");
		up.verifyIsShown("登录");
	}
}
