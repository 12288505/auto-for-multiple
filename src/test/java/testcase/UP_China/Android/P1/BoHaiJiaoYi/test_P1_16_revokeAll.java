package testcase.UP_China.Android.P1.BoHaiJiaoYi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_16_revokeAll {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：确定撤单-撤所有");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：确定撤单-撤所有
	 * [前提条件]：
	 * 1、撤单列表只有一条数据
	 * 2、在交易时间内
	 * [测试步骤]：
	 * 1、点击某品种的撤单按钮
	 * 2、点击撤单提示对话框的确定按钮
	 * 
	 * [预期结果]：
	 * 1、提示：撤单成功
	 * 2、被撤单的品种从列表中删除；
	 * 3、界面显示图标哭脸和未查询到订单信息
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
		up.cheDan();
		if (up.getElementsSize("撤单按钮") == 0) {
			up.log("暂无撤单信息！");
			up.verifyIsShown("图片");
		} else {
			up.log("界面能查询到订单信息！！");
		}
	}
}
