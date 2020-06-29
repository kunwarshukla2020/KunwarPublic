package com.mycode.sortingalgorithm;

//https://www.youtube.com/watch?v=F13_wsHDIG4
// Time Complexity - O(n^2)
// Good for small data set
class BubbleSort {

	public static void main(String[] args) {
		BubbleSort m = new BubbleSort();
		int a[] = { 2, 6, 3, 4, 1 };
		System.out.print("Before sorting: ");
		m.display(a);
		m.sort(a);
		System.out.print("\nAfter sorting : ");
		m.display(a);
	}

	private void display(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}

	}

	// Greater element move to right
	// 5 8 1 6 9 2
	// 5 1 8 6 2 9
	// 5 1 6 8 2 9
	// ..
	private void sort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					// swap temp and arr[i]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

}
