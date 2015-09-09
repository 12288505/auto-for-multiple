package testcase.UP_China.Android.P1.BoHaiJiaoYi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_01_loginPage {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：登录成功进入交易所承诺");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：登录成功进入交易所承诺
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、输入正确的账号
	 * 2、输入正确的密码
	 * 3、选择正确的主站
	 * [预期结果]：
	 * 1、弹出交易所承诺
	 */
	@Test
	public void testLoginPage() {

		up.goHomePage();

		up.verifyIsShown("自选");
		up.verifyIsShown("沪深股票");
		up.verifyIsShown("渤海商品");

		up.goToHeader("渤海交易");

		up.login_BH();
	}
}
