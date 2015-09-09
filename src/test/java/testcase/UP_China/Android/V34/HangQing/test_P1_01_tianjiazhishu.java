package testcase.UP_China.Android.V34.HangQing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_01_tianjiazhishu {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：添加指数");
		up.openApp();
	}

	/**
	 * 测试名称：01 添加指数
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、进入【行情】->【指数】
	 * 2、点击+点击添加按钮
	 * 3、在编辑指数界面选中几只未添加的指数
	 * 4、点击返回按钮
	 * 5、在指数综合屏查看指数内容
	 * [预期结果]：
	 * 1、step3执行完：选中的指数后显示钩钩，底部显示已选择的个数
	 * 2、step5执行完：添加的指数显示在国内指数栏
	 */
	@Test
	public void testTianjiazhishu() {

		up.goHomePage();
		up.verifyIsShown("跳转行情");
		up.clickOn("跳转行情");
		
		up.verifyIsShown("行情指数");
		up.clickOn("行情指数");
		
		up.verifyIsShown("点击添加");
		up.clickOn("点击添加");
		
		up.verifyIsShown("编辑指数");

		up.clickOn("指数内容",11);
		up.clickOn("编辑指数返回");
		
		up.clickOn("点击添加");
		up.clickOn("指数内容",11);
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
