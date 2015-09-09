package testcase.UP_Metal.Android.Monitor;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tools.CreateExcel;
import fwk.UPMetal_Android;

public class test_04_Mine_Monitor {

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
	public void test010WoDe() {

		up.log("测试我的界面资源消耗");
		up.goHomePage();

		double initialFlow = up.getFlow();

		up.verifyIsShown("跳转我的");
		up.clickOn("跳转我的");
		up.clickOn("操作提示");
		up.verifyIsShown("标题");

		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.log("我的界面消耗流量：" + (flow - initialFlow) + "KB.", 4);
		up.log("我的界面CPU占用：" + cpu + "%.", 4);
		up.log("我的界面内存占用：" + memory + "MB.", 4);

		create.addExcel("我的界面资源消耗", (flow - initialFlow), cpu, memory, true);
	}

	@Test(dependsOnMethods = "test010WoDe")
	public void test020DengLu() {

		up.log("测试登录资源消耗");

		double initialFlow = up.getFlow();

		up.verifyIsShown("点击登录");
		up.clickOn("点击登录");
		up.Thelogin();

		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.log("登录消耗流量：" + (flow - initialFlow) + "KB.", 4);
		up.log("登录CPU占用：" + cpu + "%.", 4);
		up.log("登录内存占用：" + memory + "MB.", 4);

		create.addExcel("百宝箱资源消耗", (flow - initialFlow), cpu, memory, false);
	}

	@Test(dependsOnMethods = "test020DengLu")
	public void test030XiaoXiZhongXin() {

		up.log("测试消息中心资源消耗");

		double initialFlow = up.getFlow();

		up.verifyIsShown("消息中心");
		up.clickOn("消息中心");
		up.verifyIsShown("消息提示中心");

		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.log("消息中心消耗流量：" + (flow - initialFlow) + "KB.", 4);
		up.log("消息中心CPU占用：" + cpu + "%.", 4);
		up.log("消息中心内存占用：" + memory + "MB.", 4);
		up.clickOn("消息返回");

		create.addExcel("登录资源消耗", (flow - initialFlow), cpu, memory, false);
	}

	@Test(dependsOnMethods = "test030XiaoXiZhongXin")
	public void test040WoDeShouCang() {

		up.log("测试我的收藏资源消耗");
		double initialFlow = up.getFlow();

		up.verifyIsShown("我的收藏");
		up.clickOn("我的收藏");
		up.verifyIsShown("收藏标题");

		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.log("我的收藏消耗流量：" + (flow - initialFlow) + "KB.", 4);
		up.log("我的收藏CPU占用：" + cpu + "%.", 4);
		up.log("我的收藏内存占用：" + memory + "MB.", 4);
		up.clickOn("收藏返回");

		create.addExcel("我的收藏资源消耗", (flow - initialFlow), cpu, memory, false);
	}

	@Test(dependsOnMethods = "test040WoDeShouCang")
	public void test050YuJingGuanLi() {

		up.log("测试预警管理资源消耗");
		double initialFlow = up.getFlow();

		up.verifyIsShown("预警管理");
		up.clickOn("预警管理");
		up.verifyIsShown("预警标题");

		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.log("预警管理消耗流量：" + (flow - initialFlow) + "KB.", 4);
		up.log("预警管理CPU占用：" + cpu + "%.", 4);
		up.log("预警管理内存占用：" + memory + "MB.", 4);
		up.clickOn("预警返回");

		create.addExcel("预警管理资源消耗", (flow - initialFlow), cpu, memory, false);
	}

	@Test(dependsOnMethods = "test050YuJingGuanLi")
	public void test060YiJianFanKui() {

		up.log("测试意见反馈资源消耗");
		double initialFlow = up.getFlow();

		up.verifyIsShown("意见反馈");
		up.clickOn("意见反馈");
		up.verifyIsShown("意见标题");

		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.log("意见反馈消耗流量：" + (flow - initialFlow) + "KB.", 4);
		up.log("意见反馈CPU占用：" + cpu + "%.", 4);
		up.log("意见反馈内存占用：" + memory + "MB.", 4);
		up.clickOn("意见返回");

		create.addExcel("意见反馈资源消耗", (flow - initialFlow), cpu, memory, false);
	}

	@Test(dependsOnMethods = "test060YiJianFanKui")
	public void test070SheZhi() {

		up.log("测试设置资源消耗");
		double initialFlow = up.getFlow();

		up.verifyIsShown("设置");
		up.clickOn("设置");
		up.verifyIsShown("设置名称");

		double flow = up.getFlow();
		double cpu = up.getCPU();
		double memory = up.getMemory();

		up.log("设置消耗流量：" + (flow - initialFlow) + "KB.", 4);
		up.log("设置CPU占用：" + cpu + "%.", 4);
		up.log("设置内存占用：" + memory + "MB.", 4);
		up.clickOn("设置返回");

		create.addExcel("设置资源消耗", (flow - initialFlow), cpu, memory, false);
	}
}
