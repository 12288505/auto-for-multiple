package testcase.UP_China.Android.V33.oneKeyChoose.mainContent;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_V33_09_cancelShare {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：取消分享");
		up.openApp();
	}

	/**
	 * 测试名称：09
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、点击【分享】
	 * 2、弹框中点击【取消】
	 * [预期结果]：
	 * 1、分享窗口消失
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

		up.clickOn("取消");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
