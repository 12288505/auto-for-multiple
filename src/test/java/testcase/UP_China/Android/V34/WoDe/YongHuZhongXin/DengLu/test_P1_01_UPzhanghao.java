package testcase.UP_China.Android.V34.WoDe.YongHuZhongXin.DengLu;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_01_UPzhanghao {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：输入正确用户名密码登录成功");
		up.openApp();
	}

	/**
	 * 测试名称：01 输入正确用户名密码登录成功
	 * [测试步骤]：
	 * 1、未登录状态下，进入【我的】->【点击登陆】
	 * 2、输入正确的用户名及密码
	 * 3、点击登录按钮
	 * 
	 * 
	 * [预期结果]：
	 * 1、页面跳转到我的页面
	 * 2、用户中心显示登录的用户名，如该用户有头像，头像正确显示
	 */
	@Test
	public void testUpzhanghao() {

		up.goHomePage();
		up.login();
		up.verifyIsShown("头像");

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
