package testcase.UP_China.Android.P2.bohaijiaoyi.jiaoyi.mairudingli.feiyijianxiadan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_04_qubuchengjiaochachicang {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：全部成交-查持仓");
		up.openApp();

	}

	/**
	 * 测试名称：04 全部成交-查持仓
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
	 * 7、点击底部导航栏持仓标签
	 * [预期结果]：
	 * 1、界面切换到持仓界面
	 * 2、持仓中所下单品种的买入订立单订货量增加的数值等于委托数量
	 */
	@Test
	public void testQubuchengjiaochachicang() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
