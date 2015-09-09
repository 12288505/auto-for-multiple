package testcase.UP_China.Android.P1.GaoShouGenZong.GaoShouBangDan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_04_loginPage {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：已登录状态跟踪高手");
		up.openApp();
	}

	/**
	 * 测试名称：04 已登录状态跟踪高手
	 * [前提条件]：
	 * 1、up账户已登录
	 * [测试步骤]：
	 * 1、进入【首页】->【股林高手】->【高手榜单】->【日收益榜】
	 * 2、点击跟踪
	 * 3、点击标题栏我的跟踪
	 * 4、查看跟踪的高手是否在我的跟踪列表
	 * [预期结果]：
	 * 1、step2执行完：提示添加成功；跟踪按钮文字变为已跟踪，且按钮变为不可点状态
	 * 3、step4执行完：界面跳转到我的跟踪列表，跟踪的高手出现在我的跟踪列表
	 */
	@Test
	public void testLoginPage() {

		up.goHomePage();
		up.verifyIsShown("股林高手");
		up.clickOn("股林高手");
		up.verifyIsShown("日收益榜");
		up.clickOn("日收益榜");
		up.verifyIsShown("股票1跟踪");
		up.clickOn("股票1跟踪");
		up.storeToLogin();
		up.clickOn("股票1跟踪");
		
		up.verifyIsShown("我的跟踪");
		up.clickOn("我的跟踪");
		up.verifyIsShown("高手名称1");
		up.verifyIsShown("总收益率1");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
