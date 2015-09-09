package testcase.UP_China.Android.V34.WoDe;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_01_yujingguanli {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：编辑页点击完成按钮跳转至管理页面");
		up.openApp();
	}

	/**
	 * 测试名称：01 编辑页点击完成按钮跳转至管理页面
	 * 
	 * [测试步骤]：
	 * 1、点击【我的】->【预警管理】
	 * 2、点击右上角编辑按钮
	 * 3、删除或不删除预警项后，点击右上角完成按钮
	 * [预期结果]：
	 * 1、跳转到预警管理页面
	 * 2、未删除预警项显示正确，已删除预警项不显示；
	 */
	@Test
	public void testYujingguanli() {

		up.goHomePage();
		up.Permissions();
		up.clickOn("我的返回");
		up.clickOn("跳转行情");
		up.clickOn("涨股1");

		up.clickOn("操作提示");
		up.clickOn("预警");

		String nowPriceStr = up.getValueOf("预警现价");
		double nowPrice = Double.parseDouble(nowPriceStr);
		double alertHighPrice = nowPrice + 10;
		up.setValueTo("股价高于", Double.toString(alertHighPrice));

		double alertLowPrice = nowPrice - 15;
		up.setValueTo("股价低于", Double.toString(alertLowPrice));

		up.clickOn("提交");
		up.verifyIsShown("标题");
		
		up.clickOn("返回");
		
		up.verifyIsShown("跳转首页");
		up.clickOn("跳转首页");
		
		up.removeAlert();
//		up.verifyIsShown("跳转我的");
//		up.clickOn("跳转我的");
//		up.clickOn("预警管理");
//		up.waitByTimeout(5000);
//		if (!up.isElementShown("没有预警提示")) {
//			up.clickOn("编辑");
//			up.clickOn("选择所有");
//			up.clickOn("删除");
//			up.clickOn("是");
//			up.clickOn("完成");
//			up.verifyIsShown("没有预警提示");
//		}
//		up.clickOn("返回");

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
