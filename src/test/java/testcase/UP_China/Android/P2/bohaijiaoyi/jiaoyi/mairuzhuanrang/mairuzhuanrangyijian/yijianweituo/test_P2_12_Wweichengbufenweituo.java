package testcase.UP_China.Android.P2.bohaijiaoyi.jiaoyi.mairuzhuanrang.mairuzhuanrangyijian.yijianweituo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_12_Wweichengbufenweituo {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：全部未成交-平部分-委托确认");
		up.openApp();

	}

	/**
	 * 测试名称：12 全部未成交-平部分-委托确认
	 * [前提条件]：
	 * 1、在交易时间内下单；
	 * 2、资金充足
	 * 3、所转让的品种有卖订类型的仓单；
	 * [测试步骤]：
	 * 1、选择委托类型为转让
	 * 2、在委托价格编辑框输入不能立马成交的委托价格（如低于对手价的价格）
	 * 3、在委托数量编辑框输入大于零小于卖可转数量的值
	 * 4、点击买入按钮
	 * [预期结果]：；
	 * 1、弹出委托成功对话框；
	 * 2、委托成功对话提示：委托成功！
	 * 3、委托成功提示对话框下方显示确定按钮
	 */
	@Test
	public void testWweichengbufenweituo() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
