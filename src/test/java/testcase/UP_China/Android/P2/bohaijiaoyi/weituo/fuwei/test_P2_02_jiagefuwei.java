package testcase.UP_China.Android.P2.bohaijiaoyi.weituo.fuwei;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_02_jiagefuwei {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：价格复位-加操作");
		up.openApp();

	}

	/**
	 * 测试名称：02 价格复位-加操作
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、单击价格编辑框右侧的加号按钮
	 * 2、单击复位按钮
	 * [预期结果]：
	 * 1、step1执行完之后，价格编辑框中文字由对手价变为行情报价区域卖出价格加最小变价单位的值 ，下方买入按钮和卖出按钮上显示的价格和编辑框中一致
	 * 2、step2执行完之后，价格编辑框的值重新变为文字对手价，下方买入按钮和卖出按钮上显示的价格分别为行情卖档价格和买档价格
	 */
	@Test
	public void testJiagefuwei() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
