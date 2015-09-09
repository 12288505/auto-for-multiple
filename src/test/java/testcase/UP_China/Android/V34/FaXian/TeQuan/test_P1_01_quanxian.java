package testcase.UP_China.Android.V34.FaXian.TeQuan;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class test_P1_01_quanxian {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.log("开始测试：权限-已登录有权限用户");
		up.openApp();
	}

	/**
	 * 测试名称：01 权限-已登录有权限用户
	 * [前提条件]：用户已登录，且该用户已在ｐｃ端开通权限
	 * [测试步骤]：
	 * 1、进入｛首页｝－｛发现｝，观察页面
	 * 2、
	 * [预期结果]：
	 * 1、页面显示｛高手云秒杀（B套餐）｝项，底部文字显示"实盘赛冠亚季军，实时跟踪秒杀"
	 */
	@Test
	public void testQuanxian() {

		up.goHomePage();
		
		up.Permissions();
		up.clickOn("我的返回");
		
		up.verifyIsShown("跳转发现");
		up.clickOn("跳转发现");
		
		up.clickOn("发现导航");
		
		up.swipeUpToElement("高手云秒杀（B套餐）");
		up.verifyIsShown("高手云秒杀（B套餐）");
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}
}
