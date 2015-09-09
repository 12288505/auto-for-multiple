package testcase.UP_Metal.Android.P1.BaiBaoXiang;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UPMetal_Android;

public class test_P1_04_shujuzhanshi {

	private UPMetal_Android up;

	@BeforeClass
	public void setUP() {

		up = new UPMetal_Android();
		up.log("开始测试：数据展示");
		up.openApp();
	}

	/**
	 * 测试名称：04 数据展示
	 * [测试步骤]：
	 * 1、查看手机端数据解读页面
	 * 2、与PC端比较本条数据解读
	 * [预期结果]：
	 * 1、文章标题，下次发布，发布频率，发布机构，数据释义，关注原因，历史数据均与PC端一致；
	 */
	@Test
	public void testShujuzhanshi() {

		up.goHomePage();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
