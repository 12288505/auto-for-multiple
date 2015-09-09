package testcase.UP_China.Android.P1.ZiXuanGu;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_01_defaultSort {

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
	 * 测试名称：自选股默认排序
	 * 测试步骤:
	 * 1、查看自选股票界面
	 * 期望结果：
	 * 1、初始排序按照添加自选股的先后顺序排序；
	 */
	@Test
	public void testDefaultSort() {

		up.log("开始测试：自选股默认排序");
		up.goHomePage();
		up.verifyIsShown("跳转自选");
		up.clickOn("跳转自选");

		up.clickOn("自选提示");
		up.clickOn("搜索");
		up.clickOn("0");
		up.verifyIsShown("加自选");
		up.clickOn("加自选");
		up.verifyIsShown("加自选");
		up.clickOn("加自选");
		up.verifyIsShown("加自选");
		up.clickOn("加自选");
		up.verifyIsShown("已添加");

		String result1 = up.getValueOf("搜索1");
		String result2 = up.getValueOf("搜索2");
		String result3 = up.getValueOf("搜索3");
		up.clickOn("返回");

		up.compareText("名称1", result1);
		up.compareText("名称2", result2);
		up.compareText("名称3", result3);
	}
}
