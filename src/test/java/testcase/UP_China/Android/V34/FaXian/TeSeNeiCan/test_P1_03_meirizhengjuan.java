package testcase.UP_China.Android.V34.FaXian.TeSeNeiCan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_03_meirizhengjuan {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：入口");
		up.openApp();
	}

	/**
	 * 测试名称：03 入口
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、点击【发现】->【百宝箱】->【每日证券电讯】
	 * [预期结果]：
	 * 1、进入｛每日证券电讯｝页面
	 */
	@Test
	public void testMeirizhengjuan() {

		up.goHomePage();
		up.verifyIsShown("跳转发现");
		up.clickOn("跳转发现");
		up.clickOn("发现导航");
		
		up.swipeUpToElement("每日证券电讯");
		up.verifyIsShown("每日证券电讯");
		up.clickOn("每日证券电讯");
		
		up.verifyIsShown("特色内参标题");
		up.verifyIsShown("新闻内容1");
		up.verifyIsShown("新闻内容2");

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
