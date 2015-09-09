package testcase.UP_China.Android.P1.Wode;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_02_ModifyPassword {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：修改密码");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

/*	
 * 测试名称：修改登录密码成功
 * [测试步骤]：
 *  1、登录状态下，首页下部点击【我的】
 *	2、点击用户中心进入个人信息页面
 *	3、点击修改密码行，进入修改密码页面
 *	4、输入正确旧密码，新密码及确认新密码，点击确定按钮

 *	[预期结果]：
 *	1、弹出提示：修改密码成功，请重新登陆
 *	2、在提示信息窗口，点击确定按钮进入登陆页面
 *	3、输入新密码登陆成功，进入个人信息页面
 */
	@Test
	public void testModifyPassword() {

		up.goHomePage();
		up.login();
		up.ModifyPassword();
	}
}
