package algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Quicksort {

	public static void quickSort(int[] b, int first, int last) {
		int q = 0;
		if (first < last) {
			q = partition(b, first, last);
			quickSort(b, first, q);
			quickSort(b, q + 1, last);

		}
	}

	public static int partition(int[] a, int first, int last) {
		int x = 0, i = 0, j = 0;
		boolean flag=true;
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

	public static void swap(int[] b, int i, int j) {
		int temp = 0;
		temp = b[i];
		b[i] = b[j];
		b[j] = temp;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		FileReader inputfile = new FileReader("D://Algorithms//algosinput.txt");
		BufferedReader bufferedReader = new BufferedReader(inputfile);
		int x = Integer.parseInt(bufferedReader.readLine());
		int[] b = new int[x];
		for (int i = 0; i < x; i++) {
			b[i] = Integer.parseInt(bufferedReader.readLine());

		}
		File file = new File("D://Algorithms//quicksort.txt");

		if (!file.exists()) {
			file.createNewFile();
		}
		long starttime = System.currentTimeMillis();
		quickSort(b, 0, b.length - 1);
		long timetaken = System.nanoTime() - starttime;
		System.out.println("time taken is" + timetaken + " nano second");
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = 0; i < b.length; i++) {
			bw.write(b[i] + " ");

		}
		bw.close();
	}
}
