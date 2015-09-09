package testcase.UP_China.Android.P1.HangQingLieBiao.GuiJinShu;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_02_checkName {

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
	 * 测试名称：贵金属综合屏顶部三个品种字段展示
	 * 测试步骤:
	 * 1、查看贵金属综合屏顶部三个品种展示的字段
	 * 期望结果：
	 * 1、每个品种分别显示：品种名称，现价，涨跌，涨幅
	 */
	@Test
	public void testDataRefresh() {

		up.log("开始测试：贵金属综合屏顶部三个品种字段展示");
		up.goHomePage();

		up.verifyIsShown("贵金属");
		up.clickOn("贵金属");

		up.verifyIsShown("天通银");
		up.compareText("天通银", "天通银");
		up.verifyIsShown("天通银现价");
		up.verifyIsShown("天通银涨跌");
		up.verifyIsShown("天通银涨幅");

		up.verifyIsShown("粤贵银");
		up.compareText("粤贵银", "粤贵银");
		up.verifyIsShown("粤贵银现价");
		up.verifyIsShown("粤贵银涨跌");
		up.verifyIsShown("粤贵银涨幅");

		up.verifyIsShown("大圆银");
		up.compareText("大圆银", "大圆银");
		up.verifyIsShown("大圆银现价");
		up.verifyIsShown("大圆银涨跌");
		up.verifyIsShown("大圆银涨幅");

	}
}
