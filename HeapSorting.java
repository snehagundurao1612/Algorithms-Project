package algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HeapSorting {
	public static int[] a;
	public static int n;
	public static int leftnode;
	public static int rightnode;
	public static int greater;

	public static void smartbuildheap(int[] b) {
		n = b.length - 1;
		for (int i = n / 2; i >= 0; i--) {
			heapify(b, i);
		}
	}

	public static void heapify(int[] a, int i) {
		leftnode = 2 * i;
		rightnode = 2 * i + 1;

		if (leftnode <= n && a[leftnode] > a[i]) {
			greater = leftnode;
		} else {
			greater = i;
		}

		if (rightnode <= n && a[rightnode] > a[greater]) {
			greater = rightnode;
		}
		if (greater != i) {
			swap(i, greater);
			heapify(a, greater);
		}
	}

	public static void swap(int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void heapsort(int[] c) {
		a = c;
		smartbuildheap(a);

		for (int i = n; i > 0; i--) {
			swap(0, i);
			n = n - 1;
			heapify(a, 0);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		FileReader inputfile = new FileReader("D://Algorithms//algosinput.txt");
		BufferedReader bufferedReader = new BufferedReader(inputfile);
		int x = Integer.parseInt(bufferedReader.readLine());
		int[] b = new int[x];
		File file = new File("D://Algorithms//hello.txt");

		if (!file.exists()) {
			file.createNewFile();
		}

		for (int i = 0; i < x; i++) {
			b[i] = Integer.parseInt(bufferedReader.readLine());

		}
		long start = System.nanoTime(); // starting timer
		heapsort(b);
		long time = System.nanoTime() - start; // ending timer
		System.out.println("time taken:" + time + " nano second");
		

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = 1; i <= b.length - 1; i++) {
			bw.write(b[i] + " ");

		}

		bw.close();

	}
}
