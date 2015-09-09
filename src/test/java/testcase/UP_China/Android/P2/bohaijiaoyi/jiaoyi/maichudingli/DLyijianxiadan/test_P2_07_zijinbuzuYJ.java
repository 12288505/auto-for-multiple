package testcase.UP_China.Android.P2.bohaijiaoyi.jiaoyi.maichudingli.DLyijianxiadan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_07_zijinbuzuYJ {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：资金不足");
		up.openApp();

	}

	/**
	 * 测试名称：07 资金不足
	 * [前提条件]：
	 * 1、在交易时间内
	 * [测试步骤]：
	 * 1、选择委托类型为订立
	 * 2、在委托价格编辑框输入可以立马成交的委托价格（如对手价）
	 * 3、在委托数量编辑框输入大于可订买数量的委托数量
	 * 4、点击卖出按钮
	 * [预期结果]：
	 * 1、弹出提示：资金余额不足
	 */
	@Test(dependsOnGroups = "Bohai time")
	public void testZijinbuzuYJ() {

		up.goHomePage();
		up.verifyIsShown("自选");
		up.goToHeader("渤海交易");
		up.login_BH();
		up.aKeyOrder();

		up.verifyIsShown("订立");
		up.clickOn("订立");
		up.clickOn("出价");
		up.sendNum(up.getValueOf("买入价格"));
		up.tapOn(9.9, 9.9);;
		int a = Integer.valueOf(up.getValueOf("可定卖"));
		String a1 = String.valueOf(a + 1);
		up.sendNum(a1);
		up.waitByTimeout(1000);
		up.tapOn(9.9, 9.9);
		
		up.verifyIsShown("卖出");
		up.clickOn("卖出");
		up.verifyIsShown("委托确定2");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
