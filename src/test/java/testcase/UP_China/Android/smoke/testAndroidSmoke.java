package testcase.UP_China.Android.smoke;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class testAndroidSmoke {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.openApp();
		up.goHomePage();
	}

	@AfterClass
	public void tearDown() {

		up.close();
	}

	/**
	 * 测试名称：首页导航栏元素校验
	 * 测试步骤:
	 * 1、进入首页
	 * 2、查看顶部导航
	 * 期望结果：
	 * 从左至右从上至下依次展示：自选，沪深股票，港股，美股，股票开户，股票交易，股林高手，智能选股；
	 */
	@Test
	public void test010Navigation() {

		up.log(">========================<");
		up.log("开始测试：首页界面");
		up.verifyIsShown("自选");
		up.verifyIsShown("沪深股票");
		up.verifyIsShown("港股");
		up.verifyIsShown("美股");
		up.verifyIsShown("股林高手");
		up.verifyIsShown("智能选股");

	}

	/**
	 * 测试名称：自选界面初始展示
	 * 测试步骤:
	 * 前提：有自选股票数据
	 * 1、在首页底部点击自选按钮
	 * 2、查看自选界面
	 * 期望结果：
	 * 1、标题栏展示全部自选，标题栏左侧展示文字编辑，右侧展示搜索图标
	 * 2、自选股列表表头显示名称、现价、涨跌幅是三个字段
	 */
	@Test
	public void test020DefinePage() {

		up.log(">========================<");
		up.log("开始测试：自选界面");
		up.verifyIsShown("跳转自选");
		up.clickOn("跳转自选");

		up.clickOn("自选搜索");

		up.clickOn("0");
		up.verifyIsShown("加自选");
		up.clickOn("加自选");
		up.verifyIsShown("已添加");

		up.clickOn("返回");
		up.tapOn(5, 5);

		up.verifyIsShown("全部自选");
		up.verifyIsShown("名称代码");
		up.verifyIsShown("现价");
		up.verifyIsShown("涨跌幅");

	}

	/**
	 * 测试名称：行情界面初始展示
	 * 测试步骤:
	 * 1、点击底部导航栏行情按钮
	 * 2、查看行情界面
	 * 期望结果：
	 * 1、行情界面展示沪深、港股、美股、指数和期货
	 * 2、分类展示沪深、港股、美股、期货
	 */
	@Test
	public void test030Market() {

		up.log(">========================<");
		up.log("开始测试：行情界面");
		up.verifyIsShown("跳转行情");
		up.clickOn("跳转行情");
		up.verifyIsShown("行情");
		up.verifyIsShown("上证指数");

		up.clickOn("行情港股");
		up.clickOn("港股提示");
		up.clickOn("行情刷新");
		up.verifyIsShown("行情恒生指数");

		up.clickOn("行情美股");
		up.verifyIsShown("行情道琼斯指");

		up.clickOn("行情指数");
		up.verifyIsShown("行情国内指数");

		up.clickOn("行情期货");
		up.verifyIsShown("行情中金所");

		up.clickOn("分类");
		up.verifyIsShown("沪深");
		up.verifyIsShown("港股");
		up.verifyIsShown("美股");

	}

	/**
	 * 测试名称：资讯界面初始展示
	 * 测试步骤:
	 * 1、点击底部导航栏资讯按钮
	 * 2、查看资讯界面
	 * 期望结果：
	 * 资讯界面展示题材、要闻、滚动、更多
	 */
	@Test
	public void test040Info() {

		up.log(">========================<");
		up.log("开始测试：资讯界面");
		up.verifyIsShown("跳转资讯");
		up.clickOn("跳转资讯");

		up.clickOn("要闻");
		up.verifyIsShown("财新资讯精选");

		up.clickOn("滚动");
		up.verifyIsShown("滚动内容1");

		up.clickOn("更多");
		up.verifyIsShown("沪深");
		up.verifyIsShown("宏观");
		up.verifyIsShown("行业");

		up.clickOn("题材");
		up.verifyIsShown("热点1");
		up.verifyIsShown("热点2");
		up.verifyIsShown("热点3");
	}

	/**
	 * 测试名称：发现界面初始展示
	 * 测试步骤:
	 * 1、在底部导航栏点击发现按钮
	 * 2、查看发现界面
	 * 期望结果：
	 * 1、百宝箱界面展示选股、特色内参、主力分析、特权
	 * 2、我的订阅界面展示订阅内容
	 */
	@Test
	public void test050FindPage() {

		up.log(">========================<");
		up.log("开始测试：发现界面");
		up.verifyIsShown("跳转发现");
		up.clickOn("跳转发现");
		up.tapOn(5, 5);

		up.verifyIsShown("百宝箱");
		up.clickOn("一键选股订阅");

		up.swipeUpToElement("特色内参");
		up.verifyIsShown("高手藏金阁");

		up.swipeUpToElement("主力分析");
		up.verifyIsShown("资金流向");

		up.swipeUpToElement("L2风云");
		up.verifyIsShown("L2风云");

		up.clickOn("我的订阅");
		up.verifyIsShown("我的订阅1");
	}

	/**
	 * 测试名称：登录登出系统
	 * 测试步骤:
	 * 1、进入我的界面登录系统
	 * 2、登出系统
	 * 期望结果：
	 * 1、成功登录和登出系统
	 */
	@Test
	public void test060loginAndLogout() {

		up.log(">========================<");
		up.log("开始测试：登录和登出系统");
		String userName = up.getProperty("app.up.username");
		String Password = up.getProperty("app.up.password");

		up.clickOn("跳转首页");
		up.clickOn("跳转我的");

		up.verifyIsShown("登录导航");
		up.clickOn("登录导航");
		up.clickOn("点击登录");

		up.setValueTo("帐号", userName);
		up.setValueTo("密码", Password);
		up.clickOn("登录");
		up.verifyIsShown("头像");
		up.clickOn("头像");

		up.verifyIsShown("退出登录");
		up.clickOn("退出登录");
		up.clickOn("是");
		up.verifyIsShown("点击登录");

	}

}
