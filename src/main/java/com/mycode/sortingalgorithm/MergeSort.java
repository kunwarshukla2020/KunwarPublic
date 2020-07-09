package com.mycode.sortingalgorithm;

//https://www.youtube.com/watch?v=yv6svAfoYik
// check quick sort too - https://www.youtube.com/watch?v=Fiot5yuwPAg
// ALso check for -Counting Sort Algorithm
class MergeSort {

	// 26341
	// 26 341 =>241341
	// 2 6 3 4 1
	// 2 6 1 3 4
	public static void main(String[] args) {
		MergeSort m = new MergeSort();
		/*int a[] = { 2, 6, 3, 4, 1 };
		m.display(a);
		a = m.sort(a);
		System.out.print("After sorting: ");
		m.display(a);*/
		
		int [] arr = { 3, 4, 2, 5, 1};
		System.out.print(m.lilysHomework(arr));
	}
	
	static int lilysHomework(int[] arr) {
        int n = arr.length;
        if(arr == null || n==0){
            return 0;
        }
        int c1 = 0;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[i] > arr[j]) {
                    c1++;
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(c1);
        int c2 = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[i] < arr[j]) {
                    c2++;
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(c2);
        return c2;

    }

	private void display(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}

	}
	//Recursion
	private int[] sort(int[] a) {
		if (a != null && a.length <= 1) {
			return a;
		}
		int midpoint = a.length / 2;
		int left[] = new int[midpoint];
		int right[] = new int[a.length - left.length];
		for (int i = 0; i < left.length; i++) {
			left[i] = a[i];
		}
		for (int j = 0; j < right.length; j++) {
			right[j] = a[j + midpoint];
		}

		left = sort(left);
		right = sort(right);

		int result[] = new int[a.length];
		result = merge(left, right);

		return result;
	}

	private int[] merge(int[] left, int[] right) {
		int leftPointer, rightPointer, resultPointer;
		leftPointer = rightPointer = resultPointer = 0;
		int result[] = new int[left.length + right.length];
		while (leftPointer < left.length || rightPointer < right.length) {

			if (leftPointer < left.length && rightPointer < right.length) {
				if (left[leftPointer] <= right[rightPointer]) {
					result[resultPointer++] = left[leftPointer++];
				} else {
					result[resultPointer++] = right[rightPointer++];
				}
			} else if (leftPointer < left.length) {
				result[resultPointer++] = left[leftPointer++];
			} else if (rightPointer < right.length) {
				result[resultPointer++] = right[rightPointer++];
			}
		}
		return result;
	}

}
