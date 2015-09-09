package testcase.UP_China.Android.P1.Wode.SanFangDengLu;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_03_weibodenglu {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：微博已安装已登录第一次绑定登录");
		up.openApp();
	}

	/**
	 * 测试名称：01 微博已安装已登录第一次绑定登录
	 * [前提条件]：
	 * 1、用来三方登陆的微博号未绑定任何up账号
	 * 2、本地已安装微博且已登录
	 * [测试步骤]：
	 * 1、进入【我的】->【点击登陆】
	 * 2、点击微博图标
	 * 3、在填写资料界面填入手机号
	 * 4、在填写资料界面点击完成
	 * 5、点击我的界面第一栏（用户昵称那栏）
	 * 6、查看个人信息
	 * 7、在个人信息界面点击第三方账号绑定
	 * 8、查看第三方账号绑定信息
	 * [预期结果]：
	 * 1、step2执行完：界面跳转到微博登陆授权界面并自动登陆跳转到填写资料界面
	 * 3、step4执行完：界面跳转到我的界面，我的第一栏展示微博头像和微博昵称，下方小文字提示更换头像、修改昵称和密码
	 * 4、step5执行完：进入个人信息栏
	 * 5、step6执行完：个人信息头像显示微博头像，昵称为微博昵称，第三方账号显示已绑定
	 * 6、step8执行完：进入账号绑定界面
	 * 7、step9执行完：账号绑定界面手机新浪微博栏展示三方绑定微博号的昵称，新浪微博和QQ栏展示空白；
	 */
	@Test
	public void testWeibodenglu() {

		up.goHomePage();
		up.verifyIsShown("跳转我的");
		up.clickOn("跳转我的");
		up.clickOn("登录导航");
		up.clickOn("点击登录");
		up.clickOn("微博");
		
		up.waitByTimeout(3000);
		up.setValueTo("微博帐号", up.getWeiboAccount());
		up.setValueTo("微博密码", up.getWeiboPassword());
		up.clickOn("登录");
		up.setValueTo("手机号", up.getWeiXinAccount());
		up.clickOn("完成");
		
		up.verifyIsShown("点击登录");
		up.clickOn("点击登录");
		up.waitByTimeout(3000);
		up.verifyIsShown("头像");
		up.verifyIsShown("昵称");
		up.verifyIsShown("第三方帐号绑定");
		
		up.clickOn("第三方帐号绑定");
		up.log(up.getValueOf("微博昵称"));
		
		up.clickOn("微博昵称");
		up.clickOn("是");
		up.clickOn("返回");
		up.clickOn("退出登录");
		up.clickOn("是");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
