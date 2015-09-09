package testcase.UP_China.Android.P1.BoHaiZhiBo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_01_JieMianCaoZuo {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：界面操作");
		up.openApp();
	}

	/**
	 * 测试名称：01 界面操作
	 * [前提条件]：
	 * 1、首页－渤海直播
	 * [测试步骤]：
	 * 1、点击名家头像；
	 * 2、点击名家名称；
	 * 3、点击【平仓】（/开仓/观点）；
	 * 4、点击商品名称（代码）；
	 * 5、点击价格及操作；
	 * 6、点击评论；
	 * 7、点击【全文】/【收起】；
	 * 8、点击【跟单】；
	 * 
	 * [预期结果]：
	 * 1、操作一、二、四、五、六执行后，均进入该名家的名家实盘页面；
	 * 2、操作三执行后，无响应；
	 * 3、操作七执行后，显示全部评论内容和收起部分；
	 * 4、操作八执行后，跳转到渤海交易登录页面；
	 */
	@Test
	public void testJieMianCaoZuo() {

		up.goHomePage();
		up.verifyIsShown("选股");
		up.clickOn("选股");
		up.verifyIsShown("返回");
		up.clickOn("返回");
		up.verifyIsShown("自选");

		up.verifyIsShown("选股");
		up.clickOn("选股");
		up.swipeUpToElement("QFII重仓");

		up.verifyIsShown("基金重仓");
		up.clickOn("基金重仓");
		up.log(up.getValueOf("标题"));
		up.clickOn("返回");

		up.verifyIsShown("社保重仓");
		up.clickOn("社保重仓");
		up.log(up.getValueOf("标题"));
		up.clickOn("返回");

		up.verifyIsShown("QFII重仓");
		up.clickOn("QFII重仓");
		up.log(up.getValueOf("标题"));
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
