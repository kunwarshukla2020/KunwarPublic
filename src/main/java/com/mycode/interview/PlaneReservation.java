package com.mycode.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PlaneReservation {
	public static void main(String[] args) {
		int N = 2;
		String S = "1A 2F 1C";
		// String S = "11 26 13";
		System.out.println("test1--->" + new PlaneReservation().solution(N, S));
	}

	public int solution(int N, String S) {
		List<String> list1 = new ArrayList<>();
		if (S != null && !S.isEmpty()) {
			List<String> list = new ArrayList<>(Arrays.asList(S.split("\\s+")));
			HashMap<String, String> map = new HashMap<>();
			map.put("a", "0");
			map.put("b", "1");
			map.put("c", "2");
			map.put("d", "3");
			map.put("e", "4");
			map.put("f", "5");
			map.put("g", "6");
			map.put("h", "7");
			map.put("j", "8");
			map.put("k", "9");
			map.put("A", "0");
			map.put("B", "1");
			map.put("C", "2");
			map.put("D", "3");
			map.put("E", "4");
			map.put("F", "5");
			map.put("G", "6");
			map.put("H", "7");
			map.put("J", "8");
			map.put("K", "9");

			for (String s : list) {
				String row = s.charAt(0) + "";
				int r = Integer.parseInt(row) - 1;
				String c = map.get(s.charAt(1) + "");
				list1.add(r + c);
			}
		} else {
			list1 = null;
		}
		System.out.println("list1-->" + list1);
		String a[][] = new String[N][10];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				a[i][j] = i + "" + j + "";
				if (list1 != null && list1.contains(a[i][j])) {
					a[i][j] = "X";
				}
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		int c = 0;
		int f = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				// System.out.println("a[i][j]:"+a[i][j]);
				if (a[i][j] != "X") {
					c = c + 1;
				} else {
					c = 0;
				}
				if (c == 4) {
					f = f + 1;
					c = 0;
				}
			}
			c = 0;
		}
		return f;
	}

}
