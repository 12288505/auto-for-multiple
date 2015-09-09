package testcase.Demo;

import org.testng.annotations.Test;

import fwk.UP_API;

public class testAPI {

	private UP_API up;

	@Test
	public void test010webservice() {

		up = new UP_API("http://api.0135135.com", "GET");
		String path = up.getApiPath("WebServiceDemo");
		up.path(path);

		up.openApp();

		up.assertBody("FCODE");
		up.assertBody("FTYPE");

	}

	@Test
	public void test020PHP() {

		up = new UP_API("http://app.0135135.com", "POST");
		String path = up.getApiPath("PHPDemo");
		up.path(path);

		up.openApp();

		up.assertBody("明星分析师荐股");
		up.assertBody("证券代码");
		up.assertBody("分析师");
		up.assertBody("投资评级");

	}
}
