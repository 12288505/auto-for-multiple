package testcase.UP_China.Android.V34.ZiXuan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_03_shanzixuan {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：自选股编辑删除多个自选股");
		up.openApp();
	}

	/**
	 * 测试名称：03 自选股编辑删除多个自选股
	 * [前提条件]：
	 * 1、自选股票界面有自选股；
	 * 
	 * [测试步骤]：
	 * 1、进入自选股编辑页面；
	 * 2、点击一个要删除的股票左侧的对钩；
	 * 3、点击右下角图标；
	 * 4、点击多个要删除的股票左侧的对钩，点击右下角图标；
	 * 5、点击左上角【完成】；
	 * 
	 * [预期结果]：
	 * 1、步骤二执行后，对钩变为橙色，底部出现已选择1个，右下角有删除图标；
	 * 2、步骤三执行后，该自选股票在列表页消失，页面提示：您已成功删除自选；
	 * 3、步骤四执行后，多个选中自选股票在列表页消失：页面提示：您已成功删除自选；
	 * 4、步骤五执行后，返回到自选股列表页面，列表无已删除股票；
	 */
	@Test
	public void testShanzixuan() {

		up.goHomePage();
		up.Plusfree();
		up.clickOn("返回");
		
		up.clickOn("操作提示");
		up.clickOn("自选编辑");
		up.clickOn("勾选股票",1);
		up.clickOn("删除");
		up.clickOn("是");
		
		up.clickOn("勾选股票",1);
		up.clickOn("勾选股票",2);
		up.clickOn("删除");
		up.clickOn("是");
		up.verifyIsShown("完成");
		up.clickOn("完成");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
