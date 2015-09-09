package testcase.UP_China.Android.P2.bohaijiaoyi.weituo.fuwei;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_04_fuweijiagezhuanjin {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：委托类型价格复位-转今 任意值");
		up.openApp();

	}

	/**
	 * 测试名称：04 委托类型价格复位-转今 任意值
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、切换委托类型为转今
	 * 2、在价格编辑框输入一个位于涨停和跌停之间的价格
	 * 3、点击复位按钮
	 * [预期结果]：
	 * 1、step1执行完之后：委托类型变为转今；
	 * 2、step2执行完之后：价格编辑框中文字由对手价变为所输入的价格，下方买入按钮和卖出按钮上显示的价格和编辑框中一致
	 * 3、step3执行完之后：委托类型恢复为订立，价格编辑框的值重新变为文字对手价，下方买入按钮和卖出按钮上显示的价格分别为行情卖档价格和买档价格
	 */
	@Test
	public void testFuweijiagezhuanjin() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
