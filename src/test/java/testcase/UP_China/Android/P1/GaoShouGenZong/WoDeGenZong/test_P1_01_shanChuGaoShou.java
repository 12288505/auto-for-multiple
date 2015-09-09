package testcase.UP_China.Android.P1.GaoShouGenZong.WoDeGenZong;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_01_shanChuGaoShou {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：删除一位高手");
		up.openApp();
	}

	/**
	 * 测试名称：01 删除一位高手
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、进入【首页】->【股林高手】->【我的跟踪】
	 * 2、点击编辑
	 * 3、点击高手左侧圆圈删除图标
	 * 4、点击高手右侧删除
	 * 5、点击标题栏右侧完成按钮
	 * [预期结果]：
	 * 1、step3执行完：高手列表右侧出现删除按钮
	 * 2、step4执行完：当前删除的高手从我的跟踪列表删除
	 * 3、step5执行完：完成二字变为编辑二字，列表从正常态恢复为默认态（每行显示用户头像，昵称，赛盘性质，总收益率）删除的高手从我的跟踪列表删除；
	 */
	@Test
	public void testShanChuGaoShou() {

		up.goHomePage();
		up.verifyIsShown("股林高手");
		up.clickOn("股林高手");
		up.verifyIsShown("股票1跟踪");
		up.clickOn("股票1跟踪");
		up.storeToLogin();
		up.clickOn("股票1跟踪");
		
		up.verifyIsShown("我的跟踪");
		up.clickOn("我的跟踪");
		up.verifyIsShown("编辑");
		up.clickOn("编辑");
		up.verifyIsShown("删除1");
		up.clickOn("删除1");
		up.verifyIsShown("删除按钮1");
		up.clickOn("删除按钮1");
		up.verifyIsShown("完成");
		up.clickOn("完成");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
