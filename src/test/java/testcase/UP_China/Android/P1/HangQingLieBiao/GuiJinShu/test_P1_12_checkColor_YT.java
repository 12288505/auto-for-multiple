package testcase.UP_China.Android.P1.HangQingLieBiao.GuiJinShu;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

@Test(groups="in process")
public class test_P1_12_checkColor_YT {

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
	 * 测试名称：贵金属综合屏大圆银泰列表字段颜色
	 * 测试步骤:
	 * 1、查看贵金属综合屏大圆银泰列表字段的颜色
	 * 期望结果：
	 * 1、品种名称黑色，品种代码灰色，现价和涨幅遵守红涨绿跌灰平
	 */
	@Test
	public void testDataRefresh() {

		up.log("开始测试：渤海商品综合屏顶部三个品种数据刷新");
		up.goHomePage();

	}
}
