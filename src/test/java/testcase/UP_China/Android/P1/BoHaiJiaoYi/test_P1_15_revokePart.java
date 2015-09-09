package testcase.UP_China.Android.P1.BoHaiJiaoYi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_15_revokePart {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：确定撤单-撤部分");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：确定撤单-撤部分
	 * [前提条件]：
	 * 1、撤单列表有多条数据
	 * 2、在交易时间内
	 * [测试步骤]：
	 * 1、点击某品种的撤单按钮
	 * 2、点击撤单提示对话框的确定按钮
	 * 
	 * [预期结果]：
	 * 1、被撤单的品种从撤单列表中删除
	 */
	@Test(dependsOnGroups = "Bohai time")
	public void testDataRefresh() {

		up.goHomePage();
		
		up.verifyIsShown("自选");
		up.verifyIsShown("沪深股票");

		up.goToHeader("渤海交易");
		up.login_BH();
		up.clickOn("出价");
		up.sendNum(up.getValueOf("涨停"));
		up.tapOn(9.9, 9.9);
		up.waitByTimeout(1000);
		up.tapOn(9.9, 9.9);
		up.verifyIsShown("卖出");
		up.clickOn("卖出");
		
		up.verifyIsShown("委托确定1");
		up.clickOn("委托确定1");
		
		up.verifyIsShown("委托确定2");
		up.clickOn("委托确定2");
		
		up.clickOn("操作提示");
		up.verifyIsShown("撤单");
		up.clickOn("撤单");
		up.waitByTimeout(5000);
		up.verifyIsShown("撤单1");
		up.clickOn("撤单1");
		up.verifyIsShown("确定");
		up.clickOn("确定");
		up.verifyIsShown("确定1");
		up.clickOn("确定1");
		up.verifyIsShown("标题");
	}
}
