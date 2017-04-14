package algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Quickinsert {
	public static int y;

	public static void quickInsert(int[] b) {

	}

	public static void insertionSort(int[] b, int first, int last) {
		int x = 0;
		int i = 0;

		for (i = first + 1; i <= last; i++) {
			int temp = b[i];
			x = i;

			while (x > first && b[x - 1] >= temp) {
				b[x] = b[x - 1];
				--x;
			}
			b[x] = temp;
		}

	}

	public static void quickSort(int[] b, int first, int last) {

		if ((last - first) <= y) {

			insertionSort(b, first, last);
		} else {

			int q = partition(b, first, last);

			quickSort(b, first, q);
			quickSort(b, q + 1, last);
		}

	}

	public static int partition(int[] a, int first, int last) {
		int x = 0, i = 0, j = 0;
		boolean flag = true;
		x = a[first];
		i = first - 1;
		j = last + 1;
		while (flag) {
			i++;

			while (i < last && a[i] < x)
				i++;
			j--;
			while (j > first && a[j] > x)
				j--;

			if (i < j)
				swap(a, i, j);
			else
				return j;

		}
		return j;

	}

	public static void swap(int[] a, int i, int j) {
		int temp = 0;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		FileReader inputfile = new FileReader("D://Algorithms//algosinput.txt");
		BufferedReader bufferedReader = new BufferedReader(inputfile);
		int x = Integer.parseInt(bufferedReader.readLine());
		y = Integer.parseInt(bufferedReader.readLine());
		int[] b = new int[x];

		for (int i = 0; i < x; i++) {
			b[i] = Integer.parseInt(bufferedReader.readLine());

		}
		File file = new File("D://Algorithms//quickinsert.txt");

		if (!file.exists()) {
			file.createNewFile();
		}
		long start = System.currentTimeMillis(); // starting timer
		quickSort(b, 0, b.length - 1);
		long time = System.nanoTime() - start; // ending timer
		System.out.println("time taken:" + time + " nano second");
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = 0; i < b.length; i++) {
			bw.write(b[i] + " ");

		}
		bw.close();
	}
}