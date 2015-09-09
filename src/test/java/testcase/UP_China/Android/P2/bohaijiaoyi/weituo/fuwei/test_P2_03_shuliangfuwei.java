package testcase.UP_China.Android.P2.bohaijiaoyi.weituo.fuwei;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_03_shuliangfuwei {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：数量复位-加操作");
		up.openApp();

	}

	/**
	 * 测试名称：03 数量复位-加操作
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、单击数量编辑框右侧的加号按钮
	 * 2、单击复位按钮
	 * [预期结果]：
	 * 1、step1执行完之后，数量编辑框数值加1；
	 * 2、step2执行完之后，数量编辑框数值恢复为默认1；
	 */
	@Test
	public void testShuliangfuwei() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
