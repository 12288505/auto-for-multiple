package testcase.UP_China.Android.P1.ZhiShuLieBiao;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_06_switchSort {

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
	 * 测试名称：指数列表切换排序字段
	 * 测试步骤:
	 * 1、单击指数行情列表中名称,现价,涨幅三个字段中任一一个(如现价);
	 * 2、在名称,现价,涨幅三个字段中单击一个与step1不同的字段(如涨幅);
	 * 期望结果：
	 * 1、数据按照step2单击的字段降序排列;
	 */
	@Test
	public void testSwitchSort() {

		up.log("开始测试：指数列表切换排序字段");
		up.goHomePage();
		
		up.verifyIsShown("跳转行情");
		up.clickOn("跳转行情");
		
		up.verifyIsShown("更多");
		up.clickOn("更多");
		
		up.verifyIsShown("指数");
		up.clickOn("指数");
		up.clickOn("操作提示");
		
		up.verifyIsShown("现价");
		up.clickOn("现价");
		up.verifyIsShown("升序1");
		
		up.verifyIsShown("涨幅");
		up.clickOn("涨幅");
		up.verifyIsShown("降序2");
	}
}
