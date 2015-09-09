package testcase.UP_Metal.Android.P1.Wode.ZhaoHuiMiMa;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UPMetal_Android;

public class test_P1_02_morenpaixu {

	private UPMetal_Android up;

	@BeforeClass
	public void setUP() {

		up = new UPMetal_Android();
		up.log("开始测试：填写资料-绑定过手机帐号-正确手机号");
		up.openApp();
	}

	/**
	 * 测试名称：02 填写资料-绑定过手机帐号-正确手机号
	 * [前提条件]：用户未登录状态
	 * [测试步骤]：
	 * 1、我的－点击登录－忘记密码，输入已绑定过手机号的帐号，点【下一步】
	 * 2、在填写资料界面输入该绑定该帐号的手机号，点【获取验证码】
	 * 3、等待６０Ｓ，继续点【获取验证码】
	 * [预期结果]：
	 * 2、【获取验证码】变为60ｓ倒计时提示，60ｓ过后显示【获取验证码】；手机能正常收到验证码
	 * 3、手机仍可正常收到验证码
	 */
	@Test
	public void testMorenpaixu() {

		up.goHomePage();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
