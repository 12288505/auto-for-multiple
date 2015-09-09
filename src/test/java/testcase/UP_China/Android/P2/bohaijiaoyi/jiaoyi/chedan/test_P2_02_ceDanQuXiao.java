package testcase.UP_China.Android.P2.bohaijiaoyi.jiaoyi.chedan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_02_ceDanQuXiao {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：撤单取消");
		up.openApp();

	}

	/**
	 * 测试名称：02 撤单取消
	 * [前提条件]：
	 * 1、撤单列表只有一条数据
	 * 2、在交易时间内
	 * [测试步骤]：
	 * 1、点击某品种的撤单按钮
	 * 2、点击撤单提示对话框的取消按钮
	 * 
	 * [预期结果]：
	 * 1、撤单界面数据无任何变化；
	 */
	@Test(dependsOnGroups = "Bohai time")
	public void testCeDanQuXiao() {

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
		up.verifyIsShown("取消");
		up.clickOn("取消");
		up.verifyIsShown("标题");
		up.cheDan();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
