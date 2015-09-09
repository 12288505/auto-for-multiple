package testcase.UP_China.Android.P2.bohaijiaoyi.weituo.weituoxuanze.weituoshuliang;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_02_weituoshuliangjian {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：委托数量-减（不低于1）");
		up.openApp();

	}

	/**
	 * 测试名称：02 委托数量-减（不低于1）
	 * [前提条件]：
	 * 1、委托数量为大于1的值
	 * [测试步骤]：
	 * 1、点击数量编辑框右侧的减号按钮
	 * [预期结果]：
	 * 1、委托数量减1；
	 */
	@Test
	public void testWeituoshuliangjian() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
