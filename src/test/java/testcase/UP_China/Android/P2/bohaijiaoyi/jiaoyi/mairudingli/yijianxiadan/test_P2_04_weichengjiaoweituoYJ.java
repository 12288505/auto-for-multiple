package testcase.UP_China.Android.P2.bohaijiaoyi.jiaoyi.mairudingli.yijianxiadan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_04_weichengjiaoweituoYJ {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：全部未成交-委托确认");
		up.openApp();

	}

	/**
	 * 测试名称：04 全部未成交-委托确认
	 * [前提条件]：
	 * 1、在交易时间内下单；
	 * 2、资金充足
	 * [测试步骤]：
	 * 1、选择委托类型为订立
	 * 2、在委托价格编辑框输入可以委托成功但不能成交的委托价格（如低于对手价的价格）；
	 * 3、在委托数量编辑框输入委托数量；
	 * 4、点击买入按钮；
	 * [预期结果]：
	 * 1、弹出委托成功对话框；
	 * 2、委托成功对话提示：委托成功！
	 * 3、委托成功提示对话框下方显示确定按钮
	 */
	@Test
	public void testWeichengjiaoweituoYJ() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
