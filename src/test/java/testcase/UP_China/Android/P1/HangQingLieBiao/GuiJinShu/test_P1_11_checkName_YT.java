package testcase.UP_China.Android.P1.HangQingLieBiao.GuiJinShu;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_11_checkName_YT {

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
	 * 测试名称：贵金属综合屏大圆银泰列表字段展示
	 * 测试步骤:
	 * 1、查看贵金属综合屏大圆银泰列表所展示的字段
	 * 期望结果：
	 * 1、每行数据均展示：品种名称，品种代码，现价，涨幅
	 */
	@Test
	public void testDataRefresh() {

		up.log("开始测试：渤海商品综合屏顶部三个品种数据刷新");
		up.goHomePage();

		up.verifyIsShown("贵金属");
		up.clickOn("贵金属");
		up.verifyIsShown("天通银");
		up.swipeToText("大圆银泰");

		up.verifyIsShown("大圆银10");
		up.verifyIsShown("大圆银10现价");
		up.verifyIsShown("大圆银10涨幅");

		up.verifyIsShown("大圆银百");
		up.verifyIsShown("大圆银百现价");
		up.verifyIsShown("大圆银百涨幅");

		up.verifyIsShown("大圆银50");
		up.verifyIsShown("大圆银50现价");
		up.verifyIsShown("大圆银50涨幅");

	}
}
