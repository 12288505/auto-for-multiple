package testcase.UP_China.Android.P2.bohaijiaoyi.jiaoyi.maichuzhuanrang.zhuangrangyijianxiadan.chicangjiemian;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_08_chengjiaobufenchachicangCCJM {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：全部可成交-平部分-查持仓");
		up.openApp();

	}

	/**
	 * 测试名称：08 全部可成交-平部分-查持仓
	 * [前提条件]：
	 * 1、在交易时间内
	 * 2、资金充足
	 * 3、所转让的品种有买订类型的仓单；
	 * [测试步骤]：
	 * 1、点击某品种的买订仓单的平仓按钮
	 * 、在委托价格编辑框输入可以立马成交的委托价格（如对手价）
	 * 3、在委托数量编辑框输入大于零小于买可转数量的值
	 * 4、点击卖出按钮
	 * 5、点击委托成功提示对话框上的确定按钮
	 * 6、点击底部导航栏持仓标签
	 * [预期结果]：
	 * 1、界面切换到持仓界面
	 * 2、持仓中所转让的品种买订仓单的订货量减少的数值等于委托数量；
	 */
	@Test
	public void testChengjiaobufenchachicangCCJM() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
