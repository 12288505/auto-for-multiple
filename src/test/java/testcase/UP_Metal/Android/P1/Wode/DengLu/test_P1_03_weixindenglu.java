package testcase.UP_Metal.Android.P1.Wode.DengLu;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UPMetal_Android;

public class test_P1_03_weixindenglu {

	private UPMetal_Android up;

	@BeforeClass
	public void setUP() {

		up = new UPMetal_Android();
		up.log("开始测试：微信已安装已登录第一次绑定登录----贵金属不存在三方登陆，不做记录");
		up.openApp();
	}

	/**
	 * 测试名称：02 微信已安装已登录第一次绑定登录
	 * [前提条件]：
	 * 1、用来三方登陆的微信号未绑定任何up账号
	 * 2、本地已安装微信且已登录
	 * [测试步骤]：
	 * 1、进入【我的】->【点击登陆】
	 * 2、点击微信图标
	 * 3、在授权页面点击确认登陆
	 * 4、在填写资料界面填入手机号
	 * 5、在填写资料界面点击完成
	 * 6、点击我的界面第一栏（用户昵称那栏）
	 * 7、查看个人信息
	 * 8、在个人信息界面点击第三方账号绑定
	 * 9、查看第三方账号绑定信息
	 * [预期结果]：
	 * 1、step2执行完：界面跳转到微信登陆授权界面
	 * 2、step3执行完：界面跳转到填写资料界面
	 * 3、step5执行完：界面跳转到我的界面，我的第一栏展示微信头像和微信昵称，下方小文字提示更换头像、修改昵称和密码
	 * 4、step6执行完：进入个人信息栏
	 * 5、step7执行完：个人信息头像显示微信用户头像，昵称为微信昵称，第三方账号显示已绑定
	 * 6、step8执行完：进入账号绑定界面
	 * 7、step9执行完：账号绑定界面微信栏展示三方绑定微信号的昵称，新浪微博和QQ栏展示空白；
	 */
	@Test
	public void testWeixindenglu() {

//		up.goHomePage();
//		up.verifyIsShown("跳转我的");
//		up.clickOn("跳转我的");
//		up.clickOn("操作提示");
//		up.verifyIsShown("点击登录");
//		up.clickOn("点击登录");

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
