package testcase.UP_China.Android.P2.bohaijiaoyi.jiaoyi.mairuzhuanrang.mairuzhuanrangfeiyijian.feiyijianweituo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_12_Wtuoweichengsuoyouquxiao {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：全部未成交-平所有-委托取消");
		up.openApp();

	}

	/**
	 * 测试名称：12 全部未成交-平所有-委托取消
	 * 前提条件]：
	 * 1、在交易时间内下单；
	 * 2、资金充足
	 * 3、所转让的品种有卖订类型的仓单；
	 * [测试步骤]：
	 * 1、选择委托类型为转让
	 * 2、在委托价格编辑框输入可以委托成功但不能立马成交的委托价格（如低于对手价的价格）
	 * 3、在委托数量编辑框输卖可转数量
	 * 4、点击买入按钮
	 * 5、点击委托确认对话框的取消按钮
	 * [预期结果]：；
	 * 1、界面恢复为委托界面
	 */
	@Test
	public void testWtuoweichengsuoyouquxiao() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
