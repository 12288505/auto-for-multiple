package testcase.UP_China.Android.P1.HangQingLieBiao.GuiJinShu;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_05_checkName_TJ {

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
	 * 测试名称：贵金属综合屏天津贵金属列表字段展示
	 * 测试步骤:
	 * 1、查看贵金属综合屏天津贵金属列表所展示的字段
	 * 期望结果：
	 * 1、每行数据均展示：品种名称，品种代码，现价，涨幅
	 */
	@Test
	public void testDataRefresh() {

		up.log("开始测试：贵金属综合屏天津贵金属列表字段展示");
		up.goHomePage();

		up.verifyIsShown("贵金属");
		up.clickOn("贵金属");

		up.verifyIsShown("现货白银");
		up.compareText("现货白银", "现货白银");
		up.verifyIsShown("现货白银现价");
		up.verifyIsShown("现货白银涨幅");

		up.verifyIsShown("现货铝");
		up.compareText("现货铝", "现货铝");
		up.verifyIsShown("现货铝现价");
		up.verifyIsShown("现货铝涨幅");

		up.verifyIsShown("现货铜");
		up.compareText("现货铜", "现货铜");
		up.verifyIsShown("现货铜现价");
		up.verifyIsShown("现货铜涨幅");

	}
}
