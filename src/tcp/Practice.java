package tcp;

import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T  = sc.nextInt();
		int arr[]= new int[T];
		for(int i = 0; i<T; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			arr[T] = (A+B);
		}
		System.out.println(arr[T]);
		
		
	}

}
