package com.mycode.practice;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PracticeArray1 {
	public static void main(String[] args) {
		PracticeArray1 pa = new PracticeArray1();

		int[] e = { 2, 3, 4, 2, 3, 6, 8, 4, 5 };
		int d = 5;
		activityNotifications(e, d);
	}

	static int activityNotifications(int[] e, int d) {
		int k = 0;
		int j = 0;
		int c =0;
		int temp []= new int[d];
		for(int i = 0; i<e.length;i++) {
			for(j = i; j<d+i && j<e.length; j++) {
				temp[k]=e[j];
				k++;
			}
			int median = getMedian(temp);
			//System.out.println(e[j]+"> median: "+median);
			if (j<e.length) {
				
				if (e[j] >= median*2) {
					System.out.println(true);
					c++;
				}
			}
			
			k =0;
		}
		System.out.println("c: "+c);
		return c;
	}

	private static int getMedian(int[] temp) {
		display(temp);
		int index = 0;
		Arrays.sort(temp);
		//display(temp);
		if(temp.length%2==0) {
			index = temp.length/2;
			return (temp[index]+temp[index-1]/2);
		}else {
			index = temp.length/2;
		}
		return temp[index];
	}

	private static void display(int[] a) {
		System.out.println();
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}