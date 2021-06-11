package ArrayProblem;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution1672 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] accounts = {{2,8,7},{7,1,3},{1,9,5}};
//		ArraySolution1672 s = new ArraySolution1672();
//		System.out.println(s.maximumWealth(accounts));
		
		//Å£¿ÍÍø¸ñÊ½
		
	}

}
class ArraySolution1672 {
    public int maximumWealth(int[][] accounts) {
    	int people = accounts.length;
    	int Maxmoney = 0;
    	for(int i = 0;i<people;i++) {
    		int money = 0;
    		for(int j = 0;j< accounts[0].length;j++) {
    			money += accounts[i][j];
    		}
    		if(Maxmoney < money) {
    			Maxmoney = money;
    		}
    	}
    	return Maxmoney;
    }
}