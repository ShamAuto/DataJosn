package com.example;

public class test_01 {
	
	public static void main(String[] args) {
		
		String str="This is shameem from Nepal";
		String[] str1=str.split(" ");
		for(int i=0; i<str1.length ; i++){
			String str2=str1[i].substring(1, 2);
			System.out.println(str1[i]+" ---"+str2);
		}
	}
}
