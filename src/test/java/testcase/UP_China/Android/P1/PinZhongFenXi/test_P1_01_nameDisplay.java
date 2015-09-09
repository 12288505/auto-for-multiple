package testcase.UP_China.Android.P1.PinZhongFenXi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_01_nameDisplay {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：有行情时名称代码显示");
		up.openApp();
	}

	/**
	 * 测试名称：有行情时名称代码显示
	 * [前提条件]：
	 * 1、品种有行情
	 * 2、网络环境为wifi网络
	 * 
	 * [测试步骤]：
	 * 路径：底部的行情-更多-沪深A股-任一股票
	 * 1、查看品种名称及代码；
	 * 
	 * [预期结果]：
	 * 1、对照行情列表查看显示正确；
	 * 2、对照PC端查看显示正确；
	 */
	@Test
	public void testNameDisplay() {

		up.goHomePage();
		
		up.goToStock();
		
		up.verifyIsShown("品种名称");
		up.verifyIsShown("品种代码");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
