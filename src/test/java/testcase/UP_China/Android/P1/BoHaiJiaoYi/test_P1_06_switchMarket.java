package testcase.UP_China.Android.P1.BoHaiJiaoYi;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_06_switchMarket {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：行情报价切换");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：行情报价切换
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、在委托界面搜索栏切换新品种
	 * 2、查看行情报价区域数据变化
	 * [预期结果]：
	 * 1、行情报价区域的数据更新为新品种的报价数据；
	 */
	@Test
	public void testDataRefresh() {

//		if (!up.compareTime())
//			throw new RuntimeException("当前是非交易时间，退出测试");
		up.goHomePage();
		
		up.verifyIsShown("自选");
		up.verifyIsShown("沪深股票");

		up.goToHeader("渤海交易");
		up.login_BH();

		up.verifyIsShown("搜索按钮");
		up.clickOn("搜索按钮");
		
		up.verifyIsShown("搜索");
		up.clickOn("搜索");
		up.sendB();
		up.sendA();
		
		up.clickOn("名称1");
		String hq1 = up.getValueOf("行情报价");
		
		up.clickOn("搜索按钮");
		
		up.verifyIsShown("搜索");
		up.clickOn("搜索");
		up.sendB();
		up.sendA();
		
		up.clickOn("名称2");
		String newhq1 = up.getValueOf("行情报价");
		boolean validate = (hq1.equals(newhq1));
		if (validate==true){
			up.log("行情报价区域的数据没有更新为新品种的报价数据");
		}else
			up.log("行情报价区域的数据更新为新品种的报价数据");
		Assert.assertFalse(validate);
	}
}
