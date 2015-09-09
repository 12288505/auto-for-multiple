package testcase.UP_China.Android.P1.Wode;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_03_AlarmManager {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：预警管理");
		up.openApp();

	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
/*	
 * 测试名称：编辑页点击完成按钮跳转至管理页面
 * [测试步骤]：
 * 	1、点击【我的】->【预警管理】
 * 	2、点击右上角编辑按钮
 * 	3、删除或不删除预警项后，点击右上角完成按钮
 * 	[预期结果]：
 * 	1、跳转到预警管理页面
 * 	2、未删除预警项显示正确，已删除预警项不显示；
 	*/
	@Test
	public void testModifyPassword() {

		up.goHomePage();
		
		up.login();
		up.removeAlert();
		up.clickOn("跳转行情");
		
		//添加第一条预警
		up.verifyIsShown("涨股1");
		up.clickOn("涨股1");		
		up.clickOn("操作提示");
		up.clickOn("预警");		
		up.verifyIsShown("涨幅输入");
		up.setValueTo("涨幅输入","1");
		up.clickOn("提交");
		
//		up.swipe(9,3,1,3);
		up.verifyIsShown("返回");
		up.clickOn("返回");
		up.verifyIsShown("行情");
		
		//添加第二条预警
		up.log(up.getValueOf("渤海"));
		up.verifyIsShown("涨股2");
		up.clickOn("涨股2");		
		up.clickOn("预警");		
		up.verifyIsShown("涨幅输入");
		up.setValueTo("涨幅输入","1");
		up.clickOn("提交");
		
		up.verifyIsShown("返回");
		up.clickOn("返回");
		
		up.verifyIsShown("跳转我的");
		up.clickOn("跳转我的");
		
		up.verifyIsShown("预警管理");
		up.clickOn("预警管理");
		
		up.verifyIsShown("编辑");
		up.clickOn("编辑");
		
		up.verifyIsShown("预警2");
		up.clickOn("预警2");
		up.verifyIsShown("删除");
		up.clickOn("删除");
		up.clickOn("是");
		up.clickOn("完成");
		
		up.verifyIsShown("编辑");
		up.verifyIsNotShown("预警2");
		up.verifyIsShown("预警1");
		
		
		

//		
//		
//		
//		
//		up.login();		
//		up.verifyIsShown("预警管理");
//		up.clickOn("预警管理");
		

	}
}
