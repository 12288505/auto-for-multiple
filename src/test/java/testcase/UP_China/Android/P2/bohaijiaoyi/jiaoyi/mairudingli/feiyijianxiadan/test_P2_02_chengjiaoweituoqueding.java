package testcase.UP_China.Android.P2.bohaijiaoyi.jiaoyi.mairudingli.feiyijianxiadan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_02_chengjiaoweituoqueding {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：全部成交-委托确认");
		up.openApp();

	}

	/**
	 * 测试名称：02 全部成交-委托确认
	 * [前提条件]：
	 * 1、在交易时间内下单；
	 * 2、资金充足
	 * [测试步骤]：
	 * 1、选择委托类型为订立
	 * 2、委托价格编辑框输入可以立马成交的委托价格（如对手价）
	 * 3、委托数量编辑框输入可以立马成交的委托数量（如默认数量）
	 * 4、点击买入按钮
	 * 5、点击委托确认对话框的确认按钮
	 * [预期结果]：；
	 * 1、弹出委托成功对话框；
	 * 2、委托成功对话提示：委托成功！
	 * 3、委托成功提示对话框下方显示确定按钮
	 */
	@Test
	public void testChengjiaoweituoqueding() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
