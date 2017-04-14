package algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class kthSmallest7 {

	static int index = 0;
	static int pivot = 0;

	public static int ksmallest(int[] s, int firstIndex, int lastIndex, int k) {

		int n = (lastIndex - firstIndex) + 1;// size of the array
		int numOfChunks = 0; // to see how many groups of 5 elements
		if (n % 7 == 0)
			numOfChunks = n / 7;

		else
			numOfChunks = (n / 7) + 1;
		int[] medians = new int[numOfChunks];

		int i = 1;
		if (n >= 7) {
			int x = 0;
			int y = 6;

			for (i = 1; i <= n / 7; i++) {

				Quicksort.quickSort(s, x, y);

				int z = (int) Math.ceil((x + y) / 2);

				medians[i - 1] = s[z];
				x = x + 7;
				y = y + 7;

			}

			if ((i - 1) * 7 < n) {
				Quicksort.quickSort(s, ((i - 1) * 7), lastIndex);
				medians[i - 1] = s[((i - 1) * 7) + (int) Math.ceil(((n - 1) - ((i - 1) * 7)) / 2)];

			}
		} else {
			Quicksort.quickSort(s, firstIndex, lastIndex);
			medians[i - 1] = s[(firstIndex + lastIndex) / 2];

		}
		for (int m = 0; m < medians.length; m++)
			
		if (medians.length > 2) {

			Quicksort.quickSort(medians, 0, medians.length - 1);

		} else
			

			for (int j = firstIndex; j <= lastIndex; j++) {
				if (s[j] == pivot) {
					index = j;
					break;
				}
			}
		if (k > 0 && k <= (lastIndex - firstIndex) + 1) {

			int p = pivotFind(s, firstIndex, lastIndex);

			
			if (p - firstIndex == k - 1)
				return s[p];
			else if (p - firstIndex > k - 1)
				return ksmallest(s, firstIndex, p - 1, k);
			else
				return ksmallest(s, p + 1, lastIndex, k - p + firstIndex - 1);
		} else {
			return 1;
		}
	}

	static int pivotFind(int b[], int first, int last) {

		swap(b, first + index, last);
		return partition(b, first, last);
	}

	public static void swap(int[] b, int i, int j) {
		int temp = 0;
		temp = b[i];
		b[i] = b[j];
		b[j] = temp;
	}

	static int partition(int b[], int first, int last) {
		int x = 0, i = 0;
		x = b[last];
		i = first;
		for (int j = first; j <= last - 1; j++) {
			if (b[j] <= x) {
				swap(b, i, j);
				i++;
			}
		}
		swap(b, i, last);
		return i;
	}

	public static void main(String arg[]) throws NumberFormatException, IOException {
		FileReader inputfile = new FileReader("D://algos.txt");
		BufferedReader bufferedReader = new BufferedReader(inputfile);
		int x = Integer.parseInt(bufferedReader.readLine());
		int[] b = new int[x];
		int k = Integer.parseInt(bufferedReader.readLine());
		for (int i = 0; i < x; i++) {
			b[i] = Integer.parseInt(bufferedReader.readLine());

		}
		File file = new File("D://Algorithms//outputkthsmallest7.txt");

		if (!file.exists()) {
			file.createNewFile();
		}
		long start = System.nanoTime(); // starting timer
		int smallest = ksmallest(b, 0, b.length - 1, k);
		long time = System.nanoTime() - start; // ending timer
		System.out.println("time taken:" + time + " nano second");
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(smallest + " ");
		bw.close();

	}

}