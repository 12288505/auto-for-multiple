package testcase.UP_China.Android.P2.bohaijiaoyi.jiaoyi.mairudingli.feiyijianxiadan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_01_chengjiaoxiadan {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：全部成交-下单确认");
		up.openApp();

	}

	/**
	 * 测试名称：01 全部成交-下单确认
	 * [前提条件]：
	 * 1、在交易时间内下单；
	 * 2、资金充足
	 * [测试步骤]：
	 * 1、选择委托类型为订立
	 * 2、委托价格编辑框输入可以立马成交的委托价格（如对手价）
	 * 3、委托数量编辑框输入可以立马成交的委托数量（如默认数量）
	 * 4、点击买入按钮
	 * [预期结果]：；
	 * 1、弹出委托确认对话框；
	 * 2、委托确认对话框标题显示委托确认
	 * 3、委托确认对话框正文一次显示商品、方向，数量、价格字段；
	 * 4、商品字段显示商品名称，方向显示买入订立，数量字段显示委托数量，价格为委托价格；
	 * 5、对话框底部显示确定按钮和取消按钮
	 */
	@Test
	public void testChengjiaoxiadan() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
