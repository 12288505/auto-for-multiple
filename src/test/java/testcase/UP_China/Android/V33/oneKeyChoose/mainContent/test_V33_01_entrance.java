package testcase.UP_China.Android.V33.oneKeyChoose.mainContent;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_V33_01_entrance {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：入口");
		up.openApp();
	}

	/**
	 * 测试名称：01 入口
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、｛一键选股｝，点击列表中指标项
	 * [预期结果]：
	 * 1、跳转至指标内容页/选股列表页
	 */
	@Test
	public void test010entrance() {

		up.goHomePage();

		up.verifyIsShown("选股");
		up.clickOn("选股");

		up.verifyIsShown("一键选股");
		up.clickOn("一键选股");

		up.verifyIsShown("MACD金叉");
		up.clickOn("MACD金叉");

		up.verifyIsShown("形态名称");
		up.verifyIsShown("文案描述");
		up.verifyIsShown("名称代码");
		up.verifyIsShown("现价");
		up.verifyIsShown("涨幅");

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
