package testcase.UP_China.Android.P1.BoHaiJiaoYi;


import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_05_reset {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：委托类型价格复位-转让 任意值");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：委托类型价格复位-转让 任意值
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、切换委托类型为转让
	 * 2、在价格编辑框输入一个位于涨停和跌停之间的价格
	 * 3、点击复位按钮
	 * [预期结果]：
	 * 1、step1执行完之后：委托类型变为转让；
	 * 2、step2执行完之后：价格编辑框中文字由对手价变为所输入的价格，下方买入按钮和卖出按钮上显示的价格和编辑框中一致
	 * 3、step3执行完之后：委托类型恢复为订立，价格编辑框的值重新变为文字对手价，下方买入按钮和卖出按钮上显示的价格分别为行情卖档价格和买档价格
	 */
	@Test(dependsOnGroups = "Bohai time")
	public void testDataRefresh() {

		up.goHomePage();
		
		up.verifyIsShown("自选");
		up.verifyIsShown("沪深股票");

		up.goToHeader("渤海交易");
		up.login_BH();
		
		String bid = up.getValueOf("出价");
		String enterprice = up.getValueOf("买入价格");
		String endingprice = up.getValueOf("卖出价格");
		
		up.verifyIsShown("转让");
		up.clickOn("转让");
		
		up.setValueTo("出价",up.getValueOf("卖出价格"));
		Boolean re = (up.getValueOf("买入价格")==up.getValueOf("出价") && up.getValueOf("卖出价格")==up.getValueOf("出价"));
		if(re == true){
			up.log("下方买入按钮和卖出按钮上显示的价格和编辑框中一致");
		}
		up.clickOn("复位");
		String bid1 = up.getValueOf("出价");
		String enterprice1 = up.getValueOf("买入价格");
		String endingprice1 = up.getValueOf("卖出价格");
		boolean valibate = (bid.equals(bid1) && enterprice.equals(enterprice1) && endingprice.equals(endingprice1));
		if(valibate)
			up.log("价格编辑框的值重新变为文字对手价,下方买入按钮和卖出按钮上显示的价格分别为行情卖档价格和买档价格");
		Assert.assertTrue(valibate);
	}
}
