package testcase.UP_China.Android.V34.FaXian.XuanGu;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_03_shebaozhongcang {

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
	 * 1、进入【发现】->【百宝箱】
	 * 2、点击社保重仓
	 * 
	 * [预期结果]：
	 * 1、进入｛社保重仓｝页面
	 */
	@Test
	public void testShebaozhongcang() {

		up.goHomePage();
		up.verifyIsShown("跳转发现");
		up.clickOn("跳转发现");
		up.clickOn("发现导航");
		
		up.verifyIsShown("社保重仓");
		up.clickOn("社保重仓");
		

		up.verifyIsShown("选股标题");
		up.verifyIsShown("名称");

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
