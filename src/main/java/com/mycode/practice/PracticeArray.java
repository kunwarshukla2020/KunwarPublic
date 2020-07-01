package com.mycode.practice;

/**
 *  Three questions here, uncomment method and check
 */
public class PracticeArray {
	public static void main(String[] args) {
		PracticeArray pa = new PracticeArray();
		// hourglassSum();
		// minimumBribes();
		validBinaryString();
	}

	// https://www.hackerrank.com/contests/hack-the-interview-iv/challenges/good-binary-string
	private static void validBinaryString() {
		// String s = "00100";//c=2
		String s = "0001"; // c=1
		//String s = "1001000010"; d=3// ans should be 1
		int d = 2;
		int c = 0;
		String[] stringArr = new String[s.length()];
		for (int i = 0; i < s.length(); i++) {
			stringArr[i] = s.charAt(i) + "";
		}
		display(stringArr);
		if (checkValid(stringArr, d)) {
			System.out.println("\nValid string - c: " + c);
			return;
		}

		int i = d - 1;
		while (i < s.length()) {
			if (!stringArr[i].equals("1")) {
				stringArr[i] = "1";
				c++;
			}
			display(stringArr);
			if (checkValid(stringArr, d)) {
				break;
			}
			i = i + d;
		}
		display(stringArr);
		System.out.println("c: " + c);
	}

	private static boolean checkValid(String[] stringArr, int d) {
		String s = "";
		int j;
		int k = 0;

		for (int i = 0; i < stringArr.length && k < stringArr.length; i++) {
			k = i;
			for (j = 0; j < d && k < stringArr.length; j++) {
				s = s + stringArr[k++];
			}
			// System.out.print("\nsubstring: "+s);
			if (s.contains("1")) {
				s = "";
				continue;
			} else {
				return false;
			}
		}
		return true;

	}

	private static void display(String[] a) {
		System.out.println();
		for (String i : a) {
			System.out.print(i + " ");
		}
	}

	// https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays&h_r=next-challenge&h_v=zen
	// 1 2 3 4 5
	// This works too
//	static void minimumBribes() {
//		int q[] = {2, 1, 5, 3, 4}; //3
//		//int q[] = { 1, 2, 3, 5, 4 };
//		//int q[] = {2, 5, 1, 3, 4}; //Too chaotic
//		int ans = 0;
//		for (int i = q.length - 1; i >= 0; i--) {
//			int ch_pos = q[i] - (i + 1);
//			if (ch_pos > 2) {
//				System.out.println("Too chaotic");
//				return;
//			} else {
//				int st = Math.max(0, q[i] - 2);
//				for (int j = st; j < i; j++) {
//					if (q[j] > q[i])
//						ans++;
//				}
//			}
//		}
//		System.out.println(ans);
//	}

	// 2 5 1 3 4 - Too chaotic
	// 2 1 5 3 4 - 3
	// https://www.youtube.com/watch?v=YWYF6bOhPW8

	// Initial position - 1 2 3 4 5 6 7 8
	// Current position - 1 2 3 5 7 8 6 4
	static void minimumBribes() {
		int swapCount = 0;
		// int arr[] = { 2, 1, 5, 3, 4 }; // 3
		int arr[] = { 1, 2, 3, 5, 7, 8, 6, 4 }; // 6
		for (int i = arr.length - 1; i >= 0; i--) {

			if (arr[i] != i + 1) { // filter cases, when you do not bribe, be at the ith position wherever you are

				if (((i - 1) >= 0) && arr[i - 1] == (i + 1)) { // 1)Being at initial ith position, valid current
																// position after given bribe can be (i-1)th position
					swapCount++;
					swap(arr, i, i - 1);
				} else if (((i - 2) >= 0) && arr[i - 2] == (i + 1)) { // 2)Being at initial ith position, valid current
																		// position after given bribes can be (i-2)th
																		// position
					swapCount += 2;
					swap(arr, i - 2, i - 1);
					swap(arr, i - 1, i);
				} else { // 3)Too chaotic (trying to bribe more than 2 people which is ahead of you)
					System.out.println("Too chaotic");
					return;
				}
			}

		}
		System.out.println(swapCount);

	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	// https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
	static void hourglassSum() {
		// 1 1 1 0 0 0
		// 0 1 0 0 0 0
		// 1 1 1 0 0 0
		// 0 0 2 4 4 0
		// 0 0 0 2 0 0
		// 0 0 1 2 4 0

//		int a[][] = { {1,1,1,0,0,0},
//					{0,1,0,0,0,0},
//					{1,1,1,0,0,0},
//					{0,0,2,4,4,0},
//					{0,0,0,2,0,0},
//					{0,0,1,2,4,0}};

//		int a[][] = {   {1,2,3,4},
//						{5,6,7,8},
//						{9,1,1,2},
//						{3,4,5,6}};

		int a[][] = { { 0, -4, -6, 0, -7, -6 }, { -1, -2, -6, -8, -3, -1 }, { -8, -4, -2, -8, -8, -6 }, { -3, -1, -2, -5, -7, -4 }, { -3, -5, -3, -6, -6, -6 }, { -3, -6, 0, -8, -6, -7 } };

		int sum = 0;
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < (a.length - 2); i++) {
			for (int j = 0; j < (a.length - 2); j++) {
				System.out.println(a[i][j] + " " + a[i][j + 1] + " " + a[i][j + 2] + " ");
				System.out.println("  " + a[i + 1][j + 1] + " ");
				System.out.println(a[i + 2][j] + " " + a[i + 2][j + 1] + " " + a[i + 2][j + 2] + " ");

				sum = sum + a[i][j] + a[i][j + 1] + a[i][j + 2];
				sum = sum + a[i + 1][j + 1];
				sum = sum + a[i + 2][j] + a[i + 2][j + 1] + a[i + 2][j + 2];
				// System.out.println("sum: "+sum);
				if (sum >= result) {
					result = sum;
				}
				sum = 0;
			}
			System.out.println(" ");
		}
		System.out.println("result: " + result);
	}

}