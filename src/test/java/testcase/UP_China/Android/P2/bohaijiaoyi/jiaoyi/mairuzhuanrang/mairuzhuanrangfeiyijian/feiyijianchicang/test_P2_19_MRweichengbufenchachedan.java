package testcase.UP_China.Android.P2.bohaijiaoyi.jiaoyi.mairuzhuanrang.mairuzhuanrangfeiyijian.feiyijianchicang;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_19_MRweichengbufenchachedan {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：全部未成交-平部分-查撤单");
		up.openApp();

	}

	/**
	 * 测试名称：19 全部未成交-平部分-查撤单
	 * [前提条件]：
	 * 1、在交易时间内
	 * 2、资金充足
	 * 3、所转让的品种有卖订类型的仓单；
	 * [测试步骤]：
	 * 1、点击某品种的卖订仓单的平仓按钮
	 * 2、在委托价格编辑框输入可以委托成功但不能立马成交的委托价格（如低于对手价的价格）
	 * 3、在委托数量编辑框输大于零小于卖可转数量的值
	 * 4、点击买入按钮；
	 * 5、点击委托成功提示对话框上的确定按钮
	 * 5、点击委托确认对话框的确认按钮
	 * 6、点击委托成功对话框的确定按钮
	 * 7、点击底部导航栏撤单标签
	 * 
	 * [预期结果]：
	 * 1、界面切换到撤单界面
	 * 2、撤单界面最新一单显示已委托未成交的单子，即本次所下的单；
	 * 3、类型显示买入转让，可撤量显示委托数量，价格显示委托价格
	 * 4、时间显示委托时间
	 */
	@Test
	public void testMRweichengbufenchachedan() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
