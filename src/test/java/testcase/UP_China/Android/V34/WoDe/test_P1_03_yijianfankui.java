package testcase.UP_China.Android.V34.WoDe;

import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_03_yijianfankui {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：提交意见反馈");
		up.openApp();
	}

	/**
	 * 测试名称：03 提交意见反馈
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、进入意见反馈界面
	 * 2、在意见反馈编辑框输入5-500个字
	 * 3、添加一张图片
	 * 4、输入手机号/邮箱/QQ
	 * 5、点击提交
	 * [预期结果]：
	 * 1、提示：提交成功，我们会尽快处理您的反馈，谢谢！
	 * 2、界面自动返回到我的界面
	 */
	@Test
	public void testYijianfankui() {

		up.goHomePage();

		up.verifyIsShown("跳转我的");
		up.clickOn("跳转我的");
		
		up.clickOn("登录导航");
		up.verifyIsShown("意见反馈");
		up.clickOn("意见反馈");
		
		String nametime = Long.toString(new Date().getTime());
		up.setValueTo("意见内容", nametime+nametime);
//		up.clickOn("图片");
//		up.verifyIsShown("标题");
//		
//		up.picture();
		
		up.setValueTo("联系方式", up.getWeiXinAccount());
		
		up.back();
		up.clickOn("提交");
		up.clickOn("是");
		
//		up.clickOn("返回");
		up.verifyIsShown("我的标题");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
