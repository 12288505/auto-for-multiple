package testcase.UP_China.Android.P1.ZhiShuLieBiao;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_03_stcokAnalyse {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：指数行情列表进入品种分析页
	 * 测试步骤:
	 * 1、进入指数行情列表
	 * 2、点击任意品种所在行
	 * 期望结果：
	 * 1、品种分析页展示的品种与所点击的品种是同一品种；
	 */
	@Test
	public void testStcokAnalyse() {

		up.log("开始测试：指数行情列表进入品种分析页");
		up.goHomePage();
		
		up.verifyIsShown("跳转行情");
		up.clickOn("跳转行情");
		
		up.verifyIsShown("更多");
		up.clickOn("更多");
		
		up.verifyIsShown("指数");
		up.clickOn("指数");
		up.clickOn("操作提示");
		
		up.clickOn("指数名称1");
		up.clickOn("操作提示");
		up.verifyIsShown("标题");
		up.verifyIsShown("代码");
		up.verifyIsShown("返回");
	}
}
