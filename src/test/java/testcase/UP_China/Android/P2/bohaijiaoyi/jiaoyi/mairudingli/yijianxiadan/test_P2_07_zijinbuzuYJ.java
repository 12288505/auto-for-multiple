package testcase.UP_China.Android.P2.bohaijiaoyi.jiaoyi.mairudingli.yijianxiadan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_07_zijinbuzuYJ {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：资金不足");
		up.openApp();

	}

	/**
	 * 测试名称：07 资金不足
	 * [前提条件]：
	 * 1、在交易时间内
	 * [测试步骤]：
	 * 1、选择委托类型为订立
	 * 2、在委托价格编辑框输入可以立马成交的委托价格（如对手价）
	 * 3、在委托数量编辑框输入大于可订买数量的委托数量
	 * 4、点击买入按钮
	 * [预期结果]：
	 * 1、弹出提示：资金余额不足
	 */
	@Test
	public void testZijinbuzuYJ() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
