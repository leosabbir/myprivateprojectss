package com.hogwart.crackthecode.client;

public class Sandbox {
	public static void main(String[] args) {
		for(int i=0; i < 100; i++){
			System.out.print((int) (Math.random() * 8)+1);
			System.out.print(" ");
		}
	}
}
