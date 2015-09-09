package testcase.UP_China.Android.P1.BoHaiJiaoYi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_03_searchAll {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：品种代码搜索-完整匹配");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：品种代码搜索-完整匹配
	 * [前提条件]：
	 * 1、进入品种搜索界面
	 * [测试步骤]：
	 * 1、输入某品种的代码（如苹果烟台输入：BAPYT）
	 * 2、
	 * [预期结果]：
	 * 1、搜索结果列表显示对应代码的品种名称和代码；
	 */
	@Test
	public void testSearchAll() {

		up.goHomePage();

		up.verifyIsShown("自选");
		up.verifyIsShown("沪深股票");
		up.verifyIsShown("渤海商品");
		up.goToHeader("渤海交易");

		up.login_BH();

		up.verifyIsShown("标题");
		up.verifyIsShown("搜索");
		up.verifyIsShown("搜索按钮");

		up.clickOn("搜索按钮");

		up.verifyIsShown("委托下单");
		up.verifyIsShown("搜索按钮");
		up.verifyIsShown("返回1");
		up.verifyIsShown("搜索");

		up.clickOn("搜索");
		up.sendB();
		up.sendA();
		up.sendP();
		up.sendY();
		up.sendT();

		up.verifyIsShown("名称1");
		up.verifyIsShown("代码1");
	}
}
