package testcase.UP_China.Android.P1.BoHaiJiaoYi;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;


public class test_P1_08_notOneKeyBuy {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：全部成交-查委托");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：全部成交-查委托
	 * [前提条件]：
	 * 1、在交易时间内
	 * 2、资金充足
	 * [测试步骤]：
	 * 1、选择委托类型为订立
	 * 2、委托价格编辑框输入可以立马成交的委托价格（如对手价）
	 * 3、委托数量编辑框输入可以立马成交的委托数量（如默认数量）
	 * 4、点击买入按钮
	 * 5、点击委托确认对话框的确认按钮
	 * 6、点击委托成功对话框的确定按钮
	 * [预期结果]：
	 * 1、界面跳转到查询界面；
	 * 2、查询界面默认停留在查委托栏；
	 * 3、查委托最新一条显示进入查询前所下的那一单的信息；
	 * 4、类型字段显示买入订立，数量字段为委托数量，价格显示委托价格，状态显示全部成交，剩余为0；
	 * 5、委托时间显示下单时间；
	 */
	@Test(dependsOnGroups = "Bohai time")
	public void testDataRefresh() {

		up.goHomePage();
		
		up.verifyIsShown("自选");
		up.verifyIsShown("沪深股票");

		up.goToHeader("渤海交易");

		up.login_BH();
		
		up.verifyIsShown("订立");
		up.clickOn("订立");
		up.clickOn("出价");
		up.sendNum(up.getValueOf("买入价格"));
		up.tapOn(9.9, 9.9);
		up.waitByTimeout(1000);
		up.tapOn(9.9, 9.9);
		Float a1 = Float.parseFloat(up.getValueOf("出价"));
		Float a2 =  Float.parseFloat(up.getValueOf("订购数量"));
		
		up.verifyIsShown("买入");
		up.clickOn("买入");
		
		up.verifyIsShown("委托确定1");
		up.clickOn("委托确定1");
		
		up.verifyIsShown("委托确定2");
		up.clickOn("委托确定2");
		
		up.clickOn("操作提示");
		up.verifyIsShown("查委托");
		up.clickOn("查委托");
		
		up.verifyIsShown("名称");
		up.verifyIsShown("类型");
		up.verifyIsShown("状态");
		up.verifyIsShown("数量");
		up.verifyIsShown("剩余量");
		up.verifyIsShown("价格");
		
		up.log(up.getValueOf("数量"));
		up.log(up.getValueOf("价格"));
		
		Float b1 = Float.parseFloat(up.getValueOf("数量"));
		Float b2 =  Float.parseFloat(up.getValueOf("价格"));
		boolean validate = (a1.equals(b2) && a2.equals(b1));
		if(validate)
			up.log("订立成功");
		Assert.assertTrue(validate);
		up.cheDan();
	}
}
