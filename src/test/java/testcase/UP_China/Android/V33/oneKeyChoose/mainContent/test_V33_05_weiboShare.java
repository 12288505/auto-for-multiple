package testcase.UP_China.Android.V33.oneKeyChoose.mainContent;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_V33_05_weiboShare {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：微博分享");
		up.openApp();
	}

	/**
	 * 测试名称：05 微博分享
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、点击底部【分享】
	 * 2、选择微博并分享
	 * [预期结果]：
	 * 1、底部弹出分享窗口，有微博分享、微信好友、微信朋友圈、ｑｑ选择，有【取消】
	 * 2、分享成功，微博显示分享内容并链接正常
	 * 3、链接内容页面比指标内容多出客户端下载链接，点击链接可正常下载客户端
	 */
	@Test
	public void test010Demo() {

		up.goHomePage();

		up.verifyIsShown("选股");
		up.clickOn("选股");

		up.verifyIsShown("一键选股");
		up.clickOn("一键选股");

		up.verifyIsShown("MACD金叉");
		up.clickOn("MACD金叉");

		up.verifyIsShown("分享");
		up.clickOn("分享");

		up.verifyIsShown("新浪微博");
		up.clickOn("新浪微博");

		up.verifyIsShown("确定分享");
		up.clickOn("确定分享");

		up.verifyIsShown("微博图标");
		up.setValueTo("微博帐号", up.getWeiboAccount());
		up.setValueTo("微博密码", up.getWeiboPassword());
		up.clickOn("登录");

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
