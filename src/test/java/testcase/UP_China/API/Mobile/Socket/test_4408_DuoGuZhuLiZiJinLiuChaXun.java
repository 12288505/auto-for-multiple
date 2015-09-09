package testcase.UP_China.API.Mobile.Socket;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_4408_DuoGuZhuLiZiJinLiuChaXun {
	private UP_API up ; 
	@Test
	public void Test4408(){
		up = new UP_API() ; 
		up.getSocketBody(4408); 
		for( int i = 1 ; i < 17 ;i++){
			up.assertBody(String.valueOf(i) ) ;
		}
	}
}
