package testcase.UP_China.Android.P2.bohaijiaoyi.weituo.fuwei;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P2_05_fuweishuliangzhuanrang {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：委托类型数量复位-转让 任意值");
		up.openApp();

	}

	/**
	 * 测试名称：05 委托类型数量复位-转让 任意值
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、切换委托类型为转让
	 * 2、在数量编辑框输入一个任意数值
	 * 3、点击复位按钮
	 * [预期结果]：
	 * 1、step1执行完之后：委托类型变为转让；
	 * 2、step2执行完之后：数量编辑框数值变为所输入的数值
	 * 3、step3执行完之后：委托类型恢复为订立，数量编编辑框中的值恢复为默认的1
	 */
	@Test
	public void testFuweishuliangzhuanrang() {

		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

}
