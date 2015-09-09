package testcase.UP_China.Android.P1.FaXian;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_04_caiJingRiLi {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：财经日历列表");
		up.openApp();
	}

	/**
	 * 测试名称：财经日历列表
	 * 测试步骤:
	 * 发现-财经日历
	 * 期望结果：
	 * 财经日历列表显示正常
	 */
	@Test
	public void test010CaiJingRiLi() {

		up.goHomePage();
		up.clickOn("跳转发现");

		up.verifyIsShown("财经日历");
		up.clickOn("财经日历");

		up.verifyIsShown("名称");
		up.verifyIsShown("现价");
		up.verifyIsShown("涨价");
		up.verifyIsShown("涨幅");

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
