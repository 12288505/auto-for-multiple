package testcase.UP_China.Android.P1.ZhiShuLieBiao;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_04_listRefresh {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：指数列表数据定时刷新");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：指数列表数据定时刷新
	 * 测试步骤:
	 * 查看指数行情列表数据（现价、涨幅）变化频率
	 * 期望结果：
	 * 1、行情数据（现价、涨幅）刷新频率与所设置的行情刷新频率一致
	 */
	@Test(dependsOnGroups = "stock time")
	public void testListRefresh() {

		up.goHomePage();

		up.verifyIsShown("跳转行情");
		up.clickOn("跳转行情");

		up.verifyIsShown("更多");
		up.clickOn("更多");

		up.verifyIsShown("指数");
		up.clickOn("指数");
		up.clickOn("操作提示");

		String price = up.getValueOf("现价1");
		String increase = up.getValueOf("涨幅1");

		up.log("等待5秒");
		up.waitByTimeout(5000);

		String newprice = up.getValueOf("现价1");
		String newincrease = up.getValueOf("涨幅1");

		Boolean compare = (price.equals(newprice) && increase.equals(newincrease));
		if (compare == true)
			up.log("行情数据现价在5秒内没有刷新");
		Assert.assertFalse(compare);
	}
}
