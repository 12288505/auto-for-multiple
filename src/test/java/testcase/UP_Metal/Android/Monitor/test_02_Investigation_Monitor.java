package testcase.UP_Metal.Android.Monitor;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tools.CreateExcel;
import fwk.UPMetal_Android;

public class test_02_Investigation_Monitor {

	private UPMetal_Android up;
	private CreateExcel create = new CreateExcel();

	@BeforeClass
	public void setUp() {

		up = new UPMetal_Android();
		up.openApp();

	}

	/**
	 * 测试名称：查看主页
	 */
	@Test
	public void test010yanjiusuo() {

		up.log("测试研究所资源消耗");
		up.goHomePage();

		double initialFlow = up.getFlow();

		up.verifyIsShown("跳转研究所");
		up.clickOn("跳转研究所");
		up.verifyIsShown("消息中心");

		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.log("研究所消耗流量：" + (flow - initialFlow) + "KB.", 4);
		up.log("研究所CPU占用：" + cpu + "%.", 4);
		up.log("研究所内存占用：" + memory + "MB.", 4);

		create.addExcel("研究所资源消耗", (flow - initialFlow), cpu, memory, true);
	}

	@Test(dependsOnMethods = "test010yanjiusuo")
	public void test020xinwen() {

		up.log("测试研究所新闻资源消耗");

		double initialFlow = up.getFlow();

		up.verifyIsShown("全部");
		up.verifyIsShown("新闻1");
		up.waitByTimeout(2000);
		up.clickOn("新闻1");
		up.clickOn("操作提示");
		up.verifyIsShown("收藏");

		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.log("研究所新闻消耗流量：" + (flow - initialFlow) + "KB.", 4);
		up.log("研究所新闻CPU占用：" + cpu + "%.", 4);
		up.log("研究所新闻内存占用：" + memory + "MB.", 4);
		up.clickOn("新闻返回");

		create.addExcel("研究所新闻资源消耗", (flow - initialFlow), cpu, memory, false);
	}

	@Test(dependsOnMethods = "test020xinwen")
	public void test030CeLueSuDi() {

		up.log("测试策略速递资源消耗");
		double initialFlow = up.getFlow();

		up.verifyIsShown("策略速递");
		up.clickOn("策略速递");
		up.waitByTimeout(2000);

		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.log("策略速递消耗流量：" + (flow - initialFlow) + "KB.", 4);
		up.log("策略速递CPU占用：" + cpu + "%.", 4);
		up.log("策略速递内存占用：" + memory + "MB.", 4);

		create.addExcel("策略速递资源消耗", (flow - initialFlow), cpu, memory, false);
	}

	@Test(dependsOnMethods = "test030CeLueSuDi")
	public void test040MeiRiBiDu() {

		up.log("测试每日必读资源消耗");
		up.verifyIsShown("每日必读");

		double initialFlow = up.getFlow();

		up.clickOn("每日必读");
		up.waitByTimeout(2000);

		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.log("每日必读消耗流量：" + (flow - initialFlow) + "KB.", 4);
		up.log("每日必读CPU占用：" + cpu + "%.", 4);
		up.log("每日必读内存占用：" + memory + "MB.", 4);

		create.addExcel("每日必读资源消耗", (flow - initialFlow), cpu, memory, false);
	}

	@Test(dependsOnMethods = "test040MeiRiBiDu")
	public void test050JiaoDianTouShi() {

		up.log("测试焦点透视资源消耗");
		double initialFlow = up.getFlow();

		up.verifyIsShown("焦点透视");
		up.clickOn("焦点透视");
		up.waitByTimeout(2000);

		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.log("焦点透视消耗流量：" + (flow - initialFlow) + "KB.", 4);
		up.log("焦点透视CPU占用：" + cpu + "%.", 4);
		up.log("焦点透视内存占用：" + memory + "MB.", 4);

		create.addExcel("焦点透视资源消耗", (flow - initialFlow), cpu, memory, false);
	}
}
