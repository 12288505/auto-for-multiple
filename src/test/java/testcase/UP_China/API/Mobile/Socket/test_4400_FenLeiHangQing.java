package testcase.UP_China.API.Mobile.Socket;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_4400_FenLeiHangQing {
	private UP_API up ; 
	@Test
	public void Test4400(){
		up = new UP_API();
		// up.Test1802Protocol() ;
		up.getSocketBody(4400);
		for (int i = 1; i < 41; i++) {
//			 if( i == 6 ){
//			 continue ;
//			 }
//			 if( i >= 12 && i <= 13){
//				 continue ;
//			 }
//			 if( i >= 17 && i <= 19){
//				 continue ;
//				 }
//			 if( i >= 21 && i <= 37 ){
//				 continue ;
//				 }
			up.assertJsonBody(String.valueOf(i));
		}
	}
	
}
