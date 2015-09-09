package testcase.UP_China.Android.P2.bohaijiaoyi.denglu;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_02_denglujiemian {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：交易账号初始显示-记住账号");
		up.openApp();

	}

	/**
	 * 测试名称： 02 交易账号初始显示-记住账号
	 * [前提条件]：
	 * 1.上一次登录时记住账号选项选择ON；
	 * [测试步骤]：
	 * 1、进入渤海交易登录界面
	 * 2、查看交易账号编辑框
	 * 
	 * [预期结果]：
	 * 1、交易账号编辑框显示上一次登录账号；
	 * 2、账号中间五位数字用黑点掩码显示；
	 */
	@Test
	public void testDenglujiemian() {

		up.goHomePage();
		up.verifyIsShown("自选");
		up.goToHeader("渤海交易");
		up.login_BH();
		up.verifyIsShown("更多");
		up.clickOn("更多");
		up.verifyIsShown("退出交易");
		up.clickOn("退出交易");
		up.getValueOf("帐号");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
