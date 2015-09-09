package testcase.UP_China.API.Mobile.Socket;

import org.testng.annotations.Test;

import fwk.UP_API;

public class test_4407_GeGuZhuLiCheDanMingXi {
	private UP_API up ; 
	@Test
	public void Test4407(){
		up = new UP_API() ; 
		up.getSocketBody(4407) ; 
		for( int i = 1 ; i < 9 ;i++){
			if( i >= 3 && i <= 4){
				continue ; 
			}
			up.assertJsonBody(String.valueOf(i));
		}
	}
}
