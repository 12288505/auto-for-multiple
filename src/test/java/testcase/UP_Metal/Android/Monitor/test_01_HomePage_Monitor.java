package testcase.UP_Metal.Android.Monitor;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tools.CreateExcel;
import fwk.UPMetal_Android;

public class test_01_HomePage_Monitor {

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
	public void test010Zhuye() {

		up.log("测试主页资源消耗");

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
		up.verifyIsShown("策略速递");
		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.log("主页消耗流量：" + (flow - initialFlow) + "KB.", 4);
		up.log("主页CPU占用：" + cpu + "%.", 4);
		up.log("主页内存占用：" + memory + "MB.", 4);

		create.create("主页资源消耗", (flow - initialFlow), cpu, memory);
	}

	@Test(dependsOnMethods = "test010Zhuye")
	public void test020Xinwen() {

		up.log("测试主页新闻资源消耗");

		double initialFlow = up.getFlow();

		up.verifyIsShown("自选消息1");
		up.clickOn("自选消息1");
		up.clickOn("操作提示");
		up.verifyIsShown("收藏");
		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.log("主页新闻消耗流量：" + (flow - initialFlow) + "KB.", 4);
		up.log("主页新闻CPU占用：" + cpu + "%.", 4);
		up.log("主页新闻内存占用：" + memory + "MB.", 4);
		up.clickOn("新闻返回");

		create.addExcel("主页新闻资源消耗", (flow - initialFlow), cpu, memory, false);
	}

	@Test(dependsOnMethods = "test020Xinwen")
	public void test030Hangqing() {

		up.log("测试贵金属行情资源消耗");
		double initialFlow = up.getFlow();
		up.verifyIsShown("广贵");
		up.clickOn("广贵");
		up.verifyIsShown("粤贵银");

		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.log("贵金属行情消耗流量：" + (flow - initialFlow) + "KB.", 4);
		up.log("贵金属行情CPU占用：" + cpu + "%.", 4);
		up.log("贵金属行情内存占用：" + memory + "MB.", 4);

		create.addExcel("贵金属行情资源消耗", (flow - initialFlow), cpu, memory, false);
	}

	@Test(dependsOnMethods = "test030Hangqing")
	public void test040Xiaoxi() {

		up.log("测试消息中心资源消耗");
		double initialFlow = up.getFlow();
		up.verifyIsShown("消息中心");
		up.clickOn("消息中心");
		up.verifyIsShown("消息提示中心");
		up.verifyIsShown("消息返回");

		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.log("消息中心消耗流量：" + (flow - initialFlow) + "KB.", 4);
		up.log("消息中心CPU占用：" + cpu + "%.", 4);
		up.log("消息中心内存占用：" + memory + "MB.", 4);

		up.clickOn("消息返回");

		create.addExcel("消息中心资源消耗", (flow - initialFlow), cpu, memory, false);
	}

	@Test(dependsOnMethods = "test040Xiaoxi")
	public void test050Zixuan() {

		up.log("测试自选资源消耗");
		double initialFlow = up.getFlow();

		up.verifyIsShown("自选");
		up.clickOn("自选");
		up.verifyIsShown("自加选");
		up.clickOn("自加选", 4);

		up.verifyIsShown("添加品种");

		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.log("消息中心消耗流量：" + (flow - initialFlow) + "KB.", 4);
		up.log("消息中心CPU占用：" + cpu + "%.", 4);
		up.log("消息中心内存占用：" + memory + "MB.", 4);

		create.addExcel("自选资源消耗", (flow - initialFlow), cpu, memory, false);
	}
}
