package testcase.UP_China.API.Mobile.Socket;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_4411_KuoZhanJianBanZuHeHangQing {
	private UP_API up  ; 
	@Test
	public void Test4411(){
		up = new UP_API();
		// up.Test1802Protocol() ;
		up.getSocketBody(4411);
		for( int i = 1 ; i < 15 ;i++){
			up.assertBody(String.valueOf(i)) ; 
		}
	}
}
