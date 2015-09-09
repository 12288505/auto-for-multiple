package testcase.Demo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fwk.UP_Android;

public class testAndroidMonitor {

	private UP_Android up;

	@BeforeClass
	public void setUp() {

		up = new UP_Android();
		up.openApp();

	}

	/**
	 * 测试名称：查看主页
	 */
	@Test
	public void test010Navigation() {

		up.log(">========================<");
		up.log("查看主页流量，CPU和内存占用");
		String naviAtt = "";
		for (int times = 1; times < 10; times++) {
			naviAtt = up.getElementAttribute("立刻体验", "clickable");
			if (naviAtt.equalsIgnoreCase("false")) {
				up.log("未找到立刻体验，向左滑动！");
				up.swipe("left");
			} else
				break;
		}
		double initialFlow = up.getFlow();
		up.tapOn("立刻体验");
		up.verifyIsShown("自选");

		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();
		up.log("主页消耗流量：" + (flow - initialFlow) + "KB.", 4);
		up.log("主页CPU占用：" + cpu + "%.", 4);
		up.log("主页内存占用：" + memory + "MB.", 4);

	}

	/**
	 * 测试名称：点击首页导航进入相应元素
	 * 测试步骤:
	 * 1、点击任一首页导航元素（如：选股）
	 * 2、检查相应元素
	 * 期望结果：
	 * 1、界面跳转到选股界面；
	 */
	@Test
	public void test020ClickNavigation() {

		up.log(">========================<");
		up.log("点击首页导航进入相应元素");
		double initialFlow = up.getFlow();
		up.verifyIsShown("选股");
		up.clickOn("选股");
		up.verifyIsShown("选股");
		up.clickOn("返回");
		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();
		up.log("选股消耗流量：" + (flow - initialFlow) + "KB.", 4);
		up.log("选股CPU占用：" + cpu + "%.", 4);
		up.log("选股内存占用：" + memory + "MB.", 4);

	}
	//
	// /**
	// * 测试名称：自选界面初始展示
	// * 测试步骤:
	// * 前提：有自选股票数据
	// * 1、在首页底部点击自选按钮
	// * 2、查看自选界面
	// * 期望结果：
	// * 1、标题栏展示全部自选，标题栏左侧展示文字编辑，右侧展示搜索图标
	// * 2、自选股列表表头显示名称、现价、涨跌幅是三个字段
	// * 3、自选股列表数据展示品种名称，品种代码，品种价格和涨跌幅
	// */
	// @Test
	// public void test030DefinePage() {
	//
	// up.log(">========================<");
	// up.log("自选界面初始展示");
	// up.verifyIsShown("跳转自选");
	// up.clickOn("跳转自选");
	// up.clickOn("自选提示");
	// up.clickOn("搜索");
	// up.clickOn("0");
	//
	// up.verifyIsShown("加自选");
	// up.clickOn("加自选");
	// up.verifyIsShown("加自选");
	// up.clickOn("加自选");
	// up.verifyIsShown("加自选");
	// up.clickOn("加自选");
	// up.verifyIsShown("已添加");
	//
	// up.clickOn("返回");
	//
	// up.verifyIsShown("全部自选");
	// up.verifyIsShown("编辑");
	// up.verifyIsShown("搜索");
	// up.verifyIsShown("名称代码");
	// up.verifyIsShown("现价");
	// up.verifyIsShown("涨跌幅");
	//
	// up.verifyIsShown("名称1");
	// up.verifyIsShown("代码1");
	// up.verifyIsShown("现价1");
	// up.verifyIsShown("涨跌幅1");
	// }
	//
	// /**
	// * 测试名称：点击自选股现价排序
	// * 测试步骤:
	// * 1、点击自选股列表表头现价字段
	// * 期望结果：
	// * 1、自选列表现价字段数值按照箭头所指方向进行排序；（箭头向上升序，箭头向下降序）
	// */
	// @Test
	// public void test040DefineSort() {
	//
	// up.log(">========================<");
	// up.log("点击自选股现价排序");
	// up.verifyIsShown("现价");
	// up.clickOn("现价");
	// up.verifyIsShown("降序");
	// up.clickOn("现价");
	// up.verifyIsShown("升序");
	// }
	//
	// /**
	// * 测试名称：行情界面初始展示
	// * 测试步骤:
	// * 1、点击底部导航栏行情按钮
	// * 2、查看行情界面
	// * 期望结果：
	// * 1、标题栏展示行情和搜索按钮
	// * 2、标题栏下方展示股票，渤海，贵金属，更多四个tab选择按钮，默认选中为股票
	// * 3、tab栏下方展示上证指数，深证成指，沪深300三个指数
	// * 4、指数栏下方展示6个热门板块，第一行展示涨幅最高的三大板块，第二行展示涨幅最低的三大板块三个
	// * 5、热门板块下方展示涨幅榜10只涨幅最大的股票
	// * 6、涨幅榜下方展示跌幅榜，列表展示10只涨幅最低的股票
	// *
	// * 自动化实现问题：10只涨幅股票定位一样，每次只显示当前页面可见的元素，无法判断总共有10只，需要开发给予每只股票定位一个独立的resource-
	// * id
	// */
	// @Test
	// public void test050Market() {
	//
	// up.log(">========================<");
	// up.log("行情界面初始展示");
	// up.verifyIsShown("跳转行情");
	// up.clickOn("跳转行情");
	//
	// up.verifyIsShown("行情");
	// up.verifyIsShown("搜索");
	//
	// up.verifyIsShown("股票");
	// up.verifyIsShown("渤海");
	// up.verifyIsShown("贵金属");
	// up.verifyIsShown("更多");
	//
	// up.verifyIsShown("上证指数");
	// up.verifyIsShown("深证成指");
	// up.verifyIsShown("沪深300");
	//
	// up.verifyIsShown("热门板块");
	//
	// up.swipeUpToElement("涨幅榜");
	// up.swipeUpToElement("跌幅榜");
	//
	// }
	//
	// /**
	// * 测试名称：从股票综合屏切换到渤海综合屏
	// * 测试步骤:
	// * 1、点击顶部tab的渤海按钮
	// * 期望结果：
	// * 1、进入渤海综合屏界面
	// */
	// @Test
	// public void test060BohaiPage() {
	//
	// up.log(">========================<");
	// up.log("从股票综合屏切换到渤海综合屏");
	// up.verifyIsShown("渤海");
	// up.clickOn("渤海");
	//
	// up.verifyIsShown("渤海1");
	// up.verifyIsShown("渤海2");
	// up.verifyIsShown("渤海3");
	// }
	//
	// /**
	// * 测试名称：发现界面初始展示
	// * 测试步骤:
	// * 1、在底部导航栏点击发现按钮
	// * 2、查看发现界面
	// * 期望结果：
	// * 1、发现界面标题栏展示发现二字
	// * 2、列表部分从上到下依次展示：高手藏金阁，明星分析师荐股，基金重仓，财经日历
	// */
	// @Test
	// public void test070FindPage() {
	//
	// up.log(">========================<");
	// up.log("发现界面初始展示");
	// up.verifyIsShown("跳转发现");
	// up.clickOn("跳转发现");
	//
	// up.verifyIsShown("标题");
	// up.verifyIsShown("高手藏金阁");
	// up.verifyIsShown("明星分析师荐股");
	// up.verifyIsShown("基金重仓");
	// up.verifyIsShown("财经日历");
	// }
	//
	// /**
	// * 测试名称：从发现界面键入高手藏金阁列表
	// * 测试步骤:
	// * 1、在发现界面点击高手藏金阁
	// * 期望结果：
	// * 1、进入高手藏金阁界面；
	// */
	// @Test
	// public void test080GoldenPavilionPage() {
	//
	// up.log(">========================<");
	// up.log("从发现界面键入高手藏金阁列表");
	// up.verifyIsShown("高手藏金阁");
	// up.clickOn("高手藏金阁");
	//
	// up.verifyIsShown("高手藏金阁1");
	// up.verifyIsShown("高手藏金阁2");
	//
	// up.clickOn("返回");
	// }
	//
	// /**
	// * 测试名称：我的界面初始展示
	// * 测试步骤:
	// * 前提:未登录状态
	// * 1、在底部导航栏点击我的
	// * 2、查看我的界面
	// * 期望结果：
	// * 1、标题栏展示我的二字
	// * 2、标题栏下方展示用户头像登陆注册
	// * 3、下方依次展示：消息中心，意见反馈，我的收藏，预警管理，设置
	// */
	// @Test
	// public void test090MinePage() {
	//
	// up.log("我的界面初始展示");
	// up.verifyIsShown("跳转我的");
	// up.clickOn("跳转我的");
	//
	// up.clickOn("登录提示");
	// up.verifyIsShown("我的标题");
	// up.verifyIsShown("登录注册");
	// up.verifyIsShown("消息中心");
	// up.verifyIsShown("意见反馈");
	// up.verifyIsShown("我的收藏");
	// up.verifyIsShown("预警管理");
	//
	// }
	//
	// /**
	// * 测试名称：点击用户头像区域进入登陆界面，登陆后登出
	// * 测试步骤:
	// * 1、点击用户头像区域
	// * 2、登陆系统
	// * 3、登出系统
	// * 期望结果：
	// * 1、成功登陆后登出系统
	// */
	// @Test
	// public void test100LoginPage() {
	//
	// up.log(">========================<");
	// up.log("点击用户头像区域进入登陆界面，登陆后登出");
	//
	// up.verifyIsShown("登录注册");
	// up.clickOn("登录注册");
	//
	// up.verifyIsShown("帐号");
	// up.setValueTo("帐号", "upautotest");
	// up.verifyIsShown("密码");
	// up.setValueTo("密码", "qwe123");
	// up.verifyIsShown("登录");
	// up.clickOn("登录");
	// up.verifyIsShown("我的标题");
	// up.clickOn("个人头像");
	// up.verifyIsShown("退出登录");
	// up.clickOn("退出登录");
	// up.verifyIsShown("是");
	// up.clickOn("是");
	// up.verifyIsShown("登录注册");
	// }
}
