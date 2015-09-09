package testcase.UP_China.Android.P1.PinZhongFenXi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_10_checkInfo {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：01 上滑查看资讯等内容（有资讯列表时）");
		up.openApp();
	}

	/**
	 * 测试名称：01 上滑查看资讯等内容（有资讯列表时）
	 * [前提条件]：
	 * 路径：底部的行情-更多-沪深A股-任一股票-资讯
	 * 1、有资讯列表；
	 * 
	 * [测试步骤]：
	 * 1、向上滑动品种分析页；
	 * 
	 * [预期结果]：
	 * 1、默认显示【资讯】；
	 * 2、有资讯列表显示；
	 * 3、查看隐藏的资讯列表；
	 * 4、没有资讯列表的品种提示：
	 */
	@Test
	public void testCheckInfo() {

		up.goHomePage();
		up.goToStock();

		up.verifyIsShown("品种名称");
		up.clickOn("品种名称");
		up.clickOn("操作提示");

		up.swipeUpToElement("资讯内容");
		up.verifyIsShown("资讯内容");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
