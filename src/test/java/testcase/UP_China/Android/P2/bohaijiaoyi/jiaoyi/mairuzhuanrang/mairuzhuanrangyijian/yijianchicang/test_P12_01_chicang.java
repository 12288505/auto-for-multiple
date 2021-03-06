package testcase.UP_China.Android.P2.bohaijiaoyi.jiaoyi.mairuzhuanrang.mairuzhuanrangyijian.yijianchicang;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P12_01_chicang {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：入口-平买入订立单");
		up.openApp();

	}

	/**
	 * 测试名称：01 入口-平买入订立单
	 * [前提条件]：
	 * 1、持仓中有品种
	 * 2、品种有买入订立单；
	 * [测试步骤]：
	 * 1、在持仓界面点击某品种买入订立单后的平仓按钮
	 * [预期结果]：
	 * 1、界面跳转到委托界面
	 * 2、搜索栏中的品种显示为在持仓总所点击的品种；
	 * 3、行情报价的区域变为搜索栏的品种的行情报价；
	 * 4、委托类型变为转让；
	 * 5、涨停价跌停价与该品种官方软件显示一致；
	 * 6、委托数量编辑框显示持仓中买入订立单的数量；
	 * 7、买可转数值变为持仓中该品种的买入订立单的数量；
	 * 8、卖可转数值变为持仓中该品种的卖出订立单的数值；
	 * 9、买入按钮显示行情卖档报价，卖出按钮显示行情买档报价；
	 */
	@Test
	public void testChicang() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
