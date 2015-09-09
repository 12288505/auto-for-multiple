package testcase.UP_China.API.Mobile.Socket;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_4202_ZuHeHangQing {

	private UP_API up;

	@Test
	public void test_4202() {

		up = new UP_API();
		// up.Test4202Protocol();
		up.getSocketBody(4202);
		// 接下来解析这个字符串的正确性
		// for( int i = 1 ; i < 40 ;i++){
		// if( i == 3 || i == 4 || i == 26 || i == 27 || i == 33 || i == 34 )
		// continue ;
		// else
		// up.assertJsonBody(String.valueOf(i)) ;
		// }
		up.assertJsonBody("1");
		up.assertJsonBody("2");
		up.assertJsonBody("3");
		up.assertJsonBody("4");
		up.assertJsonBody("5");
		up.assertJsonBody("6");
		up.assertJsonBody("7");
		up.assertJsonBody("8");
		up.assertJsonBody("9");
		up.assertJsonBody("10");
		up.assertJsonBody("11");
		up.assertJsonBody("12");
		up.assertJsonBody("13");
		up.assertJsonBody("14");
		up.assertJsonBody("15");
		up.assertJsonBody("16");
		up.assertJsonBody("17");
		up.assertJsonBody("18");
		up.assertJsonBody("19");
		up.assertJsonBody("20");
		up.assertJsonBody("21");
		up.assertJsonBody("22");
		up.assertJsonBody("23");
		up.assertJsonBody("24");
		up.assertJsonBody("25");
		up.assertJsonBody("26");
		up.assertJsonBody("27");
		up.assertJsonBody("28");
		up.assertJsonBody("29");
		up.assertJsonBody("30");
		up.assertJsonBody("31");
		up.assertJsonBody("32");
		up.assertJsonBody("33");
		up.assertJsonBody("34");
		up.assertJsonBody("35");
		up.assertJsonBody("36");
		up.assertJsonBody("37");
		up.assertJsonBody("38");
		up.assertJsonBody("39");

	}
}
