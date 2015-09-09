package testcase.UP_Metal.Android.P1.BaiBaoXiang;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UPMetal_Android;

public class test_P1_02_TAzhanshi {

	private UPMetal_Android up;

	@BeforeClass
	public void setUP() {

		up = new UPMetal_Android();
		up.log("开始测试：初始展示");
		up.openApp();
	}

	/**
	 * 测试名称：02 初始展示
	 * [前提条件]：
	 * [测试步骤]：
	 * 1、进入【百宝箱】->【银管家】->【分析师】
	 * 2、点击列表中任一行数据
	 * 3、查看TA的直播间界面初始展示
	 * [预期结果]：
	 * 1、进入TA的直播间
	 * 2、标题栏：左侧显示返回图标，中间展示问题TA的直播间
	 * 3、头像栏：展示分析师头像，昵称，名词，粉丝数，加关注状态（未关注显示+关注，已关注显示取消关注）
	 * 4、头像栏下方：展示直播动态栏和分析师简介栏，默认展示直播动态栏
	 * 5、直播动态默认展示：数据默认动按照时间降序排序,每条内容显示时间+内容，时间格式为MM-DD HH:MM,数据内容和PC一致
	 */
	@Test
	public void testTAzhanshi() {

		up.goHomePage();
		up.verifyIsShown("跳转百宝箱");
		up.clickOn("跳转百宝箱");
		up.verifyIsShown("银管家");
		up.clickOn("银管家");
		up.Jinmudan();
		up.verifyIsShown("分析师");
		up.clickOn("分析师");
		
		up.verifyIsShown("名称1");
		up.clickOn("名称1");
		
		up.verifyIsShown("头像");
		up.verifyIsShown("昵称");
		up.verifyIsShown("名词");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
