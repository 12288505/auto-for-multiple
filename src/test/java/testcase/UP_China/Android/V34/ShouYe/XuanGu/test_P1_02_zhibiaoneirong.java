package testcase.UP_China.Android.V34.ShouYe.XuanGu;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_02_zhibiaoneirong {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：入口");
		up.openApp();
	}

	/**
	 * 测试名称：02 入口
	 * [测试步骤]：
	 * 1、首页－选股－一键选股
	 * 2、点击列表中指标项
	 * 
	 * [预期结果]：
	 * 1、跳转至指标内容页/选股列表页
	 */
	@Test
	public void testZhibiaoneirong() {

		up.goHomePage();

		up.verifyIsShown("智能选股");
		up.clickOn("智能选股");
		
		up.verifyIsShown("一键选股");
		up.clickOn("一键选股");
		
		up.verifyIsShown("MACD金叉");
		up.clickOn("MACD金叉");
		
		up.verifyIsShown("指标内容标题");
		up.verifyIsShown("指标内容返回");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
