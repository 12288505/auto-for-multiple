package testcase.UP_Metal.Android.P1.BaiBaoXiang;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UPMetal_Android;

public class test_P1_03_caijingliebiao {

	private UPMetal_Android up;

	@BeforeClass
	public void setUP() {

		up = new UPMetal_Android();
		up.log("开始测试：列表中数据数量是否正确");
		up.openApp();
	}

	/**
	 * 测试名称：03 列表中数据数量是否正确
	 * [测试步骤]：
	 * 1、与PC端比较列表数据的条数
	 * [预期结果]：
	 * 1、数据的条数和PC端一致
	 */
	@Test
	public void testCaijingliebiao() {

		up.goHomePage();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
