package testcase.UP_China.API.Mobile.Socket;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_4402_TuoLaJiDanGeGuLieBiao {
	private UP_API up ; 
	@Test
	public void Test4402(){
		up = new UP_API() ; 
		up.getSocketBody(4402) ; 
		for( int i = 1 ; i < 21 ;++i){
			up.assertJsonBody(String.valueOf(i) ) ; 
		}
	}
}
