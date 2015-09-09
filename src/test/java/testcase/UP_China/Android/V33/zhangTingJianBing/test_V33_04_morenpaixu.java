package testcase.UP_China.Android.V33.zhangTingJianBing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_V33_04_morenpaixu {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：默认排序 ");
		up.openApp();
	}

	/**
	 * 测试名称：07 默认排序
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、进入【选股】->【股票池】->【涨停尖兵】
	 * 2、切换到冲刺界面
	 * 2、查看冲刺界面默认排序
	 * 
	 * [预期结果]：
	 * 1、冲刺界面按照当日涨幅降序排序
	 * 2、冲刺界面当日涨幅字段右侧默认有向下的箭头
	 */
	@Test
	public void test010Demo() {

		up.goHomePage();
		up.verifyIsShown("选股");
		up.clickOn("选股");

		up.verifyIsShown("涨停尖兵");
		up.clickOn("涨停尖兵");

		up.verifyIsShown("涨停尖兵标题");
		up.clickOn("冲刺");

		up.verifyIsShown("当日涨幅↓");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
