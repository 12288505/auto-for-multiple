package testcase.UP_China.Android.P1.FaXian;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_01_cangJingGe {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：藏经阁列表");
		up.openApp();
	}

	/**
	 * 测试名称：藏经阁列表
	 * 测试步骤:
	 * 发现-高手藏经阁
	 * 期望结果：
	 * 高手藏经阁列表显示正常
	 */
	@Test
	public void test010CangJingGe() {

		up.goHomePage();
		up.clickOn("跳转发现");

		up.verifyIsShown("高手藏金阁");
		up.clickOn("高手藏金阁");

		up.verifyIsShown("高手藏金阁1");
		up.verifyIsShown("高手藏金阁2");
		up.verifyIsShown("高手藏金阁3");
		up.verifyIsShown("高手藏金阁4");

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
