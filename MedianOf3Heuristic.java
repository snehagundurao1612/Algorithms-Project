package algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MedianOf3Heuristic {

	public static void quickSort(int[] s, int f, int l) {

		if (f < l) {
			int[] randomIndex = new int[3];
			for (int i = 0; i < randomIndex.length; i++) {
				randomIndex[i] = RandomisedQuickSort.randomizer(f, l);
			}
			RandomisedQuickSort.quickSort(randomIndex, 0, 2);
			int rand = randomIndex[1];

			int q = RandomisedQuickSort.partition(s, f, rand, l);

			quickSort(s, f, q);
			quickSort(s, q + 1, l);

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		FileReader inputfile = new FileReader("D://Algorithms//algosinput.txt");
		BufferedReader bufferedReader = new BufferedReader(inputfile);
		int x = Integer.parseInt(bufferedReader.readLine());
		int[] b = new int[x];

		for (int i = 0; i < x; i++) {
			b[i] = Integer.parseInt(bufferedReader.readLine());

		}
		File file = new File("D://Algorithms//outputmedianof3hueristics.txt");

		if (!file.exists()) {
			file.createNewFile();
		}
		long start = System.nanoTime(); // starting timer
		quickSort(b, 0, b.length - 1);
		long time = System.nanoTime() - start; // ending timer
		System.out.println("time taken:" + time + " nano seconds");
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = 0; i < b.length; i++) {
			bw.write(b[i] + " ");

		}
		
		bw.close();
	}
}
