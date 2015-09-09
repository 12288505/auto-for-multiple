package testcase.UP_China.Android.P1.PinZhongSouSuo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_01_guPiaoDaiMaPiPei {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：股票代码完全匹配");
		up.openApp();
	}

	/**
	 * 测试名称：01 股票代码完全匹配
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、进入【首页】->【搜索】
	 * 2、在搜索栏输入某只股票的完整代码（如：300220）
	 * 3、等待5秒左右（自动搜索）
	 * [预期结果]：
	 * 1、搜索结果列表显示股票名称，股票代码、自选股添加状态；（金运激光 300220 已添加/加自选）
	 */
	@Test
	public void testGuPiaoDaiMaPiPei() {

		up.goHomePage();
		up.verifyIsShown("搜索");
		up.clickOn("搜索");
		up.setValueTo("搜索框", "300220");
		up.waitByTimeout(5000);
		up.verifyIsShown("搜索1");
		up.verifyIsShown("加自选");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
