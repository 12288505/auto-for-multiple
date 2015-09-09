package testcase.UP_Metal.Android.P1.Wode.ZhaoHuiMiMa;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UPMetal_Android;

public class test_P1_01_morenpaixu {

	private UPMetal_Android up;

	@BeforeClass
	public void setUP() {

		up = new UPMetal_Android();
		up.log("开始测试：填写资料-未绑定手机帐号");
		up.openApp();
	}

	/**
	 * 测试名称：01 填写资料-未绑定手机帐号
	 * [前提条件]：用户未登录状态
	 * [测试步骤]：
	 * 1、我的－点击登录－忘记密码，输入未绑定过手机号的帐号，点【下一步】
	 * 2、在填写资料界面输入一个已存在的手机号，点【获取验证码】
	 * [预期结果]：
	 * 1、获取失败，弹出该帐号未绑定过手机号之类的提示语
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
