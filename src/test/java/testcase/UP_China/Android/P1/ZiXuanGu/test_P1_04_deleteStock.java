package testcase.UP_China.Android.P1.ZiXuanGu;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_04_deleteStock {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.openApp();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：通过自选编辑删除自选股
	 * 测试步骤:
	 * 前提：
	 * 1、自选股列表有多只自选股
	 * 步骤：
	 * 1、进入自选股编辑页面；
	 * 2、点击多个要删除的股票左侧的对钩；
	 * 3、点击右下角删除图标；
	 * 4、点击左上角【完成】；
	 * 期望结果：
	 * 1、步骤二执行后，对钩变为橙色，底部出现已选择n个，右下角有删除图标；
	 * 2、步骤三执行后，该自选股票在列表页消失，页面提示：您已成功删除自选；
	 * 3、步骤四执行后，返回到自选股列表页面，列表无已删除股票；
	 */

	@Test
	public void testDeleteStock() {

		up.log("开始测试：通过搜索栏添加自选股票");
		up.goHomePage();
		up.verifyIsShown("跳转自选");
		up.clickOn("跳转自选");

		up.clickOn("自选提示");
		up.clickOn("搜索");
		up.clickOn("0");
		up.verifyIsShown("加自选");
		up.clickOn("加自选");
		up.verifyIsShown("加自选");
		up.clickOn("加自选");
		up.verifyIsShown("已添加");

		String result = up.getValueOf("搜索1");
		up.clickOn("返回");

		up.clickOn("编辑");
		up.clickOn("勾选1");
		up.clickOn("删除");
		up.clickOn("完成删除");

		up.verifyIsNotShown(result);
	}
}
