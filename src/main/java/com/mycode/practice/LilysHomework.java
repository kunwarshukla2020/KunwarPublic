package com.mycode.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.mycode.utility.Utility;

//https://www.hackerrank.com/challenges/lilys-homework/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
// Minimum number of swaps to do sorting either descending or ascending
public class LilysHomework {

	public static void main(String[] args) {
		// int arr[] = new int[] { 7, 15, 12, 3 };
		int[] arr = { 3, 4, 2, 5, 1 };
		lilysHomework(arr);
	}

//	static void lilysHomework1(int[] arr) {
//
//		boolean isVisited[] = new boolean[arr.length + 1];
//		HashMap<Integer, Integer> nodeMap = new HashMap<Integer, Integer>();
//		for (int i = 1; i < isVisited.length; i++) {
//			nodeMap.put(i, arr[i - 1]);
//		}
//		System.out.println("nodeMap :" + nodeMap);
//		int countSwap = 0;
//		for (int k = 1; k <= nodeMap.size(); k++) {
//			int nextNode;
//			if (isVisited[k] == false) {
//				isVisited[k] = true;
//				if (k == nodeMap.get(k)) {
//					continue;
//				} else {
//					int value = nodeMap.get(k);
//					while (!isVisited[value]) {
//						isVisited[value] = true;
//						nextNode = nodeMap.get(value);
//						value = nextNode;
//						++countSwap;
//					}
//				}
//			}
//		}
//		System.out.println("swap count :" + countSwap);
//	}

	// org arr  3 4 2 5 1
	// sort arr 1 2 3 4 5 ---> compare sort arr with org
	// map -   30,41,22,53,14 - {1=4, 2=2, 3=0, 4=1, 5=3}(org arr data, index)- map tells org array element with position.When iterating sorted array we know where in org array element resides
	// org arr  1 4 2 5 3  ^
	// map     14,41,22,53,34-{1=4, 2=2, 3=4, 4=1, 5=3} - 1 position is not updated as we are not using it any more.
	// org arr  1 2 4 5 3  ---> compare sort arr with org
	// org arr  1 2 3 5 4  ---> compare sort arr with org
	// org arr  1 2 3 4 5  ---> compare sort arr with org
	static void lilysHomework(int[] arr) {

		int sortedSwaps = 0;
		Integer[] arrSort = new Integer[arr.length];
		Map<Integer, Integer> map1 = new HashMap<>();

		int sortedReverseSwaps = 0;
		int[] arr2 = new int[arr.length];
		Map<Integer, Integer> map2 = new HashMap<>();

		// Initialize our arrays and maps
		for (int i = 0; i < arr.length; i++) {
			arrSort[i] = arr[i];
			arr2[i] = arr[i]; // copy arr to arr2
			map1.put(arr[i], i); // map (arr data, index)
			map2.put(arr[i], i);
		}

		System.out.println("map1: " + map1);
		Arrays.sort(arrSort); // Sort the input ascending
		Utility.display(arrSort);

		for (int i = 0; i < arrSort.length; i++) {
			if (arrSort[i] != arr[i]) { // compare sorted arr with org
				// swap the element from arr to the right position
				int tmp = arr[i];
				int index = map1.get(arrSort[i]);
				arr[i] = arr[index];
				arr[index] = tmp;
				// Update index after swap
				map1.put(tmp, index);
				sortedSwaps++;
				//Utility.display(arr);
			}
		}
		System.out.println("map1: " + map1);
		System.out.println("sortedSwaps: " + sortedSwaps);

		// System.out.println("map2: " + map2);
		Arrays.sort(arrSort, Collections.reverseOrder());// Sort the input descending

		for (int i = 0; i < arr.length; i++) {
			if (arr2[i] != arrSort[i]) {
				// swap the element from homework to the right position
				int tmp = arr2[i];
				arr2[i] = arr2[map1.get(arrSort[i])];
				arr2[map2.get(arrSort[i])] = tmp;
				// Update index after swap
				map2.put(tmp, map2.get(arrSort[i]));
				sortedReverseSwaps++;
			}
		}
		System.out.println("sortedReverseSwaps: " + sortedReverseSwaps);
		System.out.println(Math.min(sortedSwaps, sortedReverseSwaps));// Choose the smallest of the two possible smallest
	}

	// Time Complexity: O(n log(n)) //We must sort the input
	// Space Complexity: O(n) //We store the input in an array
	// can delete
	static void lilysHomework1(int[] arr) {
		int n = arr.length;
		int sortedSwaps = 0;
		int[] homework = new int[n];
		Integer[] homeworkSorted = new Integer[n];
		Map<Integer, Integer> original = new HashMap<>();

		int sortedReverseSwaps = 0;
		int[] homework2ndCopy = new int[n];
		Map<Integer, Integer> original2ndCopy = new HashMap<>();

		// Initialize our arrays and maps
		for (int i = 0; i < n; i++) {
			homeworkSorted[i] = arr[i];
			homework[i] = homeworkSorted[i];
			homework2ndCopy[i] = homeworkSorted[i];
			original.put(homework[i], i);
			original2ndCopy.put(homework2ndCopy[i], i);
		}

		Arrays.sort(homeworkSorted);// Sort the input ascending

		for (int i = 0; i < n; i++) {
			if (homework[i] != homeworkSorted[i]) {
				// swap the element from homework to the right position
				int tmp = homework[i];
				homework[i] = homework[original.get(homeworkSorted[i])];
				homework[original.get(homeworkSorted[i])] = tmp;
				// Update index after swap
				original.put(tmp, original.get(homeworkSorted[i]));
				sortedSwaps++;
			}
		}

		Arrays.sort(homeworkSorted, Collections.reverseOrder());// Sort the input descending

		for (int i = 0; i < n; i++) {
			if (homework2ndCopy[i] != homeworkSorted[i]) {
				// swap the element from homework to the right position
				int tmp = homework2ndCopy[i];
				homework2ndCopy[i] = homework2ndCopy[original.get(homeworkSorted[i])];
				homework2ndCopy[original2ndCopy.get(homeworkSorted[i])] = tmp;
				// Update index after swap
				original2ndCopy.put(tmp, original2ndCopy.get(homeworkSorted[i]));
				sortedReverseSwaps++;
			}
		}
		System.out.println(Math.min(sortedSwaps, sortedReverseSwaps));// Choose the smallest of the two possible smallest
	}
}
