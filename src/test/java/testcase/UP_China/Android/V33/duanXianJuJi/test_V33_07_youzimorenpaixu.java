package testcase.UP_China.Android.V33.duanXianJuJi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;


public class test_V33_07_youzimorenpaixu {
	private UP_Android up;
	@BeforeClass
	public void setUp(){
		up = new UP_Android();
		up.log("开始测试:默认排序");
		up.openApp();
	}

	/**
	 * 测试名称：07 默认排序
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、进入【选股】->【股票池】->【游资出击】
	 * 2、查看有庄操作界面默认排序
	 * 
	 * [预期结果]：
	 * 1、有庄操作界面按照当日涨幅降序排序
	 * 2、有庄操作界面当日涨幅字段右侧默认有向下的箭头
	 */
	@Test
	public void testYouzimorenpaixu() {

		up.goHomePage();
		up.verifyIsShown("选股");
		up.clickOn("选股");
		up.verifyIsShown("短线狙击");
		up.clickOn("短线狙击");
		up.verifyIsShown("游资出击");
		up.clickOn("游资出击");
		up.log(up.getValueOf("当日涨幅↓"));
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
