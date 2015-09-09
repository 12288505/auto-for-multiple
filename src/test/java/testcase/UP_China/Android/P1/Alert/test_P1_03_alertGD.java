package testcase.UP_China.Android.P1.Alert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_03_alertGD {

	/**
	 * TODO
	 */
	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：验证推送消息-广东贵金属涨停预警被触发");
		up.openApp();
	}

	/**
	 * 测试名称：01 验证推送消息-广东贵金属涨停预警被触发
	 * [前提条件]：
	 * 1、设置接受的股价涨预警；
	 * 2、当前股价达到预警条件
	 * 
	 * [测试步骤]：
	 * 路径：底部的我的-消息中心-推送内容
	 * 1、查看推送消息
	 * 
	 * [预期结果]：
	 * 1、用户中心接收到推送消息
	 */
	@Test
	public void testAlertStockMarket() {

		up.goHomePage();
		up.login();
		up.removeAlert();
		up.clickOn("跳转行情");
		up.clickOn("贵金属");
		up.clickOn("粤贵银");

		up.clickOn("操作提示");
		up.clickOn("预警");

		String nowPriceStr = up.getValueOf("预警现价");
		double nowPrice = Double.parseDouble(nowPriceStr);
		double alertHighPrice = nowPrice + 15;
		up.setValueTo("股价高于", Double.toString(alertHighPrice));

		double alertLowPrice = nowPrice - 15;
		up.setValueTo("股价低于", Double.toString(alertLowPrice));

		up.clickOn("提交");
		up.verifyIsShown("标题");

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
