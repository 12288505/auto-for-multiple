package testcase.UP_Metal.Android.Monitor;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tools.CreateExcel;
import fwk.UPMetal_Android;

public class test_03_Treasure_Monitor {

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
	public void test010BaiBaoXiang() {

		up.log("测试百宝箱资源消耗");
		up.goHomePage();

		double initialFlow = up.getFlow();
		String traffic = "" + initialFlow;
		up.log(traffic);

		up.verifyIsShown("跳转百宝箱");
		up.clickOn("跳转百宝箱");
		up.verifyIsShown("标题");

		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();
		String newtraffic = "" + flow;
		up.log(newtraffic);
		double newflow = flow - initialFlow;

		up.log("百宝箱消耗流量：" + newflow + "KB.", 4);
		up.log("百宝箱CPU占用：" + cpu + "%.", 4);
		up.log("百宝箱内存占用：" + memory + "MB.", 4);

		create.addExcel("百宝箱资源消耗", newflow, cpu, memory, true);

	}

	@Test(dependsOnMethods = "test010BaiBaoXiang")
	public void test020YinGuanJia() {

		up.log("测试银管家资源消耗");

		double initialFlow = up.getFlow();
		String traffic = "" + initialFlow;
		up.log(traffic);

		up.verifyIsShown("银管家");
		up.clickOn("银管家");
		up.verifyIsShown("返回");

		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();
		String newtraffic = "" + flow;
		up.log(newtraffic);

		up.log("银管家消耗流量：" + (flow - initialFlow) + "KB.", 4);
		up.log("银管家CPU占用：" + cpu + "%.", 4);
		up.log("银管家内存占用：" + memory + "MB.", 4);
		up.clickOn("返回");

		create.addExcel("银管家资源消耗", (flow - initialFlow), cpu, memory, false);
	}

	@Test(dependsOnMethods = "test020YinGuanJia")
	public void test030CeLueSuDi() {

		up.log("测试财经日历资源消耗");

		double initialFlow = up.getFlow();
		String traffic = "" + initialFlow;
		up.log(traffic);

		up.clickOn("财经日历");
		up.verifyIsShown("财经日历标题");
		up.verifyIsShown("日历");

		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();
		String newtraffic = "" + flow;
		up.log(newtraffic);

		up.log("财经日历消耗流量：" + (flow - initialFlow) + "KB.", 4);
		up.log("财经日历CPU占用：" + cpu + "%.", 4);
		up.log("财经日历内存占用：" + memory + "MB.", 4);

		create.addExcel("财经日历资源消耗", (flow - initialFlow), cpu, memory, false);
	}

	@Test(dependsOnMethods = "test030CeLueSuDi")
	public void test040RiLi() {

		up.log("测试日历资源消耗");
		double initialFlow = up.getFlow();
		String traffic = "" + initialFlow;
		up.log(traffic);

		up.clickOn("日历");
		up.clickOn("完成");

		up.verifyIsShown("数据名称");

		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();
		String newtraffic = "" + flow;
		up.log(newtraffic);

		up.log("日历消耗流量：" + (flow - initialFlow) + "KB.", 4);
		up.log("日历CPU占用：" + cpu + "%.", 4);
		up.log("日历内存占用：" + memory + "MB.", 4);

		create.addExcel("日历资源消耗", (flow - initialFlow), cpu, memory, false);
	}

	@Test(dependsOnMethods = "test040RiLi")
	public void test050RiLiPinZhong() {

		up.log("测试日历品种资源消耗");
		double initialFlow = up.getFlow();
		String traffic = "" + initialFlow;
		up.log(traffic);

		up.clickOn("数据名称");
		up.verifyIsShown("数据标题");

		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();
		String newtraffic = "" + flow;
		up.log(newtraffic);

		up.log("日历品种消耗流量：" + (flow - initialFlow) + "KB.", 4);
		up.log("日历品种CPU占用：" + cpu + "%.", 4);
		up.log("日历品种内存占用：" + memory + "MB.", 4);

		create.addExcel("日历品种资源消耗", (flow - initialFlow), cpu, memory, false);
	}
}
