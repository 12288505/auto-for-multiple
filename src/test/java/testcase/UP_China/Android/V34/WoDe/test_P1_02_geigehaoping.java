package testcase.UP_China.Android.V34.WoDe;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_02_geigehaoping {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：安装一个软件市场给个好评");
		up.openApp();
	}

	/**
	 * 测试名称：02 安装一个软件市场给个好评
	 * [前提条件]：
	 * 1、手机中仅安装了一个软件市场
	 * [测试步骤]：
	 * 1、进入我的界面
	 * 2、点击给个好评
	 * [预期结果]：
	 * 1、打开软件市场对应的优品金融终端页面
	 */
	@Test
	public void testGeigehaoping() {

		up.goHomePage();
		
		up.verifyIsShown("跳转我的");
		up.clickOn("跳转我的");
		up.clickOn("登录导航");
		
		up.verifyIsShown("给个好评");
		up.clickOn("给个好评");
		
		up.verifyIsShown("标题");
		up.verifyIsShown("打开");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
