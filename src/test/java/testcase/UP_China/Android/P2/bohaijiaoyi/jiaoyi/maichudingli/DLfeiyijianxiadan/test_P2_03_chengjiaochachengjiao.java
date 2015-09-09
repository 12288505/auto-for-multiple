package testcase.UP_China.Android.P2.bohaijiaoyi.jiaoyi.maichudingli.DLfeiyijianxiadan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_03_chengjiaochachengjiao {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：全部成交-查成交");
		up.openApp();

	}

	/**
	 * 测试名称：03 全部成交-查成交
	 * [[前提条件]：
	 * 1、在交易时间内
	 * 2、资金充足
	 * [测试步骤]：
	 * 1、选择委托类型为订立
	 * 2、在委托价格编辑框输入可以立马成交的委托价格（如对手价）
	 * 3、在委托数量编辑框输入可以立马成交的委托数量（如默认数量）
	 * 4、点击卖出按钮
	 * 5、点击委托确认对话框的确认按钮
	 * 6、点击委托成功对话框的确定按钮
	 * 7、点击查成交标签
	 * [预期结果]：
	 * 1、查询界面切换到查成交；
	 * 2、本次所下单分一条或多条显示在成交列表中
	 * 3、成交列表中本次所成交的单类型字段显示卖出订立，数量显示小于或等于委托数量，但总和等于委托数量，价格显示委托价格，转让盈亏为0.00；
	 * 4、委托时间显示下单时间；
	 */
	@Test(dependsOnGroups = "Bohai time")
	public void testChengjiaochachengjiao() {

		up.goHomePage();
		up.verifyIsShown("自选");
		up.goToHeader("渤海交易");
		up.login_BH();

		up.verifyIsShown("订立");
		up.clickOn("订立");
		up.clickOn("出价");
		up.sendNum(up.getValueOf("买入价格"));
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
		
		up.verifyIsShown("名称");
		up.verifyIsShown("委托时间");
		up.verifyIsShown("类型");
		up.verifyIsShown("数量");
		up.verifyIsShown("转让盈亏");
		up.verifyIsShown("成交价格");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
