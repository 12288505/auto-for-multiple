package testcase.UP_China.Android.P2.bohaijiaoyi.jiaoyi.mairudingli.yijianxiadan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_03_quanbuchengjiaochachicangYJ {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：全部成交-查持仓");
		up.openApp();

	}

	/**
	 * 测试名称：03 全部成交-查持仓
	 * [前提条件]：
	 * 1、在交易时间内
	 * 2、资金充足
	 * [测试步骤]：
	 * 1、选择委托类型为订立
	 * 2、在委托价格编辑框输入可以立马成交的委托价格（如对手价）
	 * 3、在委托数量编辑框输入可立马成交的委托数量（如默认数量）
	 * 4、点击买入按钮
	 * 5、点击委托成功提示对话框上的确定按钮
	 * 6、点击底部导航栏持仓标签
	 * [预期结果]：
	 * 1、界面切换到持仓界面
	 * 2、持仓中所下单品种的买入订立单订货量增加的数值等于委托数量
	 */
	@Test
	public void testQuanbuchengjiaochachicangYJ() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
