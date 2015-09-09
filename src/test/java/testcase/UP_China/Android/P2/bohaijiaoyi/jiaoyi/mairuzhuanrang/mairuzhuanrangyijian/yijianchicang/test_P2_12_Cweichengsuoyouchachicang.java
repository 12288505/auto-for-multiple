package testcase.UP_China.Android.P2.bohaijiaoyi.jiaoyi.mairuzhuanrang.mairuzhuanrangyijian.yijianchicang;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_12_Cweichengsuoyouchachicang {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：全部未成交-平所有-查持仓");
		up.openApp();

	}

	/**
	 * 测试名称：12 全部未成交-平所有-查持仓
	 * [前提条件]：
	 * 1、在交易时间内
	 * 2、资金充足
	 * 3、所转让的品种有卖订类型的仓单；
	 * [测试步骤]：
	 * 1、点击某品种的卖订仓单的平仓按钮
	 * 2、在委托价格编辑框输入不能立马成交的委托价格（如低于对手价的价格）
	 * 3、在委托数量编辑框输入卖可转数量；
	 * 4、点击买入按钮
	 * 5、点击委托成功提示对话框上的确定按钮
	 * 6、点击底部导航栏持仓标签
	 * [预期结果]：
	 * 1、界面切换到持仓界面
	 * 2、持仓中所转让的品种卖订类型的仓单订货量没有变；
	 */
	@Test
	public void testCweichengsuoyouchachicang() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
