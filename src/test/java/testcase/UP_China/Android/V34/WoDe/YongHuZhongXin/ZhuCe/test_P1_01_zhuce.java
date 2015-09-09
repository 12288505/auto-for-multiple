package testcase.UP_China.Android.V34.WoDe.YongHuZhongXin.ZhuCe;

import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_01_zhuce {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：有手机号码快捷注册成功");
		up.openApp();
	}

	/**
	 * 测试名称：01 有手机号码快捷注册成功
	 * [测试步骤]：
	 * 1、未登录状态下，进入【我的】->【点击登陆】
	 * 2、点击登录按钮下：没账号？去注册>>链接
	 * 3、在快捷注册页面用户名栏，输入未被注册过的用户名
	 * 4、在密码及确认密码栏，输入相同密码
	 * 5、在手机号码栏，输入正确的手机号，点击提交按钮
	 * 6、在弹出框，点击确定按钮
	 * 
	 * 
	 * [预期结果]：
	 * 1、步骤五后，弹出提示框：恭喜您 注册成功；
	 * 2、步骤六后，页面跳转到我的页面，用户中心显示新注册的用户名
	 */
	@Test
	public void testZhuce() {

		up.goHomePage();
		up.verifyIsShown("跳转我的");
		up.clickOn("跳转我的");
		up.clickOn("登录导航");
		up.verifyIsShown("点击登录");
		up.clickOn("点击登录");
		up.clickOn("注册");
		
		String nametime = Long.toString(new Date().getTime());
		
		up.setValueTo("用户名", nametime);
		up.setValueTo("密码",up.getWeiXinPassword());
		up.setValueTo("确认密码", up.getWeiXinPassword());
		up.setValueTo("手机号码", up.getWeiXinAccount());
		up.closeKeyWord();
		up.waitByTimeout(3000);
		up.clickOn("提交");
		up.clickOn("确定");

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
