package testcase.UP_China.Android.P2.bohaijiaoyi.jiaoyi.maichuzhuanrang.zhuangrangyijianxiadan.weituojiemian;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_10_weichengsuoyouchachedanWTJM {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：全部未成交-平所有-查撤单");
		up.openApp();

	}

	/**
	 * 测试名称：10 全部未成交-平所有-查撤单
	 * [前提条件]：
	 * 1、在交易时间内
	 * 2、资金充足
	 * 3、所转让的品种有买订类型的仓单；
	 * [测试步骤]：
	 * 1、选择委托类型为订立
	 * 2、在委托价格编辑框输入不能立马成交的委托价格（如比对手价高的价格）
	 * 3、在委托数量编辑框输入买可转数量
	 * 4、点击卖出按钮；
	 * 5、点击委托成功提示对话框上的确定按钮
	 * 6、点击底部导航栏撤单标签
	 * 
	 * [预期结果]：
	 * 1、界面切换到撤单界面
	 * 2、撤单界面最新一单显示已委托未成交的单子，即本次所下的单；
	 * 3、类型显示卖出转让，可撤量显示委托数量（买可转数量），价格显示委托价格
	 * 4、时间显示委托时间
	 */
	@Test
	public void testDataRefresh() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
