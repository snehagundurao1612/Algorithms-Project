package algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomisedQuickSort {
	public static void quickSort(int[] s, int f, int l) {

		if (f < l) {
			int randomIndex = randomizer(f, l);
			int q = partition(s, f, randomIndex, l);

			quickSort(s, f, q);
			quickSort(s, q + 1, l);

		}
	}

	public static int randomizer(int l, int r) {
		Random rand = new Random();
		if (r > 0) {
			int randomIndex = l+rand.nextInt(r-l+1);
			if (randomIndex >= l)
				return randomIndex;
			else
				return randomizer(l, r);
		} else
			return l;
	}
	public static int partition(int[] s, int first, int rand, int last) {
		int x = 0;
		int i = 0;
		int j = 0;
		x = s[rand];

		i = first - 1;

		j = last + 1;

		while (true) {
			i++;

			while (i < last && s[i] < x)
				i++;
			j--;
			while (j > first && s[j] > x)
				j--;

			if (i < j)
				swap(s, i, j);
			else
				return j;

		}

	}

	private static void swap(int[] a, int i, int j) {
		int temp = 0;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		FileReader inputfile = new FileReader("D://Algorithms//algosinput.txt");
		BufferedReader bufferedReader = new BufferedReader(inputfile);
		int x = Integer.parseInt(bufferedReader.readLine());
		int[] b = new int[x];

		for (int i = 0; i < x; i++) {
			b[i] = Integer.parseInt(bufferedReader.readLine());

		}
		File file = new File("D://Algorithms//Randomisedquicksort.txt");

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
