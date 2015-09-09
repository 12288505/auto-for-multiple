package testcase.UP_China.Android.V34.ZiXuan;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_02_zijiaxuan {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：点击搜索图标添加自选股票");
		up.openApp();
	}

	/**
	 * 测试名称：02 点击搜索图标添加自选股票
	 * [前提条件]：
	 * 1、自选股票界面无自选股；
	 * 
	 * [测试步骤]：
	 * 1、点击右上角搜索图标，进入搜索页面；
	 * 2、输入代码/拼音首字母进行搜索；
	 * 3、点击搜索结果右侧加号；
	 * 4、返回自选股票页面；
	 * 
	 * [预期结果]：
	 * 1、步骤三执行后，加号变成对钩，【加自选】字样变为【已添加】，界面提示添加成功；
	 * 2、步骤四执行后，自选股票页面有该股；
	 */
	@Test
	public void testZijiaxuan() {

		up.goHomePage();
		up.Plusfree();
		
		up.getValueOf("搜索1");
		up.getValueOf("搜索2");
		up.getValueOf("搜索3");
		up.clickOn("返回");
		
		up.clickOn("操作提示");
		up.getValueOf("股票名称1");
		up.getValueOf("股票名称2");
		up.getValueOf("股票名称3");
		
		boolean validate = up.getValueOf("股票名称1").equals(up.getValueOf("搜索1")) &&  up.getValueOf("股票名称2").equals(up.getValueOf("搜索2")) &&  up.getValueOf("股票名称3").equals(up.getValueOf("搜索3"));
		if(validate)
			Assert.assertTrue(validate);
		
		up.DeleteOptional();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
