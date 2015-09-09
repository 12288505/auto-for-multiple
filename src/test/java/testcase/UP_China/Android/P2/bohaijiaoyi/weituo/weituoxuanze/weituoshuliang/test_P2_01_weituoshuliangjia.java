package testcase.UP_China.Android.P2.bohaijiaoyi.weituo.weituoxuanze.weituoshuliang;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_01_weituoshuliangjia {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：");
		up.openApp();

	}

	/**
	 * 测试名称：01 委托数量-加
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、点击数量编辑框右侧的加号按钮
	 * [预期结果]：
	 * 1、委托数量加1；
	 */
	@Test
	public void testWeituoshuliangjia() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
