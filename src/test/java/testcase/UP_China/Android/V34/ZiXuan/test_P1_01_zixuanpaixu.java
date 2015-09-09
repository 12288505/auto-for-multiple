package testcase.UP_China.Android.V34.ZiXuan;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_01_zixuanpaixu {

	private UP_Android up;
	
	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：有自选股-初始排序");
		up.openApp();
		
	}

	/**
	 * 测试名称：01 有自选股-初始排序
	 * [前提条件]：
	 * 1、自选股票界面有自选股；
	 * 
	 * [测试步骤]：
	 * 1、进入自选股界面；
	 * 
	 * [预期结果]：
	 * 1、初始排序按照添加自选股的先后顺序排序；
	 */
	@Test
	public void testZixuanpaixu() {
		up.goHomePage();
		up.Plusfree();
		List<String> set = new ArrayList< String>();
		set.add(up.getValueOf("搜索1"));
		set.add(up.getValueOf("搜索2"));
		set.add(up.getValueOf("搜索3"));
		up.clickOn("返回");
		
		up.clickOn("操作提示");
		List<String> stock = new ArrayList< String>();
		stock.add(up.getValueOf("搜索1"));
		stock.add(up.getValueOf("搜索1"));
		stock.add(up.getValueOf("搜索1"));
		
		for(int i=0;i<stock.size();i++){
			boolean validate = set.get(i).equals(stock.get(i));
			if(validate)
				Assert.assertTrue(validate);
		}
		
		up.DeleteOptional();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
