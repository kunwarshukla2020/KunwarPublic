package com.mycode.utility;

public class Utility {

	private Utility() {
		/* Non-instantiable class */ }

	public static void display(String[] a) {
		System.out.print("\nString array:");
		for (String i : a) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	public static void display(int[] a) {
		System.out.print("\nint array:");
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	public static void display(char[] a) {
		System.out.print("char array:");
		for (char i : a) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	public static void display(Integer[] a) {
		System.out.print("int array:");
		for (Integer i : a) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
}
