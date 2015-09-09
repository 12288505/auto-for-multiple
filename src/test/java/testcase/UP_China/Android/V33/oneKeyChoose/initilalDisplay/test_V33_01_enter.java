package testcase.UP_China.Android.V33.oneKeyChoose.initilalDisplay;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_V33_01_enter {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：入口");
		up.openApp();
	}

	/**
	 * 测试名称：01 入口
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、首页－选股－一键选股（列表中最上面一条Tab）
	 * [预期结果]：
	 * 1、跳至｛一键选股｝
	 */
	@Test
	public void test010Demo() {

		up.goHomePage();

		up.verifyIsShown("选股");
		up.clickOn("选股");

		up.verifyIsShown("一键选股");
		up.clickOn("一键选股");
		up.verifyIsShown("形态");
		up.verifyIsShown("特色");
		up.verifyIsShown("经典");
		up.verifyIsShown("用户");
		up.verifyIsShown("名家");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
