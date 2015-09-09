package testcase.UP_China.API.Mobile.Socket;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_4401_DuoGuDDEChaXun {
	private UP_API up ; 
	@Test
	public void Test4401(){
		up = new UP_API();
		// up.Test1802Protocol() ;
		up.getSocketBody(4401);
		for( int i = 1 ; i < 16 ;i++){
			up.assertBody(String.valueOf(i) ) ;
		}
	}
}
