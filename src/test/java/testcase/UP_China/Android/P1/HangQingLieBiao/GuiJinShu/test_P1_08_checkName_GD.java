package testcase.UP_China.Android.P1.HangQingLieBiao.GuiJinShu;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_08_checkName_GD {

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
	 * 测试名称：贵金属综合屏广东贵金属列表字段展示
	 * 测试步骤:
	 * 1、查看贵金属综合屏广东贵金属列表所展示的字段
	 * 期望结果：
	 * 1、每行数据均展示：品种名称，品种代码，现价，涨幅
	 */
	@Test
	public void testDataRefresh() {

		up.log("开始测试：贵金属综合屏广东贵金属列表字段展示");
		up.goHomePage();

		up.verifyIsShown("贵金属");
		up.clickOn("贵金属");
		up.verifyIsShown("天通银");
		up.swipe("up");

		up.verifyIsShown("广东贵金属1");
		up.verifyIsShown("广东贵金属1现价");
		up.verifyIsShown("广东贵金属1涨幅");

		up.verifyIsShown("广东贵金属2");
		up.verifyIsShown("广东贵金属2现价");
		up.verifyIsShown("广东贵金属2涨幅");

		up.verifyIsShown("广东贵金属3");
		up.verifyIsShown("广东贵金属3现价");
		up.verifyIsShown("广东贵金属3涨幅");
	}
}
