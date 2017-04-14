package algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class topkelements {
	public static void findTopElements(int[] b, int firstindex, int lastindex, int k) {
		int pivot = Quicksort.partition(b, firstindex, lastindex);
		if (pivot == k) {
			return;
		} else if (k < pivot) {
			findTopElements(b, firstindex, pivot - 1, k);
		} else {
			findTopElements(b, pivot + 1, lastindex, k);
		}

	}

	public static void main(String args[]) throws NumberFormatException, IOException {
		/*FileReader inputfile = new FileReader("D://algos.txt");
		BufferedReader bufferedReader = new BufferedReader(inputfile);
		int x = Integer.parseInt(bufferedReader.readLine());
		int[] b = new int[x];
		int k = Integer.parseInt(bufferedReader.readLine());
		for (int i = 0; i < x; i++) {
			b[i] = Integer.parseInt(bufferedReader.readLine());

		}
		File file = new File("D://Algorithms//topkelements.txt");

		if (!file.exists()) {
			file.createNewFile();
		}

		long starttime = System.currentTimeMillis();
		findTopElements(b, 0, b.length - 1, b.length - k);
		long timetaken = System.nanoTime() - starttime;
		System.out.println("time taken is" + timetaken + " nano second");
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = b.length - k; i <= b.length - 1; i++) {
			bw.write(b[i] + " ");

		}

		bw.close();*/
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A=new int[N];
        for(int i=0;i<N;i++){
           A[i]=sc.nextInt();
        }
        /*for(int i=0;i<N;i++){
            System.out.println(A[i]);
         }*/
        for(int i=N-1;i>=0;i--){
            System.out.print(A[i]);
        }
	}
}