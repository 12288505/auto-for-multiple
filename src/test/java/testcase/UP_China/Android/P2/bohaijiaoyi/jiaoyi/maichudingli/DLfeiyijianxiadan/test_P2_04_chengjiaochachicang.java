package testcase.UP_China.Android.P2.bohaijiaoyi.jiaoyi.maichudingli.DLfeiyijianxiadan;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_04_chengjiaochachicang {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：全部成交-查持仓");
		up.openApp();

	}

	/**
	 * 测试名称：04 全部成交-查持仓
	 * [[前提条件]：
	 * 1、在交易时间内
	 * 2、资金充足
	 * [测试步骤]：
	 * 1、选择委托类型为订立
	 * 2、在委托价格编辑框输入可以立马成交的委托价格（如对手价）
	 * 3、在委托数量编辑框输入可以立马成交的委托数量（如默认数量）
	 * 4、点击卖出按钮
	 * 5、点击委托确认对话框的确认按钮
	 * 6、点击委托成功对话框的确定按钮
	 * 7、点击底部导航栏持仓标签
	 * [预期结果]：
	 * 1、界面切换到持仓界面
	 * 2、持仓中所下单品种的卖出订立单订货量增加的值等于委托数量
	 */
	@Test(dependsOnGroups = "Bohai time")
	public void testChengjiaochachicang() {

		up.goHomePage();
		up.verifyIsShown("自选");
		up.goToHeader("渤海交易");
		up.login_BH();

		up.verifyIsShown("订立");
		up.clickOn("订立");
		up.clickOn("出价");
		up.sendNum(up.getValueOf("买入价格"));
		up.tapOn(9.9, 9.9);
		up.waitByTimeout(1000);
		up.tapOn(9.9, 9.9);
		String amount = up.getValueOf("订购数量");
 
		up.verifyIsShown("卖出");
		up.clickOn("卖出");
		up.verifyIsShown("委托确定1");
		up.clickOn("委托确定1");
		up.verifyIsShown("委托确定2");
		up.clickOn("委托确定2");
		up.clickOn("操作提示");
		
		up.clickOn("持仓");
		up.clickOn("操作提示");
		String amount1 = up.getValueOf("订货量");
		Boolean compare = (amount.equals(amount1));
		if(compare)
			up.log("持仓中所下单品种的卖出订立单订货量增加的值等于委托数量");
		Assert.assertTrue(compare);
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
