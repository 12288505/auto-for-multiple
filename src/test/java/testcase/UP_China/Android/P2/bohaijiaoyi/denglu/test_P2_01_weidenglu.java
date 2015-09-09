package testcase.UP_China.Android.P2.bohaijiaoyi.denglu;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_01_weidenglu {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：品种分析页入口-未登录");
		up.openApp();

	}

	/**
	 * 测试名称：01 品种分析页入口-未登录
	 * [前提条件]：
	 * 1.未登录渤海交易
	 * [测试步骤]：
	 * 1、进入渤海商品任一品种分析页（如：苹果烟台）
	 * 2、点击标题栏右侧的方形图标
	 * 3、在方形图标下拉菜单中点击交易按钮
	 * [预期结果]：
	 * 1、进入渤海交易登录界面
	 */
	@Test
	public void testWeidenglu() {

		up.goHomePage();
		up.verifyIsShown("渤海商品");
		up.clickOn("渤海商品");
		up.verifyIsShown("渤海3名称");
		up.clickOn("渤海3名称");
		up.clickOn("操作提示");
		up.verifyIsShown("交易");
		up.clickOn("交易");
		up.verifyIsShown("登录标题");
		up.verifyIsShown("帐号");
		up.verifyIsShown("密码");
		up.verifyIsShown("帐号登录");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
