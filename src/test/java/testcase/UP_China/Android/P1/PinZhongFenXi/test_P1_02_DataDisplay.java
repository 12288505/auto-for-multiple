package testcase.UP_China.Android.P1.PinZhongFenXi;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_02_DataDisplay {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：有行情时各数据值显示");
		up.openApp();
	}

	/**
	 * 测试名称：有行情时各数据值显示
	 * [前提条件]：
	 * 1、品种有行情
	 * 
	 * [测试步骤]：
	 * 路径：底部的行情-更多-沪深A股-任一股票
	 * 1、查看现价数据值；
	 * 2、查看涨跌幅数据值；
	 * 3、查看涨跌数据值；
	 * 
	 * [预期结果]：
	 * 1、与行情列表对比，现价、涨跌幅、涨跌数据正确；
	 * 2、与PC端对比，现价、涨跌幅、涨跌数据正确；
	 * 3、与盘口数据进行对比计算，数据正确：
	 * （大字报价现价-盘口数据昨收）/昨收*100%=大字报价涨跌幅
	 * 大字报价现价-盘口数据昨收=大字报价涨跌
	 */
	@Test
	public void testDataDisplay() {
		up.goHomePage();
		
		up.goToStock();
		
		String price = up.getValueOf("品种现价");
		String gains = up.getValueOf("品种涨幅");	
		up.verifyIsShown("品种名称");
		up.clickOn("品种名称");
		
		up.clickOn("操作提示");
		String price1 = up.getValueOf("现价");
		String gains2 = up.getValueOf("涨幅");
		up.getValueOf("涨幅价");
		Boolean compare = (price.equals(price1) && gains.equals(gains2));
		if(compare == true)
			up.log("与行情列表对比，现价、涨跌幅数据正确");
		Assert.assertTrue(compare);
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
