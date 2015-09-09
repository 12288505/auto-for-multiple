package testcase.UP_China.Android.P1.PinZhongFenXi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_16_storageInfo_shenA {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：07 未收藏未登录状态-登陆成功收藏资讯");
		up.openApp();
	}

	/**
	 * 测试名称：07 未收藏未登录状态-登陆成功收藏资讯
	 * [前提条件]：
	 * 路径：底部的行情-更多-深A-任一股票-资讯-任一资讯标题-收藏
	 * 1、当前资讯未被收藏
	 * 1、用户未登录
	 * [测试步骤]：
	 * 1、点击收藏
	 * 2、在登陆界面输入可以登陆成功的账户和密码；
	 * 3、点击登陆
	 * 4、在资讯正文界面点击收藏
	 * [预期结果]：
	 * 1、step1执行完：弹出登陆界面
	 * 2、step3执行完：跳转到资讯正文阅读界面，收藏图标仍然空心显示，收藏图标旁的文字仍为收藏
	 * 3、step4执行完：资讯下方收藏图标显示为橙色实心五角心，文字显示已收藏
	 */
	@Test
	public void testStorageInfo_shenA() {

		up.goHomePage();
		up.verifyIsShown("跳转行情");
		up.clickOn("跳转行情");
		up.verifyIsShown("更多");
		up.clickOn("更多");
		up.verifyIsShown("深A");
		up.clickOn("深A");
		up.clickOn("操作提示");

		up.verifyIsShown("品种名称");
		up.clickOn("品种名称");
		up.clickOn("操作提示");

		up.swipeUpToElement("资讯内容");
		up.verifyIsShown("资讯内容");
		up.clickOn("资讯内容");

		up.clickOn("操作提示");
		up.verifyIsShown("收藏");
		up.clickOn("收藏");

		up.storeToLogin();
		up.verifyIsShown("收藏");
		up.clickOn("收藏");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
