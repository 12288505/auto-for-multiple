package testcase.UP_China.Android.V34.FaXian.JiaoHu;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_01_dingyue {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：订阅所有内容");
		up.openApp();
	}

	/**
	 * 测试名称：01 订阅所有内容
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、进入【发现】->【百宝箱】
	 * 2、点击订阅所有内容
	 * 3、进入我的订阅检查订阅内容
	 * [预期结果]：
	 * 1、所有栏目后的订阅按钮变为取消订阅
	 * 2、我的订阅界面显示所有的订阅的栏目
	 */
	@Test
	public void testDingyue() {

		up.goHomePage();

		up.verifyIsShown("跳转发现");
		up.clickOn("跳转发现");
		up.clickOn("发现导航");
		
		List<String> set = new ArrayList< String>();
		set.add(up.getValueOf("一键选股"));
		up.clickOn("订阅",1);
		set.add(up.getValueOf("涨停尖兵"));
		up.clickOn("订阅",1);
		set.add(up.getValueOf("短线狙击"));
		up.clickOn("订阅",1);
		set.add(up.getValueOf("操盘驱动"));
		up.clickOn("订阅",1);
		set.add(up.getValueOf("多赢驱动"));
		up.clickOn("订阅",1);
		set.add(up.getValueOf("基金重仓"));
		up.clickOn("订阅",1);
		set.add(up.getValueOf("社保重仓"));
		up.clickOn("订阅",1);
//		up.swipeUpToElement("明星分析师荐股");
		up.swipeToText("机构关注最高");
		set.add(up.getValueOf("QFII重仓"));
		up.clickOn("订阅",1);
		set.add(up.getValueOf("机构关注最高"));
		up.clickOn("订阅",1);
		set.add(up.getValueOf("明星分析师荐股"));
		up.clickOn("订阅",1);
		set.add(up.getValueOf("估值空间最大"));
		up.clickOn("订阅",1);
		
		up.verifyIsShown("我的订阅");
		up.clickOn("我的订阅");
		
		List<String> newset = new ArrayList< String>();
		newset.add(up.getValueOf("一键选股"));
		newset.add(up.getValueOf("涨停尖兵"));
		newset.add(up.getValueOf("短线狙击"));
		newset.add(up.getValueOf("操盘驱动"));
		newset.add(up.getValueOf("多赢驱动"));
		newset.add(up.getValueOf("基金重仓"));
		newset.add(up.getValueOf("社保重仓"));
		
		up.swipeUpToElement("估值空间最大");
		newset.add(up.getValueOf("QFII重仓"));
		newset.add(up.getValueOf("机构关注最高"));
		newset.add(up.getValueOf("明星分析师荐股"));
		newset.add(up.getValueOf("估值空间最大"));
		
		for(int i=0;i<newset.size();i++){
			boolean validate = set.get(i).equals(newset.get(i));
			if(validate)
				Assert.assertTrue(validate);
		}
		
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
