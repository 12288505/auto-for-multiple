package testcase.UP_China.Android.P2.bohaijiaoyi.jiaoyi.maichudingli.DLfeiyijianxiadan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_06_weichengjiaoweituoqueding {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：全部未成交-委托确认");
		up.openApp();

	}

	/**
	 * 测试名称：06 全部未成交-委托确认
	 * [前提条件]：
	 * 1、在交易时间内下单；
	 * 2、资金充足
	 * [测试步骤]：
	 * 1、选择委托类型为订立
	 * 2、在委托价格编辑框输入可以委托成功但不能成交的委托价格（如高于对手价的价格）；
	 * 3、在委托数量编辑框输入委托数量
	 * 4、点击卖出按钮
	 * 5、点击委托确认对话框的确认按钮
	 * [预期结果]：；
	 * 1、弹出委托成功对话框；
	 * 2、委托成功对话提示：委托成功！
	 * 3、委托成功提示对话框下方显示确定按钮
	 */
	@Test(dependsOnGroups = "Bohai time")
	public void testWeichengjiaoweituoqueding() {

		up.goHomePage();
		up.verifyIsShown("自选");
		up.goToHeader("渤海交易");
		up.login_BH();

		up.verifyIsShown("订立");
		up.clickOn("订立");
		up.clickOn("出价");
		up.sendNum(up.getValueOf("涨停"));
		up.tapOn(9.9, 9.9);
		up.waitByTimeout(1000);
		up.tapOn(9.9, 9.9);

		up.verifyIsShown("卖出");
		up.clickOn("卖出");
		up.verifyIsShown("委托确定1");
		up.clickOn("委托确定1");
		up.verifyIsShown("委托成功");
		up.verifyIsShown("委托确定2");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
