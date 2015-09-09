package testcase.UP_China.Android.P2.bohaijiaoyi.jiaoyi.maichudingli.DLyijianxiadan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_08_weituojiagegaoYJ {

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
	 * 5、点击卖出按钮
	 * [预期结果]：
	 * 1、弹出提示：委托价格超出涨幅上限
	 */
	@Test(dependsOnGroups = "Bohai time")
	public void testWeituojiagegaoYJ() {

		up.goHomePage();
		up.goHomePage();
		up.verifyIsShown("自选");
		up.goToHeader("渤海交易");
		up.login_BH();
		up.aKeyOrder();

		up.verifyIsShown("订立");
		up.clickOn("订立");
		up.clickOn("出价");
		up.sendNum(up.getValueOf("涨停"));
		up.clickOn("数量增加");
		up.tapOn(9.9, 9.9);;
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
