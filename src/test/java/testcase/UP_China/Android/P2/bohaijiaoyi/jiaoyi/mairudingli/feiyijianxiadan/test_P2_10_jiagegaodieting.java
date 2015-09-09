package testcase.UP_China.Android.P2.bohaijiaoyi.jiaoyi.mairudingli.feiyijianxiadan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_10_jiagegaodieting {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：委托价格高于跌停价");
		up.openApp();

	}

	/**
	 * 测试名称：10 委托价格高于跌停价
	 * [前提条件]：
	 * 1、在交易时间内
	 * 2、资金充足
	 * [测试步骤]：
	 * 1、选择委托类型为订立
	 * 2、在委托价格编辑框输入涨停价
	 * 3、点击价格编辑框右侧的加号按钮
	 * 4、在委托数量编辑框输入可以立马成交的委托数量（如默认数量）
	 * 5、点击买入按钮
	 * 6、点击委托确认对话框上的确定按钮
	 * [预期结果]：
	 * 1、step5执行完之后：弹出委托确认对话框，委托确认对话框展示商品，方向，数量，价格四个字段，下方展示确定和取消按钮，商品字段显示品种名称，方向显示买入 订立，数量显示委托数量，价格显示委托价格
	 * 2、step6执行完之后：弹出提示 委托价格超出涨幅上限
	 */
	@Test
	public void testJiagegaodieting() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
