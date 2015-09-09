package testcase.UP_Metal.Android.Smoke;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fwk.UPMetal_Android;

public class testAndroidSmoke {

	private UPMetal_Android up;

	@BeforeMethod
	public void setUP() {

		up = new UPMetal_Android();
		up.openApp();
	}

	/**
	 * 测试名称：首页元素校验
	 */
	@Test
	public void test010hangqing() {

		up.log("测试行情页面");
		up.goHomePage();

		up.verifyIsShown("策略速递");
		up.clickOn("策略速递");
		up.verifyIsShown("标题");
		up.verifyIsShown("跳转行情");
		up.clickOn("跳转行情");

		up.verifyIsShown("自选消息1");
		up.clickOn("自选消息1");
		up.clickOn("操作提示");
		up.verifyIsShown("收藏");
		up.clickOn("新闻返回");

		up.verifyIsShown("自选");
		up.verifyIsShown("广贵");
		up.clickOn("广贵");
		up.verifyIsShown("天贵");
		up.clickOn("天贵");
		up.verifyIsShown("大圆");
		up.clickOn("大圆");

		up.verifyIsShown("消息中心");
		up.clickOn("消息中心");
		up.verifyIsShown("消息提示中心");
		up.verifyIsShown("消息返回");
		up.clickOn("消息返回");

		up.verifyIsShown("自选");
		up.clickOn("自选");
		up.verifyIsShown("自加选");
		up.clickOn("自加选", 4);

		up.verifyIsShown("添加品种");
		up.clickOn("自选返回");

		up.verifyIsShown("标题");
	}

	@Test
	public void test020yanjiusuo() {

		up.log("测试研究所页面");
		up.goHomePage();

		up.verifyIsShown("跳转研究所");
		up.clickOn("跳转研究所");
		up.waitByTimeout(2000);
		up.verifyIsShown("消息中心");
		up.clickOn("消息中心");
		up.verifyIsShown("消息提示中心");
		up.verifyIsShown("消息返回");
		up.clickOn("消息返回");

		up.verifyIsShown("全部");
		up.verifyIsShown("新闻1");
		up.waitByTimeout(2000);
		up.clickOn("新闻1");
		up.clickOn("操作提示");
		up.verifyIsShown("收藏");
		up.clickOn("新闻返回");

		up.verifyIsShown("策略速递");
		up.clickOn("策略速递");
		up.waitByTimeout(2000);
		up.clickOn("新闻1");
		up.verifyIsShown("收藏");
		up.clickOn("新闻返回");

		up.verifyIsShown("每日必读");
		up.clickOn("每日必读");
		up.waitByTimeout(2000);
		up.clickOn("新闻1");
		up.verifyIsShown("收藏");
		up.clickOn("新闻返回");

		up.verifyIsShown("焦点透视");
		up.clickOn("焦点透视");
		up.waitByTimeout(2000);
		up.clickOn("新闻1");
		up.verifyIsShown("收藏");
		up.clickOn("新闻返回");
	}

	@Test
	public void test030baibaoxiang() {

		up.log("测试百宝箱页面");
		up.goHomePage();
		up.verifyIsShown("跳转百宝箱");
		up.clickOn("跳转百宝箱");
		up.verifyIsShown("标题");

		up.verifyIsShown("银管家");
		up.clickOn("银管家");

		up.clickOn("返回");
		up.clickOn("财经日历");
		up.verifyIsShown("财经日历标题");
		up.verifyIsShown("日历");
		up.clickOn("日历");
		up.clickOn("完成");

		up.verifyIsShown("数据名称");
		up.clickOn("数据名称");
		up.verifyIsShown("数据标题");
		up.clickOn("数据返回");

		up.clickOn("返回");
		up.verifyIsShown("百宝箱");
	}

	@Test
	public void test040wode() {

		up.log("测试我的页面");
		up.goHomePage();
		up.verifyIsShown("跳转我的");
		up.clickOn("跳转我的");
		up.clickOn("操作提示");
		up.verifyIsShown("标题");

		up.verifyIsShown("点击登录");
		up.clickOn("点击登录");
		up.Thelogin();

		up.verifyIsShown("消息中心");
		up.clickOn("消息中心");
		up.verifyIsShown("消息提示中心");
		up.clickOn("消息返回");

		up.verifyIsShown("我的收藏");
		up.clickOn("我的收藏");
		up.verifyIsShown("收藏标题");
		up.clickOn("收藏返回");

		up.verifyIsShown("预警管理");
		up.clickOn("预警管理");
		up.verifyIsShown("预警标题");
		up.clickOn("预警返回");

		up.verifyIsShown("意见反馈");
		up.clickOn("意见反馈");
		up.verifyIsShown("意见标题");
		up.clickOn("意见返回");

		up.verifyIsShown("设置");
		up.clickOn("设置");
		up.verifyIsShown("设置名称");
		up.clickOn("设置返回");

		up.verifyIsShown("点击登录");
		up.clickOn("点击登录");
		up.verifyIsShown("个人信息");
		up.clickOn("退出登录");
		up.clickOn("是");
	}

	@AfterMethod
	public void tearDown() {

		up.close();
	}
}
