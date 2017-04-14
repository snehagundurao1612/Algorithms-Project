package algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class KthsmallestLinear {
	public static int kthsmallestlinear(int[] b, int firstindex, int lastindex, int k) {
		int p = 0;
		if (k > 0 && k <= (lastindex - firstindex) + 1) {

			p = pivotFind(b, firstindex, lastindex);

			if (p - firstindex == k - 1) {

				return b[p];

			} else if (p - firstindex > k - 1) {
				return kthsmallestlinear(b, firstindex, p - 1, k);
			} else {
				return kthsmallestlinear(b, p + 1, lastindex, k - p + firstindex - 1);
			}
		}

		else {
			return 1;
		}

	}

	static int pivotFind(int b[], int first, int last) {
		int n = last - first + 1;
		int pivot = (int) (Math.random()) % n;
		swap(b, first + pivot, last);
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

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		FileReader inputfile = new FileReader("D://algos.txt");
		BufferedReader bufferedReader = new BufferedReader(inputfile);
		int x = Integer.parseInt(bufferedReader.readLine());
		int[] b = new int[x];
		int k = Integer.parseInt(bufferedReader.readLine());
		for (int i = 0; i < x; i++) {
			b[i] = Integer.parseInt(bufferedReader.readLine());

		}
		File file = new File("D://Algorithms//outputkthsmallestlinear.txt");

		if (!file.exists()) {
			file.createNewFile();
		}
		int firstindex = 0;
		int lastindex = b.length - 1;
		
		long start = System.currentTimeMillis(); // starting timer
		int smallest = kthsmallestlinear(b, firstindex, lastindex, k);
		long time = System.nanoTime() - start; // ending timer

		System.out.println(" time taken:" + time + " nano second");

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(smallest + " ");
		bw.close();
	}

}
