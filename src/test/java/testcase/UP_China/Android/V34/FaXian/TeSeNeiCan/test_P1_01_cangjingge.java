package testcase.UP_China.Android.V34.FaXian.TeSeNeiCan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_01_cangjingge {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：页面交互");
		up.openApp();
	}

	/**
	 * 测试名称：01 页面交互
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、｛发现｝－｛高手藏经阁｝
	 * 2、点击返回图标
	 * 3、点击列表中任意未读项
	 * [预期结果]：
	 * 1、进入｛高手藏经阁｝
	 * 2、返回至｛发现｝
	 * 3、进入日刊正文，且列表前面状态由红色（未读）变为灰色（已读）
	 */
	@Test
	public void testCangjingge() {

		up.goHomePage();
		
		up.verifyIsShown("跳转发现");
		up.clickOn("跳转发现");
		up.clickOn("发现导航");
		
		up.swipeUpToElement("高手藏金阁");
		up.verifyIsShown("高手藏金阁");
		up.clickOn("高手藏金阁");
		
		up.clickOn("高手藏金阁返回");
		up.clickOn("高手藏金阁");
		
		up.verifyIsShown("新闻内容1");
		up.clickOn("新闻内容1");
		
		up.clickOn("操作提示");
		up.verifyIsShown("资讯返回");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
