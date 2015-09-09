package testcase.UP_China.Android.P1.ZhiShuLieBiao;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_05_listSort {

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
	 * 测试名称：指数列表特定字段排序切换
	 * 测试步骤:
	 * 1、进入指数行情列表
	 * 2、多次单击名称字段
	 * 3、多次单击现价字段
	 * 4、多次单击涨幅字段
	 * 期望结果：
	 * 1、step2执行完之后：相邻两次单击按照名称字段先升序再降序（或先降序再升序）排序
	 * 2、step3执行完之后：相邻两次单击按照现价字段先升序再降序（或先降序再升序）排序
	 * 3、step4执行完之后：相邻两次单击按照涨幅字段先升序再降序（或先降序再升序）排序
	 */
	@Test
	public void testListSort() {

		up.log("开始测试：指数列表特定字段排序切换");
		up.goHomePage();
		
		up.verifyIsShown("跳转行情");
		up.clickOn("跳转行情");
		
		up.verifyIsShown("更多");
		up.clickOn("更多");
		
		up.verifyIsShown("指数");
		up.clickOn("指数");
		up.clickOn("操作提示");
		
		up.verifyIsShown("名称(代码)");
		up.clickOn("名称(代码)");
		up.verifyIsShown("升序");
		up.clickOn("名称(代码)");
		up.verifyIsShown("降序");
		
		up.verifyIsShown("现价");
		up.clickOn("现价");
		up.verifyIsShown("升序1");
		up.clickOn("现价↑");
		up.verifyIsShown("降序1");
		
		up.verifyIsShown("涨幅");
		up.clickOn("涨幅");
		up.verifyIsShown("升序2");
		up.clickOn("涨幅↑");
		up.verifyIsShown("降序2");
	}
}
