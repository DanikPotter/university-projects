import java.util.ArrayList;
import java.util.Iterator;

public class ArraySort {

	// Part 2: complete implementation
	public static void bubbleSort(int[] arr) {
		boolean stop = false;
		int j = 0;
		int tmp;
		while (!stop && !isSorted(arr)) {
			if (j == arr.length) {
				stop = true;
			}
			j++;
			for (int i = 0; i < arr.length - j; i++) {
				if (arr[i] > arr[i + 1]) {
					tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
				}
			}
		}
	}

	// Part 3 : complete implementation
	public static void quickSort(ArrayList<Integer> S) {
		if (!S.isEmpty()) {
			int pivot = S.get(0);
			ArrayList<Integer> L, E, G;
			L = new ArrayList<Integer>();
			E = new ArrayList<Integer>();
			G = new ArrayList<Integer>();
			
			 for (Integer i: S) {
			        if (i.compareTo(pivot) < 0)
			            L.add(i);
			        else if (i.compareTo(pivot) > 0)
			            G.add(i);
			        else
			            E.add(i);
			    }
			 
			quickSort(L);
			quickSort(G);
			
			S.clear();		
			S.addAll(L);
			S.addAll(E);
			S.addAll(G);
		}
	}

	// predicate to check if array is sorted
	public static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++)
			if (arr[i] > arr[i + 1])
				return false;
		return true;
	}

	// predicate to check if arrayList is sorted
	public static boolean isSorted(ArrayList<Integer> ar) {
		Iterator i = ar.iterator();
		int val;
		if (i.hasNext())
			val = (int) i.next();
		else
			return true;
		while (i.hasNext()) {
			int nv = (int) i.next();
			if (val > nv)
				return false;
			val = nv;
		}
		return true;
	}

	/*
	 * Helper printing methods for testing
	 */
	private static void printIntArray(int[] arr) {
		System.out.print("[ ");
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}

	private static void printIntArrayList(ArrayList<Integer> arr) {
		System.out.print("[ ");
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}

	public static void main(String[] args) {
		// testing part1
		int[] arr1 = { 5, 4, 3, 2, 1 };
		bubbleSort(arr1);
		printIntArray(arr1);

		// testing part2
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(3);
		arr2.add(1);
		arr2.add(6);
		arr2.add(5);
		quickSort(arr2);
		printIntArrayList(arr2);
		// {5,4,3,5,1};

	}

}
