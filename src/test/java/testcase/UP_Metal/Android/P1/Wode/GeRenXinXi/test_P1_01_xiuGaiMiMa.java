package testcase.UP_Metal.Android.P1.Wode.GeRenXinXi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UPMetal_Android;

public class test_P1_01_xiuGaiMiMa {

	private UPMetal_Android up;

	@BeforeClass
	public void setUP() {

		up = new UPMetal_Android();
		up.log("开始测试：修改密码成功");
		up.openApp();
	}

	/**
	 * 测试名称：01 修改密码成功
	 * [测试步骤]：
	 * 1、登录状态下，首页下部点击【我的】
	 * 2、点击用户中心进入个人信息页面
	 * 3、点击修改密码行，进入修改密码页面
	 * 4、输入正确旧密码，新密码及确认新密码，点击确定按钮
	 * 
	 * [预期结果]：
	 * 1、弹出提示：修改密码成功，请重新登陆
	 * 2、在提示信息窗口，点击确定按钮进入登陆页面
	 * 3、输入新密码登陆成功，进入个人信息页面
	 */
	@Test
	public void testXiuGaiMiMa() {

		up.goHomePage();
		up.verifyIsShown("跳转我的");
		up.clickOn("跳转我的");
		up.clickOn("操作提示");
		up.verifyIsShown("点击登录");
		up.clickOn("点击登录");
		
		up.Thelogin();
		
		up.waitByTimeout(3000);
		up.verifyIsShown("点击登录");
		up.clickOn("点击登录");
		up.verifyIsShown("修改密码");
		up.clickOn("修改密码");
		
		up.setValueTo("旧密码",up.UPpassword);
		up.setValueTo("新密码",up.UPnewpassword);
		up.setValueTo("确认新密码",up.UPnewpassword);
		up.clickOn("保存修改");
		
//		up.verifyIsShown("密码");
//		up.setValueTo("密码", up.UPnewpassword);
//		up.clickOn("登录");
//		
//		up.verifyIsShown("修改密码");
//		up.clickOn("修改密码");
//		up.setValueTo("旧密码",up.UPnewpassword);
//		up.setValueTo("新密码",up.UPpassword);
//		up.setValueTo("确认新密码",up.UPpassword);
//		up.clickOn("保存修改");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
