package com.mycode.utility;

public class CommonUtility {

	private CommonUtility() {
		/* Non-instantiable class */ }

	public static void display(String[] a) {
		System.out.print("\nString array:");
		for (String i : a) {
			System.out.print(i + " ");
		}
	}

	public static void display(int[] a) {
		System.out.print("\nint array:");
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	public static void display(char[] a) {
		System.out.print("char array:");
		for (char i : a) {
			System.out.print(i + " ");
		}
	}
}
