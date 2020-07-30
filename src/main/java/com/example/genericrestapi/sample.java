package com.example.genericrestapi;

public class sample {
	
	
	public static void main(String[] args) {
		
	System.out.println(calculate(18, 2));;
		
	}
	
	
	public static int calculate (int coins,int allIn ) {
		int rounds=0;
		System.out.println( Math.round(coins%2));
		for(int i =1;i<=allIn;i++) {
		if(coins%2==0) {
			rounds++;
			coins=coins/2;
		} else {
			rounds++;
			coins=coins-1;
			i--;
		}
	
		}
		//allins are done 
		for(int coin=1;coin<coins;coin++) {
			rounds++;
			
		}
		return rounds;
	}

}
