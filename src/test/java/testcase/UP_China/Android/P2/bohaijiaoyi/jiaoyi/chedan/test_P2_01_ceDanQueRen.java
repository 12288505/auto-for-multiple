package testcase.UP_China.Android.P2.bohaijiaoyi.jiaoyi.chedan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_01_ceDanQueRen {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：撤单确认");
		up.openApp();

	}

	/**
	 * 测试名称：01 撤单确认
	 * [前提条件]：
	 * 1、撤单列表有数据
	 * 2、在交易时间内
	 * [测试步骤]：
	 * 1、点击某品种的撤单按钮
	 * [预期结果]：
	 * 1、弹出对话框提示：确认要撤销订单吗？
	 * 2、对话框下方展示确定和取消按钮；
	 */
	@Test(dependsOnGroups = "Bohai time")
	public void testCeDanQueRen() {

		up.goHomePage();
		up.verifyIsShown("自选");
		up.goToHeader("渤海交易");
		up.login_BH();
		up.clickOn("出价");
		up.sendNum(up.getValueOf("涨停"));
		up.tapOn(9.9, 9.9);
		up.waitByTimeout(1000);
		up.tapOn(9.9, 9.9);
		up.verifyIsShown("卖出");
		up.clickOn("卖出");
		up.clickOn("委托确定1");
		up.clickOn("委托确定2");
		
		up.clickOn("操作提示");
		
		up.clickOn("撤单");
		up.verifyIsShown("撤单1");
		up.clickOn("撤单1");
		up.verifyIsShown("确定");
		up.verifyIsShown("取消");
		up.clickOn("确定");
		up.verifyIsShown("确定1");
		up.clickOn("确定1");
		up.cheDan();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
