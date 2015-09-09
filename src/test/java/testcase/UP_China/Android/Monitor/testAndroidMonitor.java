package testcase.UP_China.Android.Monitor;

import org.testng.annotations.AfterClass;
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

	@AfterClass
	public void tearDown() {

		up.close();
	}

	@Test
	public void test010Navigation() {

		up.log(">========================<");
		up.log("开始测试：首页界面资源消耗");

		double initialFlow = up.getFlow();
		up.goHomePage();
		up.verifyIsShown("自选");
		// up.verifyIsShown("股票");
		// up.verifyIsShown("渤海商品");
		// up.verifyIsShown("贵金属");
		// up.verifyIsShown("股林高手");
		// up.verifyIsShown("选股");
		// up.verifyIsShown("研究所");
		// up.verifyIsShown("资金流向");

		double flow = up.getFlow() - initialFlow;
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.create("首页界面流量", flow, cpu, memory);

	}

	@Test
	public void test020DefinePage() {

		up.log(">========================<");
		up.log("开始测试：自选界面资源消耗");
		up.verifyIsShown("跳转自选");
		up.clickOn("跳转自选");

		up.clickOn("自选搜索");

		up.clickOn("0");
		up.verifyIsShown("加自选");
		up.clickOn("加自选");
		up.verifyIsShown("已添加");

		double initialFlow = up.getFlow();
		up.clickOn("返回");
		up.tapOn(5, 5);

		up.verifyIsShown("全部自选");
		up.verifyIsShown("名称代码");
		up.verifyIsShown("现价");
		up.verifyIsShown("涨跌幅");
		double flow = up.getFlow() - initialFlow;
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.addExcel("自选界面资源消耗", flow, cpu, memory, true);

	}

	@Test
	public void test030Market() {

		up.log(">========================<");
		up.log("开始测试：行情界面资源消耗");
		double initialFlow = up.getFlow();
		up.verifyIsShown("跳转行情");
		up.clickOn("跳转行情");
		up.verifyIsShown("行情");

		double flow = up.getFlow() - initialFlow;
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.addExcel("行情界面资源消耗", flow, cpu, memory, true);
	}

	@Test
	public void test031Market() {

		up.log(">========================<");
		up.log("开始测试：行情界面港股资源消耗");
		double initialFlow = up.getFlow();
		up.verifyIsShown("上证指数");

		up.clickOn("行情港股");
		up.clickOn("港股提示");
		up.clickOn("行情刷新");
		up.verifyIsShown("行情恒生指数");

		double flow = up.getFlow() - initialFlow;
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.addExcel("行情界面资源消耗", flow, cpu, memory, false);

	}

	@Test
	public void test032Market() {

		up.log(">========================<");
		up.log("开始测试：行情界面港股资源消耗");
		double initialFlow = up.getFlow();

		up.clickOn("行情美股");
		up.verifyIsShown("行情道琼斯指");
		double flow = up.getFlow() - initialFlow;
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.addExcel("行情界面港股资源消耗", flow, cpu, memory, false);

	}

	@Test
	public void test033Market() {

		up.log(">========================<");
		up.log("开始测试：行情界面国内指数资源消耗");
		double initialFlow = up.getFlow();

		up.clickOn("行情指数");
		up.verifyIsShown("行情国内指数");

		double flow = up.getFlow() - initialFlow;
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.addExcel("行情界面国内指数资源消耗", flow, cpu, memory, false);
	}

	@Test
	public void test034Market() {

		up.log(">========================<");
		up.log("开始测试：行情界面金融期货资源消耗");
		double initialFlow = up.getFlow();

		up.clickOn("行情期货");
		up.verifyIsShown("行情金融期货");
		double flow = up.getFlow() - initialFlow;
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.addExcel("行情界面金融期货资源消耗", flow, cpu, memory, false);
	}

	@Test
	public void test035Market() {

		up.log(">========================<");
		up.log("开始测试：行情界面分类资源消耗");
		double initialFlow = up.getFlow();
		up.clickOn("分类");
		up.verifyIsShown("沪深");
		up.verifyIsShown("港股");
		up.verifyIsShown("美股");

		double flow = up.getFlow() - initialFlow;
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.addExcel("行情界面分类资源消耗", flow, cpu, memory, false);
	}

	@Test
	public void test040Info() {

		up.log(">========================<");
		up.log("开始测试：资讯界面要闻资源消耗");
		double initialFlow = up.getFlow();
		up.verifyIsShown("跳转资讯");
		up.clickOn("跳转资讯");
		up.clickOn("要闻");
		up.verifyIsShown("要闻1");

		double flow = up.getFlow() - initialFlow;
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.addExcel("资讯界面要闻资源消耗", flow, cpu, memory, true);
	}

	@Test
	public void test041Info() {

		up.log(">========================<");
		up.log("开始测试：资讯界面要闻资源消耗");
		double initialFlow = up.getFlow();

		up.clickOn("滚动");
		up.verifyIsShown("滚动内容1");

		double flow = up.getFlow() - initialFlow;
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.addExcel("资讯界面要闻资源消耗", flow, cpu, memory, false);

	}

	@Test
	public void test042Info() {

		up.log(">========================<");
		up.log("开始测试：资讯界面要更多源消耗");
		double initialFlow = up.getFlow();

		up.clickOn("更多");
		up.verifyIsShown("沪深");
		up.verifyIsShown("宏观");
		up.verifyIsShown("行业");

		double flow = up.getFlow() - initialFlow;
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.addExcel("资讯界面更多资源消耗", flow, cpu, memory, false);

	}

	@Test
	public void test043Info() {

		up.log(">========================<");
		up.log("开始测试：资讯界面题材资源消耗");
		double initialFlow = up.getFlow();

		up.clickOn("题材");
		up.verifyIsShown("热点1");
		up.verifyIsShown("热点2");
		up.verifyIsShown("热点3");

		double flow = up.getFlow() - initialFlow;
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.addExcel("资讯界面题材资源消耗", flow, cpu, memory, false);
	}

	@Test
	public void test050FindPage() {

		up.log(">========================<");
		up.log("开始测试：发现界面百宝箱资源消耗");
		double initialFlow = up.getFlow();

		up.verifyIsShown("跳转发现");
		up.clickOn("跳转发现");
		up.tapOn(5, 5);

		up.verifyIsShown("百宝箱");

		double flow = up.getFlow() - initialFlow;
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.addExcel("发现界面百宝箱资源消耗", flow, cpu, memory, true);

	}

	@Test
	public void test051FindPage() {

		up.log(">========================<");
		up.log("开始测试：发现界面我的订阅资源消耗");
		up.clickOn("一键选股订阅");

		double initialFlow = up.getFlow();

		up.clickOn("我的订阅");
		up.verifyIsShown("我的订阅1");

		double flow = up.getFlow() - initialFlow;
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.addExcel("发现界面我的订阅资源消耗", flow, cpu, memory, false);
	}

	@Test
	public void test060loginAndLogout() {

		up.log(">========================<");
		up.log("开始测试：登录资源消耗");
		String userName = up.getProperty("app.up.username");
		String Password = up.getProperty("app.up.password");

		up.clickOn("跳转首页");
		double initialFlow = up.getFlow();

		up.clickOn("跳转我的");

		up.verifyIsShown("登录导航");

		up.clickOn("登录导航");
		up.clickOn("点击登录");

		up.setValueTo("帐号", userName);
		up.setValueTo("密码", Password);
		up.clickOn("登录");
		up.verifyIsShown("头像");

		double flow = up.getFlow() - initialFlow;
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.addExcel("登录资源消耗", flow, cpu, memory, true);

	}

	@Test
	public void test061loginAndLogout() {

		up.log(">========================<");
		up.log("开始测试：登出资源消耗");
		double initialFlow = up.getFlow();

		up.clickOn("头像");

		up.verifyIsShown("退出登录");
		up.clickOn("退出登录");
		up.clickOn("是");
		up.verifyIsShown("点击登录");

		double flow = up.getFlow() - initialFlow;
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.addExcel("登出资源消耗", flow, cpu, memory, false);

	}

}
