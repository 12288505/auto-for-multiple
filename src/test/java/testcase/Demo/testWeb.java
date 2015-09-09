package testcase.Demo;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import fwk.UP_Web;

public class testWeb {

	private UP_Web up;
	
	@Test
	public void test010WebPage() {
		up = new UP_Web();
		
		up.openApp();
		up.verifyIsShown("公司介绍more");
		up.verifyIsShown("研究所more");
		up.verifyIsShown("公司资质more");
		up.verifyIsShown("商务合作more");
		
		up.clickOn("关于我们");
		up.verifyIsShown("公司介绍");
		
		up.hover("投资卫士");
		up.clickOn("电脑版");
		up.switchPopupNewWindow();
		Assert.assertTrue(StringUtils.equals("优品财富-UP安全投资卫士", up.getTitle()));
		up.closeCurrentWindow();
		
		up.clickOn("研究所");
		up.verifyIsShown("优品金融研究所");
		
		up.clickOn("商务合作");
		up.verifyIsShown("战略合作");
		
		up.clickOn("首页");
		up.verifyIsShown("公司介绍more");
		
		up.close();
		
	} 
}