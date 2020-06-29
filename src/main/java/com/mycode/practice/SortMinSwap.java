package com.mycode.practice;

//https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
class SortMinSwap {

	public static void main(String[] args) {
		
		SortMinSwap m = new SortMinSwap();
		//int a[] = { 4, 3, 1, 2 }; //c=3
		//int a[] = { 2, 3 ,4, 1, 5 };//c=3
		int a[] = { 7, 1 ,3, 2, 4,5,6 };// c=5
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

	//4 3 1 2
	//1 3 4 2
	//1 2 4 3
	//1 2 3 4
	
	//2 3 4 1 5
	//1 3 4 2 5
	//1 2 4 3 5
	//1 2 3 4 5
	private void sort(int[] arr) {
		int c = 0;
		for (int i = 0; i < arr.length; i++) {
				if (arr[i] != i+1) {
					//find i+1 and swap a[i+1]
					swap(arr, arr[i],i+1);
					//System.out.println("");
					display(arr);
					c++;
				}
		}
		System.out.println("swap count: "+c);
	}

	private void swap(int[] arr, int i, int j) {
		int index1 = 0;
		int index2 = 0;
		int temp = 0;
		for(int k=0; k<arr.length;k++) {
			if(arr[k] == i) {
				index1 = k;
			}
			if(arr[k] == j) {
				index2 = k;
			}
		}
		temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}


}
