package testcase.UP_China.Android.P2.bohaijiaoyi.jiaoyi.mairudingli.yijianxiadan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_08_jiagegaodiejiaYJ {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：委托价格高于跌停价");
		up.openApp();

	}

	/**
	 * 测试名称：08 委托价格高于跌停价
	 * [前提条件]：
	 * 1、在交易时间内
	 * 2、资金充足
	 * [测试步骤]：
	 * 1、选择委托类型为订立
	 * 2、在委托价格编辑框输入涨停价
	 * 3、点击价格编辑框右侧的加号按钮
	 * 4、在委托数量编辑框输入可以立马成交的委托数量（如默认数量）
	 * 5、点击买入按钮
	 * [预期结果]：
	 * 1、弹出提示：委托价格超出涨幅上限
	 */
	@Test
	public void testJiagegaodiejiaYJ() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
