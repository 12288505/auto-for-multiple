package testcase.UP_China.Android.P1.FaXian;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_02_fenXiShi {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：明星分析师荐股列表");
		up.openApp();
	}

	/**
	 * 测试名称：明星分析师荐股列表
	 * 测试步骤:
	 * 发现-明星分析师荐股
	 * 期望结果：
	 * 明星分析师荐股列表显示正常
	 */
	@Test
	public void test010FenXiShi() {

		up.goHomePage();
		up.clickOn("跳转发现");

		up.verifyIsShown("明星分析师荐股");
		up.clickOn("明星分析师荐股");

		up.verifyIsShown("名称");
		up.verifyIsShown("明星分析师");
		up.verifyIsShown("评级");
		up.verifyIsShown("目标价");

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
