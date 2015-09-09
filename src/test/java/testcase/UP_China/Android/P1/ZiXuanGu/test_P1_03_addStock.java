package testcase.UP_China.Android.P1.ZiXuanGu;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_03_addStock {

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
	 * 测试名称：通过搜索栏添加自选股票
	 * 测试步骤:
	 * 1、点击右上角搜索图标，进入搜索页面；
	 * 2、输入代码/拼音首字母进行搜索；
	 * 3、点击搜索结果右侧加号；
	 * 4、返回自选股票页面；
	 * 期望结果：
	 * 1、步骤三执行后，加号变成对钩，【加自选】字样变为【已添加】，界面提示添加成功；
	 * 2、步骤四执行后，自选股票页面有该股；
	 */

	@Test
	public void testAddStock() {

		up.log("开始测试：通过搜索栏添加自选股票");
		up.goHomePage();
		up.verifyIsShown("跳转自选");
		up.clickOn("跳转自选");

		up.clickOn("自选提示");
		up.clickOn("搜索");
		up.clickOn("0");
		up.verifyIsShown("加自选");
		up.clickOn("加自选");
		up.verifyIsShown("已添加");

		String result = up.getValueOf("搜索1");
		up.clickOn("返回");

		up.compareText("名称1", result);
	}
}
