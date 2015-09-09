package testcase.UP_China.Android.P1.PinZhongFenXi;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_03_priceDisplay {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：报价数据字段数据显示");
		up.openApp();
	}

	/**
	 * 测试名称：报价数据字段数据显示
	 * [前提条件]：
	 * 1、品种有行情
	 * 
	 * [测试步骤]：
	 * 路径：底部的行情-更多-沪深A股-任一股票
	 * 1、对照大字报区查看
	 * 
	 * [预期结果]：
	 * 1、与行情列表对比最高、最低、换手率、成交额、开盘、昨收、市盈率、成交量数据正确；
	 * 2、与pc端对比数据正确；
	 * 3、与大字报价区对比计算（大字报价现价-大字报价涨跌=昨收，大字报价涨跌幅*昨收=大字报价涨跌），数据正确；
	 * 4、数据单位已按照需求显示：成交量或成交额，如果达到万，就以万为单位，达到亿就以亿为单位，小数点前最多4位，小数点后最多2位；
	 */
	@Test
	public void testPriceDisplay() {

		up.goHomePage();

		up.goToStock();
		
		String pzname = up.getValueOf("品种名称");
		String pzcode = up.getValueOf("品种代码");
		String pzpresent = up.getValueOf("品种现价");
		String pzgains = up.getValueOf("品种涨幅");
		up.verifyIsShown("品种名称");
		up.clickOn("品种名称");
		
		up.clickOn("操作提示");
		String pzname1 = up.getValueOf("标题");
		String pzcode1 = up.getValueOf("代码");
		String pzpresent1 = up.getValueOf("现价");
		String pzgains1 = up.getValueOf("涨幅");
		Boolean compare = (pzname.equals(pzname1) && pzcode.equals(pzcode1) && pzpresent.equals(pzpresent1) && pzgains.equals(pzgains1));
		if(compare)
			up.log("标题、代码、现价、涨幅");
		Assert.assertTrue(compare);
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
