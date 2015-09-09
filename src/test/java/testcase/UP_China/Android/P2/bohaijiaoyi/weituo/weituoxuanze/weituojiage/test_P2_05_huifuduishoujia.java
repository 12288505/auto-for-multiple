package testcase.UP_China.Android.P2.bohaijiaoyi.weituo.weituoxuanze.weituojiage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_05_huifuduishoujia {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：恢复对手价-任意值");
		up.openApp();

	}

	/**
	 * 测试名称：05 恢复对手价-任意值
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、在委托价格编辑框输入任意值；
	 * 2、点击对手价按钮
	 * [预期结果]：
	 * 1、价格编辑框恢复文字对手价
	 * 2、买入按钮价格变为行情卖档价格；
	 * 3、卖出按钮价格变为行情买档价格；
	 */
	@Test
	public void testHuifuduishoujia() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
