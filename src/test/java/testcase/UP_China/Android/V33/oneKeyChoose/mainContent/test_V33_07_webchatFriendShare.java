package testcase.UP_China.Android.V33.oneKeyChoose.mainContent;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_V33_07_webchatFriendShare {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：微信朋友圈分享");
		up.openApp();
	}

	/**
	 * 测试名称：07 微信朋友圈分享
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、点击底部【分享】
	 * 2、选择微信朋友圈并分享
	 * [预期结果]：
	 * 1、底部弹出分享窗口，有微博分享、微信好友、微信朋友圈、ｑｑ选择，有【取消】
	 * 2、分享成功，微信朋友圈显示分享内容并链接正常
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
		up.verifyIsShown("微信好友");
		up.verifyIsShown("微信朋友圈");
		up.verifyIsShown("QQ好友");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
